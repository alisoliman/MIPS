package Instructions;

public class Sw extends Iformat {
	
public Sw(int rs, int rt, int immediate) {
		
		this.rs = rs;
		this.rt = rt;
		this.immediate = immediate;
		regDst = false;
		branch = false;
	    MemRead = false;
		MemtReg = false;
		MemWrite = true;
		//aluOp;
		aluSrc = true;
		RegWrite = false;

	}

}
