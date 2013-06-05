package hardware;

public class BitAdder {

	public int t,s,p,g,cout;
	
	
	AndGate AndGate1=new AndGate();
	OrGate OrGate1 = new OrGate();
	
	/*public void halfadder(int a, int b){
		if(a==0)
			nota=1;
		if(b==0)
			notb=1;
		if((AndGate1.check(a, notb)==1)||(AndGate1.check(nota, b)==1))
			s=1;
	}*/
	
	public void bitAdd(int a, int b, int cin){
		HalfAdder HA1=new HalfAdder();
		HalfAdder HA2=new HalfAdder();
		
		t=HA1.halfAdd(a,b);
		s=HA2.halfAdd(t, cin);
		
		g=AndGate1.check(a,b);
		p=AndGate1.check(t, cin);
		
		cout=OrGate1.check(p, g);
	}
	
}
