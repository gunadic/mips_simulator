package hardware;

public class LengthCheck {

    public static String fillerLength(String input){
        if(input.length()<6)
        {
            while(input.length()<5)
                input = "0"+input;
        }
        return input;
    }
    
    public static String immLength(String input){
        if(input.length()<16)
        {
            while(input.length()<16)
                input = "0"+input;
        }
        return input;
    }
    
    public static String addLength(String input){
        if(input.length()<26)
            while(input.length()<26)
                input = "0"+input;
        return input;
    }
    
    public static String opsLength(String input){
        if(input.length()<6)
        {
            while(input.length()<6)
                input = "0"+input;
        }
        return input;
    }
	
}
