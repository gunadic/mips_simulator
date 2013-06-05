package hardware;

public class Memory {
	
    
	public String[] InstrMem = new String[50000];
	public String[] RegMem = new String[32];
	public String[] DataMem = new String[50000];
	public String RetData;
	public int InstrCnt=0;
	
	public void initialize(){
		for (int i=0;i<50000;i++){
			InstrMem[i]="00000000000000000000000000000000";
			DataMem[i]="00000000000000000000000000000000";
			}
		for (int i=0; i<32; i++){
			RegMem[i]="00000000000000000000000000000000";
		}
		InstrCnt=0;
	}
	
	public void addInstr(String Instruction){
		InstrMem[InstrCnt]=Instruction;
		InstrCnt++;
	}
	
	public String fetchReg(String regno){
		String regInfo;
		regInfo=RegMem[Integer.parseInt(regno, 2)];
		return regInfo;
	}
	
	public void writeReg(String info, String regno, int RegWrite){
		int reg = Integer.parseInt(regno, 2);
		if(reg==0 && RegWrite==1)
			System.out.println("Something tried to store in Register 0. NOT COOL!");
		if(reg!=0 && RegWrite==1)
			RegMem[reg]=info;
		
		
	}
	
	public void fetchDat(int address, int MemRead){
		String data;

		RetData = DataMem[address];
		
	}
	
	public void storeDat(int address, String data, int MemWrite){
		if(MemWrite==1){
			DataMem[address]=data;
			System.out.println("DATA Memory: "+ DataMem[address]);
		}
	}
	
	public void printReg(){
		
		for(int i=0; i<32; i++){
			System.out.println("--------------------");
			System.out.println(registers[i]+": "+toHex(RegMem[registerInts[i]])+"  "+registers[i+1]+": "+
					toHex(RegMem[registerInts[i+1]])+" "+registers[i+2]+": "+toHex(RegMem[registerInts[i+2]])
					+" "+registers[i+3]+": "+toHex(RegMem[registerInts[i+1]]));
			i=i+3;
			
		}
		
	}
	
    public static String toHex(String binary)
    {
        int binaryInt = Integer.parseInt(binary, 2);
        String temp = Integer.toHexString(binaryInt);
        if(temp.length()<8){
            while (temp.length()<8)
                temp = "0"+temp;
        }
        temp = "0x"+temp;
        return temp;
    }

	
	/*for (int i=0; i<32; i++){
		RegMem[i]="00000000";
	}*/
	
    public static String[] registers={"$zero","$at","$v0","$v1","$a0","$a1","$a2","$a3",
    	"$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7","$s0","$s1","$s2","$s3",
    	"$s4","$s5","$s6","$s7","$t8","$t9","$k0","$k1","$gp","$sp","$fp","$ra"};
    public static int[] registerInts={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,
    	20,21,22,23,24,25,26,27,28,29,30,31};
	
	

}