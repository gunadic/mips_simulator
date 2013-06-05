package hardware;

public class ALUCon {

	public int Binvert, ALU, Op;
	public void ALUOp(int a, int b, String funct, String op){
		int opint = Integer.parseInt(op,2);
		if(a==b && a==0)
			ALU=2;
		if(a<b && b==1){
			Binvert=1;
			ALU=2;
		}
		if(a==1 && b==0){
			int functint = Integer.parseInt(funct);
			switch(functint){
			case (32): 
				ALU=2;
				Binvert=0;
				break; 
			case (34): 
				ALU=2;
				Binvert=1;
				break;
			case (36): 
				ALU=0;
				Binvert=0;
				break;
			case (37): 
				ALU=1;
				Binvert=0;
				break;
			case (42): 
				ALU=3;
				Binvert=1;
				break;
			}
			if(opint==10)
			{
				ALU=3;
				Binvert=1;
			}
			
		}
		System.out.println("ALU  Op:" +ALU);
		System.out.println("Binvert:" +Binvert);
	}
}
