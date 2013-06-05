package datapath;

import hardware.*;
import java.util.Scanner;
import java.io.*;

public class FrontEnd {
	

    public static void main(String[] args) {

    	Datapath mainData = new Datapath();
    	mainData.Mem.initialize();
    	Scanner filein = new Scanner(System.in);
    	System.out.println("Enter Source File Name:");
    	String fileName = filein.nextLine();
    	Assembly_Parser AP = new Assembly_Parser();
    	
    	try{
        	FileInputStream inStream = new FileInputStream(fileName);
        	DataInputStream in = new DataInputStream(inStream);
        	BufferedReader br = new BufferedReader(new InputStreamReader(in));
        	String strLine;
            while ((strLine = br.readLine()) != null)   {
            		mainData.Mem.addInstr(AP.stringParser(strLine));
            	}
        	}
        	catch (Exception e){
        		System.out.println("Couldn't find the file");
        	}
        mainData.execute();
        	
    }
 
}
