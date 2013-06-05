package hardware;

public class ALU_1bit {
	
	AndGate AndGateALU = new AndGate();
	OrGate OrGateALU = new OrGate();
	BitAdder BitAdderALU = new BitAdder();
	Mux BInvertMUX = new Mux();
	Mux OpMux = new Mux();
	
	public int carry = 0, notb, sum, and, or, count, lss;
	
	public int ALU(int a, int b, int Binvert, int Operation){
		if(b==0)
			notb=1;
		else
			notb=0;
		if(Binvert==1){
			b=notb;
			if(count==31)
				carry=1;				
		}
		BitAdderALU.bitAdd(a, b, carry);
		sum = BitAdderALU.s;
		carry = BitAdderALU.cout;
		return  OpMux.Pick4(AndGateALU.check(a,b), OrGateALU.check(a, b), sum, lss, Operation);
			
	}
	

}
