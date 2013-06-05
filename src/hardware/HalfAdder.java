package hardware;

public class HalfAdder {

	public int nota=0, notb=0, ora, orb;
	
	AndGate AndGateHalf= new AndGate();
	OrGate OrGateHalf= new OrGate();
	
	
	public int halfAdd(int a, int b){
		if(a==0)
			nota=1;
		if(b==0)
			notb=1;
		
		ora=AndGateHalf.check(a, notb);
		orb=AndGateHalf.check(nota, b);
		
		if(OrGateHalf.check(ora, orb)==1)
			return 1;
		else
			return 0;
	}
}
