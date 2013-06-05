package hardware;



public class Controller {

	public int RegDst, ALUSrc, MemtoReg, RegWrite, MemRead, MemWrite, Branch, ALUOp1, ALUOp0, Jump;
	int opint;
	public void Oracle(String opcode){
		
		opint=Integer.parseInt(opcode, 2);
		//System.out.println("OpCode is equal to:"+opint);
		switch(opint){
		case(0):
			RegDst=1;
			Jump=0;
			ALUSrc=0;
			MemtoReg=0;
			RegWrite=1;
			MemRead=0;
			MemWrite=0;
			Branch=0;
			ALUOp1=1;
			ALUOp0=0;
			break;
		case(2):
			Jump=1;
			RegDst=1;
			ALUSrc=0;
			MemtoReg=0;
			RegWrite=1;
			MemRead=0;
			MemWrite=0;
			Branch=0;
			ALUOp1=0;
			ALUOp0=0; 
			break;
		case(4):
			RegDst=0;
			Jump=0;
			ALUSrc=0;
			MemtoReg=0;
			RegWrite=0;
			MemRead=0;
			MemWrite=0;
			Branch=1;
			ALUOp1=0;
			ALUOp0=1;
			break;
		case(8):
			System.out.println("Its a addi!");
			RegDst=0;
			Jump=0;
			ALUSrc=1;
			MemtoReg=0;
			RegWrite=1;
			MemRead=0;
			MemWrite=0;
			Branch=0;
			ALUOp1=0;
			ALUOp0=0;
			break;
		case(10):
			RegDst=0;
			ALUSrc=1;
			MemtoReg=0;
			RegWrite=1;
			MemRead=0;
			MemWrite=0;
			Branch=0;
			ALUOp1=1;
			ALUOp0=0;
			break;
		case(35):
			System.out.println("Whoops");
			RegDst=0;
			ALUSrc=1;
			MemtoReg=1;
			RegWrite=1;
			MemRead=1;
			Jump=0;
			MemWrite=0;
			Branch=0;
			ALUOp1=0;
			ALUOp0=0;
			break;
		case(43):
			RegDst=0;
			Jump=0;
			ALUSrc=1;
			MemtoReg=0;
			RegWrite=0;
			MemRead=0;
			MemWrite=1;
			Branch=0;
			ALUOp1=0;
			ALUOp0=0;
			break;
		}
		
		System.out.println("Controls:");
		System.out.printf("| RegDst: %d | Jump: %d | ALUSrc: %d | MemtoReg: %d | RegWrite: %d\n| MemRead %d |" +
				" MemWrite: %d | Branch: %d | ALUOp1: %d | ALUOp0: %d \n", RegDst,Jump,ALUSrc,MemtoReg,RegWrite,
				MemRead,MemWrite,Branch,ALUOp1,ALUOp0);
		
		
	}
}
