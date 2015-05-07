package Instructions;

public class Beq extends Iformat {
	
public Beq(int rs, int rt, int immediate) {
		
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
