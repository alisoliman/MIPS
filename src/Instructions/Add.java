package Instructions;

public class Add extends Rformat{

	
	public Add(int rs, int rt, int rd) {
		
		this.rs = rs;
		this.rt = rt;
		this.rd = rd;
		regDst = true;
		branch = false;
	    MemRead = false;
		MemtReg = false;
		MemWrite = false;
		//aluOp;
		aluSrc = false;
		RegWrite = true;

	}
	
	

}
