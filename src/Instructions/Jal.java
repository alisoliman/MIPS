package Instructions;

public class Jal extends Jformat {
	
	public Jal(int address) {
		

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
