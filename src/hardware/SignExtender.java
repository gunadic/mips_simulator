package hardware;

public class SignExtender {
	
	public String extend(String in){
		
		String a;
		if (in.charAt(0)=='0')
			a="0";
		else 
			a="1";
		while(in.length()<32){
			in = a+in;			
		}
		
		return in;
	}
}
