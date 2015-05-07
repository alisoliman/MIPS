package Instructions;

public class Lb extends Iformat {
	
	
public Lb(int rs, int rt, int immediate) {
		
		this.rs = rs;
		this.rt = rt;
		this.immediate = immediate;
		regDst = false;
		branch = false;
	    MemRead = true;
		MemtReg = true;
		MemWrite = false;
		//aluOp;
		aluSrc = true;
		RegWrite = true;

	}

}
