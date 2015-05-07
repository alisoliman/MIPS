package components;

import java.util.ArrayList;

public class Registers {
	
	ArrayList<Integer> reg = new ArrayList<>();

	public Registers() {
		for (int i = 0 ; i< 32; i++)
		{
			reg.add(i,0);
		}
	}

	public ArrayList<Integer> getReg() {
		return reg;
	}

	public void setReg(int index, int value) {
		reg.set(index, value);
	}
	
	
}
