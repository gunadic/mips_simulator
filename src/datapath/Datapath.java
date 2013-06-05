package datapath;

import hardware.ALUCon;
import hardware.ALU_32bit;
import hardware.AndGate;
import hardware.Controller;
import hardware.Memory;
import hardware.Mux;
import hardware.Shifter;
import hardware.SignExtender;

import java.util.Scanner;

public class Datapath {

	public String PC = "00000000000000000000000000000000";
	public String four = "00000000000000000000000000000100";
	ALU_32bit PCAlu = new ALU_32bit();
	ALU_32bit MainALU = new ALU_32bit();
	ALU_32bit BranchALU = new ALU_32bit();
	public Memory Mem = new Memory();
	Controller Control = new Controller();
	ALUCon ACon = new ALUCon();
	Mux MP = new Mux();
	SignExtender SE = new SignExtender();
	Shifter SL2 = new Shifter();
	AndGate	And = new AndGate();
	
	public void execute(){

	    Scanner sc = new Scanner(System.in);

		String instr, opcode, imm, funct, rs, rt, rd, shamt, addr, wreg, readr1, readr2,
			data1, data2, ALUin2, ALUResult, half, fetcheData, ToReg, JAdd, JAddFr,
			BranchPC, BranchImm;
		int DataAddress, PCSrc, PCint;
		PCint=Integer.parseInt(PC,2);
		instr = Mem.InstrMem[PCint/4];
		System.out.println(instr);
		//System.out.println("PCint: "+PCint);

		while(PCint/4<=Mem.InstrCnt-1){

		PCAlu.ALU32(PC, four, 0, 2);
		PC=PCAlu.out;
		PCint=Integer.parseInt(PC,2);
		//System.out.println("PC int value: "+PCint);
		
		//Separate the string into every division possible.
		opcode = instr.substring(0,6);
		System.out.println("This commands opcode: "+opcode);
		imm = instr.substring(16,32);
		JAdd=instr.substring(6, 32);
		rs = instr.substring(6, 11);
		rt = instr.substring(11, 16);
		rd = instr.substring(16, 21);
		shamt = instr.substring(21, 26);
		addr = instr.substring(6, 32);
		funct = instr.substring(26,32);
		
		//send the opcode to the Oracle to set controls.
		Control.Oracle(opcode);
		
		//retrieve contents of Read Registers 1&2
		readr1=rs;
		readr2=rt;
		data1=Mem.fetchReg(readr1);
		data2=Mem.fetchReg(readr2);
		
		//determine whether rt or rd becomes write reg based on Control
		wreg=MP.PickString(rt, rd, Control.RegDst);
		
		//determine what the ALU controls are
		ACon.ALUOp(Control.ALUOp1, Control.ALUOp0, funct, opcode);
		imm = SE.extend(imm);
		
		//determine if 2nd alu input is sign-extended immediate or from reg
		ALUin2=MP.PickString(data2, imm, Control.ALUSrc);
		System.out.println("ALU Input 1: "+data1);
		System.out.println("ALU Input 2: "+ALUin2);
		MainALU.ALU32(data1, ALUin2, ACon.Binvert, ACon.ALU);
		System.out.println("ALU OpCode"+ACon.ALU);
		ALUResult=MainALU.out;
		System.out.println("ALUResult: "+ALUResult);
		
		
		
		DataAddress = Integer.parseInt(ALUResult,2);
		if(Control.MemWrite==1){
			System.out.println("DataAddress: "+DataAddress);
		}
		
		
		Mem.storeDat(DataAddress, data2, Control.MemWrite);
		Mem.fetchDat(DataAddress, Control.MemRead);
		fetcheData= Mem.RetData;
		System.out.println("This is the MemtoReg "+Control.MemtoReg);
		ToReg = MP.PickString(ALUResult, fetcheData, Control.MemtoReg);
		System.out.println("This is whats being sent to the registers: "+ToReg);
		System.out.println("This is the RegWrite: "+Control.RegWrite);
		Mem.writeReg(ToReg, wreg, Control.RegWrite);
		Mem.printReg();
		
		JAdd=SE.extend(JAdd);
		JAdd=PC.substring(0,4)+JAdd;
		BranchImm=SL2.shift(imm);
		BranchALU.ALU32(BranchImm, PC, 0, 2);
		BranchPC=BranchALU.out;
		PCSrc = And.check(Control.Branch, MainALU.zero);
		BranchPC=MP.PickString(PC, BranchPC, PCSrc);
		PC = MP.PickString(BranchPC, JAdd, Control.Jump);
		System.out.println("---------------------Instruction Completed-----------------------");
		

		instr = Mem.InstrMem[PCint/4];
		/*if(PCSrc==1){
			instr=Mem.InstrMem[(Integer.parseInt(BranchPC,2)/4)];
			PC=BranchPC;
		}*/
		System.out.println("Hit Enter for next instruction.");
	    sc.nextLine();
		}
		System.out.println("Actually... we're done.");
	}
	
	
}
