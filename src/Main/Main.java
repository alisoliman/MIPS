package Main;

import java.util.ArrayList;
import java.util.Scanner;


import Instructions.*;


import components.Alu;
import components.Memory;
import components.Registers;

public class Main {
	


	public static void main (String []args)
	{
		Parser p = new Parser();
		ArrayList<Instruction> ins = p.input();
		NoInstruction neutral = new NoInstruction();
		Instruction IF_ID = neutral;
		Instruction ID_EX = neutral;
		Instruction EX_MEM = neutral;
		Instruction MEM_WB = neutral;;
		
		Alu alu = new Alu();
		Memory memory = new Memory();
		Registers registers = new Registers();

		registers.setReg(8, 6);
		registers.setReg(9, 7);
		memory.setInstructionMemory(ins);
		

	    int rs = 0;
	    int rt = 0;
	    int immediate = 0;
	    int memRead = 0;
	    int cycles = 0;
	    
		for (int i = 0 ; i < memory.getInstructionMemory().size() + 4;i++)
		{
			cycles++;
			//regWrite control signal
			System.out.println("RegWrite :" + MEM_WB.isRegWrite());
			System.out.println("RegDst :" + MEM_WB.isRegDst());
			System.out.println("MemtReg :" + MEM_WB.isMemtReg());
			if (MEM_WB.isRegWrite())
			{
				//RegDst control signal
				if (MEM_WB.isRegDst())
				{
					if (MEM_WB.getRd() != 0)
						registers.setReg(MEM_WB.getRd(), MEM_WB.getResult());
				}
				else
				{
					
                //memtReg control signal
					if (MEM_WB.isMemtReg())
					{
						if (MEM_WB.getRt() != 0)
							registers.setReg(MEM_WB.getRt(),memRead);
					}
					else
					{
						if (MEM_WB.getRt() != 0)
							registers.setReg(MEM_WB.getRt(), MEM_WB.getResult());
					}
				}
			}
			System.out.println("MemRead :" + EX_MEM.isMemRead());
			//memRead control signal
			if (EX_MEM.isMemRead())
			{
				memRead = memory.dataMemory.get(EX_MEM.getResult());
				if (EX_MEM instanceof Lb)
				{
					memRead = getByte(memRead);
				}
				if (EX_MEM instanceof Lbu)
				{
					memRead = alu.unsigned(getByte(memRead));
				}
			}
			System.out.println("MemWrite :" + EX_MEM.isMemWrite());
			//memWrite control signal
			if (EX_MEM.isMemWrite())
			{
				System.out.println(EX_MEM.getRs());
			
				if (EX_MEM instanceof Sb)
				{
					memory.dataMemory.set(EX_MEM.getResult(),setByte(registers.getReg().get(EX_MEM.getRs())));
				}
				else
				{
					memory.dataMemory.set(EX_MEM.getResult(),registers.getReg().get(EX_MEM.getRs()));
				}
			}
			System.out.println("AluSrc :" + ID_EX.isAluSrc());
			System.out.println("AluOP :" + ID_EX.getClass());
			System.out.println("Branch :" + ID_EX.isBranch());
			System.out.println("Jump :" + ID_EX.isJump());
			//aluSrc control signal
			if (ID_EX.isAluSrc())
			{
				//branch control signal
				if (ID_EX.isBranch())
				{
					if (alu.zero(rs, rt,ID_EX.getClass().toString()))
					{
						IF_ID = neutral;
						i -= 2;
						i += immediate;
					}
				}
				else
				{
					if (ID_EX instanceof Lui)
					{
						ID_EX.setResult(alu.execute(rs, immediate, ID_EX.getClass().toString()));
					}
					else
					{
						ID_EX.setResult(alu.execute(rs, immediate, ID_EX.getClass().toString()));
					}
				}
			}
			else
			{
				//jump control signal
				if (!ID_EX.isJump())
					ID_EX.setResult(alu.execute(rs, rt, ID_EX.getClass().toString()));

			}
			
			if (IF_ID instanceof Rformat)
			{
				rs = registers.getReg().get(IF_ID.getRs());
				if (IF_ID instanceof Sll || IF_ID instanceof Srl)
				{
				    rt = IF_ID.getShift();
				}
				else
				{
					rt = registers.getReg().get(IF_ID.getRt());
				}
			}
			
			if (IF_ID instanceof Iformat)
			{
				rs = registers.getReg().get(IF_ID.getRs());
				rt = registers.getReg().get(IF_ID.getRt());
				immediate = IF_ID.getImmediate();
			}
			
			if (IF_ID instanceof Jformat)
			{
				
				if (IF_ID instanceof J)
				{
					i = IF_ID.getAdress();
				}
				if (IF_ID instanceof Jal)
				{
					registers.setReg(31, i);
					i = IF_ID.getAdress();
				}
				
				if (IF_ID instanceof Jr)
				{
				   i = registers.getReg().get(31);
				}
			}
			
			System.out.println(registers.getReg());
			
			MEM_WB = EX_MEM;
			EX_MEM = ID_EX;
			ID_EX = IF_ID;
			if (i < memory.getInstructionMemory().size())
				IF_ID = memory.getInstructionMemory().get(i);
			else
			{
				IF_ID = neutral;
			}
			System.out.println("IF_ID: " + IF_ID.getClass());
			System.out.println("ID_EX: " + ID_EX.getClass());
			System.out.println("EX_MEM: "+ EX_MEM.getClass());
			System.out.println("MEM_WB: "+ MEM_WB.getClass());
			Scanner sc = new Scanner(System.in);
			String sentence = sc.nextLine();
			
		}
		System.out.println("Cycles: " + cycles);
	}

	
	public static int getByte (int x)
	{
		String s = Integer.toBinaryString(x);
		String s2 = "0";
		for (int i = s.length(); i < 32;i++)
		{
			s2 = "0";
			s2 += s;
			s = s2;
		}
		s2 = s.substring(0, 8);
		int foo = Integer.parseInt(s2, 2);
		return foo;
	}
	
	public static int setByte (int x)
	{
		String s = Integer.toBinaryString(x);
		String s2 = "0";
		for (int i = s.length(); i < 8;i++)
		{
			s2 = "0";
			s2 += s;
			s = s2;
		}
		for (int i = s.length(); i < 32;i++)
		{
			s2 += "0";
		}
		int foo = Integer.parseInt(s2, 2);
		return foo;
	}
}