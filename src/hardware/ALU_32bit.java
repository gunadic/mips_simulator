package hardware;

public class ALU_32bit {
	
	public int[] Bins32 = new int[32];
	public int zero;
	public String out;
	
	public void ALU32(String stringa,String stringb, int binvert, int op) {
		
		
		int[] a32,b32, bins32;
		a32 = new int[32];
		b32 = new int[32];
		bins32 = new int[32];
		int vala, valb;

		
		for(int i=0; i<32; i++){
			a32[i]=Integer.parseInt(Character.toString(stringa.charAt(i)));
			b32[i]=Integer.parseInt(Character.toString(stringb.charAt(i)));

		}
		ALU_1bit LoopALU = new ALU_1bit();

		
		for(int i=31; i>=0; i--){
			if(i==31)
				zero=1;
			LoopALU.count=i;
			bins32[i]=LoopALU.ALU(a32[i], b32[i], binvert, op);
			Bins32[i]=bins32[i];
			if (Bins32[i]>0)
				zero=0;			
			if(i==31){
				if(bins32[i]==1)
					out = "1";
				else if(bins32[i]==0)
					out = "0";
			}
			if(i<31){
				if(bins32[i]==1)
					out = "1"+out;
				else if(bins32[i]==0)
					out = "0"+out;
			}
		}
			
		if(binvert==1 && op==3){
			vala=Integer.parseInt(stringa,2);
			valb=Integer.parseInt(stringb,2);
			if(vala<valb)
				out="00000000000000000000000000000001";
			else if(vala>=valb)
				out="00000000000000000000000000000000";
		}

		
	}

}
