package Instructions;

public class Lui extends Iformat {
	
public Lui (int rt, int immediate) {
		
		this.rt = rt;
		this.immediate = immediate;
		regDst = false;
		branch = false;
	    MemRead = false;
		MemtReg = false;
		MemWrite = false;
		//aluOp;
		aluSrc = true;
		RegWrite = true;

	}

}
