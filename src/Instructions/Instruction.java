package Instructions;

public abstract class Instruction {
	
	boolean regDst;
	boolean branch;
	boolean MemRead;
	boolean MemtReg;
	boolean MemWrite;
	boolean aluOp;
	boolean aluSrc;
	boolean RegWrite;
	boolean jump = false;
	
	public boolean isJump() {
		return jump;
	}
	public void setJump(boolean jump) {
		this.jump = jump;
	}
	int result = 0; 
	
	 public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Instruction()
	 {
		 
	 }
    public int getRs() {
    	return 0;
    }
	
	 public int getRt() {
		return 0;
	}
	
	public int getRd() {
		return 0 ;
	}
	
	public int getImmediate() {
		return 0 ;
	}

	public int getAdress() {
		return 0 ;
	}
	public boolean isRegDst() {
		return regDst;
	}
	public void setRegDst(boolean regDst) {
		this.regDst = regDst;
	}
	public boolean isBranch() {
		return branch;
	}
	public void setBranch(boolean branch) {
		this.branch = branch;
	}
	public boolean isMemRead() {
		return MemRead;
	}
	public void setMemRead(boolean memRead) {
		MemRead = memRead;
	}
	public boolean isMemtReg() {
		return MemtReg;
	}
	public void setMemtReg(boolean memtReg) {
		MemtReg = memtReg;
	}
	public boolean isMemWrite() {
		return MemWrite;
	}
	public void setMemWrite(boolean memWrite) {
		MemWrite = memWrite;
	}
	public boolean isAluOp() {
		return aluOp;
	}
	public void setAluOp(boolean aluOp) {
		this.aluOp = aluOp;
	}
	public boolean isAluSrc() {
		return aluSrc;
	}
	public void setAluSrc(boolean aluSrc) {
		this.aluSrc = aluSrc;
	}
	public boolean isRegWrite() {
		return RegWrite;
	}
	public void setRegWrite(boolean regWrite) {
		RegWrite = regWrite;
	}
	public int getShift() {
		return 0;
	}
	public void setShift(int shift) {
		
	}

}
