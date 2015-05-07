package Instructions;

public class Sll extends Rformat {
	
	
	public Sll(int rs, int shift, int rd) {
		
		this.rs = rs;
		this.shift = shift;
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
