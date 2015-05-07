package Instructions;

public class Bne extends Iformat {
	
public Bne(int rs, int rt, int immediate) {
		
		this.rs = rs;
		this.rt = rt;
		this.immediate = immediate;
		regDst = false;
		branch = true;
	    MemRead = false;
		MemtReg = false;
		MemWrite = false;
		//aluOp;
		aluSrc = true;
		RegWrite = false;

	}

}
