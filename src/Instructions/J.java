package Instructions;

public class J extends Jformat {

	public J(int address) {
		

		this.adress = address;
		regDst = false;
		branch = false;
	    MemRead = false;
		MemtReg = false;
		MemWrite = false;
		//aluOp;
		aluSrc = false;
		RegWrite = false;
		jump = true;

	}
}
