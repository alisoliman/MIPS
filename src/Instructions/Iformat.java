package Instructions;

public abstract class Iformat extends Instruction {
	
	int rs;
	int rt;
	int immediate;
	
	public int getRs() {
		return rs;
	}
	public void setRs(int rs) {
		this.rs = rs;
	}
	public int getRt() {
		return rt;
	}
	public void setRt(int rt) {
		this.rt = rt;
	}
	public int getImmediate() {
		return immediate;
	}
	public void setImmediate(int immediate) {
		this.immediate = immediate;
	}

}
