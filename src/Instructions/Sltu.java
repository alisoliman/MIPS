package Instructions;

public class Sltu extends Rformat {
	
	public Sltu(int rs, int rt, int rd) {
		
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
