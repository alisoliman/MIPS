package Instructions;

public class Sub extends Rformat {
		
public Sub(int rs, int rt, int rd) {
		
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
