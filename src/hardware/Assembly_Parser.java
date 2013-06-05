package hardware;

import java.util.Scanner;
import java.lang.*;
import java.io.*;


public class Assembly_Parser {

	public String stringParser(String unparsedAssembly) {
		String[] parsed = unparsedAssembly.split(" ");
        String ops = parsed[0],rs, rt, rd, shamt, binString = null;
        int Opcode = 0, funct, immediate;
        //LengthCheck checker = new LengthCheck();
        
        for(int i = 0; i<rType.length; i++){
        	if (ops.equalsIgnoreCase(rType[i]))
        	{
        		
                parsed = parsed[1].split(",");
                for(int j = 0; j<parsed.length; j++)
                	parsed[j] = parsed[j].trim();
                rs = parsed[1];
                rt = parsed[2];
                rd = parsed[0];
                rs = LengthCheck.fillerLength(toBinary(registerNum(rs)));
                rt = LengthCheck.fillerLength(toBinary(registerNum(rt)));
                rd = LengthCheck.fillerLength(toBinary(registerNum(rd)));
                ops = LengthCheck.opsLength(toBinary(rTypeFunctcodes[i]));
                shamt = LengthCheck.fillerLength(toBinary(0));
                binString = "000000"+rs+rt+rd+shamt+ops;
                
        	}
        }
        
        for(int i = 0; i<iType.length; i++){
        	if(ops.equalsIgnoreCase(iType[i]))
        	{
        		if(iType[i]=="sw"||iType[i]=="lw"){
        			String[] funzies;
        			parsed = parsed[1].split("[,() ]+");
        			rs=parsed[2];
        			rt=parsed[0];
        			immediate=Integer.parseInt(parsed[1]);
        		}
        		else{
        			String[] nocommas;
        		/*	System.out.println(parsed[0]);
        			System.out.println(parsed[1]);
        			System.out.println(parsed[2]);
        			System.out.println(parsed[3]);*/
        			
        			nocommas = parsed[1].split(",");
        			rs=nocommas[1];
        			//System.out.println(rs);
        			//nocommas = parsed[2].split(",");
        			rt=nocommas[0];
        			//nocommas = parsed[3].split(" ");
        			immediate=Integer.parseInt(nocommas[2]);
        			//System.out.println(nocommas[0]);
        			
        		}
        			
                rs = LengthCheck.fillerLength(toBinary(registerNum(rs)));
                rt = LengthCheck.fillerLength(toBinary(registerNum(rt)));
                ops = LengthCheck.opsLength(toBinary(iTypeOpcodes[i]));
                String imme = Integer.toBinaryString(immediate);
                imme = LengthCheck.immLength(imme);
                binString = ops + rs + rt + imme; 		
        	} 	
        }
        
        for(int i = 0; i<jType.length; i++){
        	if(ops.equalsIgnoreCase(jType[i]))
        	{
                //address = Integer.parseInt(parsed[1]);
                String address = Integer.toBinaryString(Integer.parseInt(parsed[1]));
                address = LengthCheck.addLength(address);
                ops = LengthCheck.opsLength(toBinary(jTypeOpcodes[i]));
                binString = ops + address;
        	}	
        }
		
		
		return binString;
	}
	
    static int registerNum(String register){
        for(int i = 0; i<registers.length; i++){
            if(register.equals(registers[i])){
                //System.out.println(registerInts[i]);
                return registerInts[i];
            }
        }
        return 0;
    }
	
    public static String toBinary(int toConvert)
    {
        return Integer.toBinaryString(toConvert);
    }
    
    static String[] iType={"lw","sw","addi","ori","andi","slti"};
    static int[] iTypeOpcodes={35,43,8,13,12,10};
    static String[] rType={"add","sub","slt","sll","srl","and","or","jr"};
    static int[] rTypeFunctcodes={32,34,42,0,2,36,37,8};
    static String[] jType={"j","jal"};
    static int[] jTypeOpcodes={2,3};
    static String[] registers={"$zero","$at","$v0","$v1","$a0","$a1","$a2","$a3","$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7","$s0","$s1","$s2","$s3","$s4","$s5","$s6","$s7","$t8","$t9","$k0","$k1","$gp","$sp","$fp","$ra"};
    static int[] registerInts={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
	
}
