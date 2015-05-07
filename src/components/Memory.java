package components;

import java.util.ArrayList;

import Instructions.Instruction;

public class Memory {
	
	public ArrayList<Integer> dataMemory =new ArrayList<Integer>();
	ArrayList<Instruction> instructionMemory =new ArrayList<Instruction>();
	
	
	public Memory()
	{
		for (int i = 0;i<100;i++)
		{
			dataMemory.add(0);
		}
	}
	
	
	public ArrayList<Integer> getDataMemory() {
		return dataMemory;
	}
	public void setDataMemory(ArrayList<Integer> dataMemory) {
		this.dataMemory = dataMemory;
	}
	public ArrayList<Instruction> getInstructionMemory() {
		return instructionMemory;
	}
	public void setInstructionMemory(ArrayList<Instruction> instructionMemory) {
		this.instructionMemory = instructionMemory;
	}

}
