package Instructions;

public class And extends Rformat {
	
	public And (int rs, int rt, int rd) {
		
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
