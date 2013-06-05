package hardware;


public class Mux {

	public int Pick2(int a, int b, int control){
		if (control==0)
			return a;
		else if (control == 1)
			return b;
		else
			return 0;
	}
	
	public int Pick4(int a, int b, int c, int d, int control){
		if (control==0)
			return a;
		if (control==1)
			return b;
		if (control==2)
			return c;
		if (control==3)
			return d;
		else
			return 0;
		
	}
	public String PickString(String a, String b, int control){
		if(control ==0)
			return a;
		if(control == 1)
			return b;
		else
			return"y";
		
	}
	
}
