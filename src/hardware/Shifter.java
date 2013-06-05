package hardware;

public class Shifter {
	
	public String shift(String input){
		input = input + "00";
		String out;
		out = input.substring(2);
		return out;
	}

}
