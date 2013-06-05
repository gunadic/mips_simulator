package hardware;

public class Main {

	public static char chara32[];

	
	public static void main(String[] args){
	ALU_1bit funzies = new ALU_1bit();
	AndGate funzies1 = new AndGate();
	OrGate funzies2 = new OrGate();
	HalfAdder halfFunzies = new HalfAdder();
	BitAdder fullFunzies = new BitAdder();
	ALU_32bit funzies32 = new ALU_32bit();
	SignExtender Sextend = new SignExtender();
	Shifter shift2 = new Shifter();
	Controller Control = new Controller();
	
	String tempa = "00000000000000000000000000000001";
	String tempb = "00000000000000000000000000000000";
	String tempc = "00110000101010111101010101111010";
	String tempd; 
	
	tempd = tempc.substring(6, 32);
	System.out.println(tempd);
	
	
	
	/*String goddamn = Sextend.extend(tempd);
	
	System.out.println(goddamn);
	
	
	
	
	/*funzies32.ALU32(tempa, tempb, 0,2);
	for(int i=0; i<32; i++){
		System.out.print(funzies32.Bins32[i]);
	}
	
	System.out.println(" ");
	System.out.println(funzies32.zero);

	
	
	
	//System.out.println(funzies.ALU(1, 1, 0, 0, 2));
	
	
	/*funzies32.ALU32(tempa, tempb, 0, 0);
	for (int i=0; i<32; i++){
		System.out.print(funzies32.Bins32[i]);
	}
	
	/*int test = funzies1.check(1,1);
	
	int[] a32, b32;
	a32 = new int[32];
	b32 = new int[32];
	


	//System.out.println(tempa.charAt(31));
	char aChar = tempa.charAt(31);
	a32[0]=Integer.parseInt(Character.toString(tempa.charAt(31)));
	//System.out.println(a32[0]);
	
	funzies32.ALU32(tempa, tempb, 0, 2);
	/*for(int i=0; i<32; i++)
		System.out.print(funzies32.Bins32[i]);
	
	
/*	for(int i=0; i<32; i++){
		a32[i]=Integer.parseInt(Character.toString(tempa.charAt(i)));
		System.out.print(a32[i]);
		//b32[i]=Integer.parseInt(Character.toString(tempa.charAt(i)));
	}
	
	/*for(int i=0; i<32; i++){
		chara32[i]=tempa.charAt(i);
		charb32[i]=tempb.charAt(i);
		System.out.print(chara32[i]);
		a32[i]=Integer.parseInt(Character.toString(chara32[i]));
		b32[i]=Integer.parseInt(Character.toString(charb32[i]));
	}*/
	
	
	}
}
