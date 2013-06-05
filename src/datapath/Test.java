package datapath;

import hardware.*;

public class Test {
	
	
	
	public static void main(String[] args){
		
		Datapath tester = new Datapath();
		Assembly_Parser AP = new Assembly_Parser();
		
		tester.Mem.initialize();
		tester.Mem.RegMem[16]="00000000000000000000000000000010";
		tester.Mem.RegMem[17]="00000000000000000000000000000001";
		tester.Mem.RegMem[18]="00000000000000000000000000000001";
		
		//System.out.println("Register $s0: "+tester.Mem.RegMem[16]);
		//System.out.println("Register $s1: "+tester.Mem.RegMem[17]);
		
		String instr1,instr2,instr3,instr4,instr5,instr6;
		instr1 = AP.stringParser("addi $s3,$s1,3");
		instr2 = AP.stringParser("addi $s3,$s0,3");
		//instr2 = AP.stringParser("beq $s0,$s1,$s1");
		//instr3 = AP.stringParser("addi $t2,$s0,4");
		//instr4 = AP.stringParser("addi $t3,$t2,4");
		tester.Mem.addInstr(instr1);
		tester.Mem.addInstr(instr2);
		//tester.Mem.addInstr(instr2);
		//tester.Mem.addInstr(instr3);
		//tester.Mem.addInstr(instr4);

		tester.execute();

		//tester.execute();
		

		/*String instr, instr2;
		Assembly_Parser AP = new Assembly_Parser();
		instr=AP.stringParser("or $s2,$s1,$s0");
		tester.Mem.addInstr(instr);
		instr2=tester.Mem.InstrMem[Integer.parseInt(tester.PC,2)];
		tester.execute();
		
		System.out.println("---Instruction Complete: Next Instruction---");
		
		System.out.println("Contents of register $s2: "+tester.Mem.RegMem[18]);
		
		instr=AP.stringParser("sw $s2,0($s1)");
		tester.Mem.addInstr(instr);
		tester.execute();*/
		

	}

}
