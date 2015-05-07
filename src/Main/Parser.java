
package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Instructions.*;

public class Parser {

	
	public static int mipsCases(String x)
	{
		int rsN = 0;
		x = x.toLowerCase();
		switch (x) 
		{
		case "$0": rsN = 0;
		break;
		case "$zero": rsN = 0;
		break;
		
		case "$v0": rsN = 2;
		break;
		case "$v1": rsN = 3;
		break;
		
		case "$a0": rsN = 4;
		break;
		case "$a1": rsN = 5;
		break;
		case "$a2": rsN = 6;
		break;
		case "$a3": rsN = 7;
		break;
		
		case "$t0": rsN = 8;
		break;
		case "$t1": rsN = 9;
		break;
		case "$t2": rsN = 10;
		break;
		case "$t3": rsN = 11;
		break;
		case "$t4": rsN = 12;
		break;
		case "$t5": rsN = 13;
		break;
		case "$t6": rsN = 14;
		break;
		case "$t7": rsN = 15;
		break;
		case "$t8": rsN = 24;
		break;
		case "$t9": rsN = 25;
		break;
		
		case "$s0": rsN = 16;
		break;
		case "$s1": rsN = 17;
		break;
		case "$s2": rsN = 18;
		break;
		case "$s3": rsN = 19;
		break;
		case "$s4": rsN = 20;
		break;
		case "$s5": rsN = 21;
		break;
		case "$s6": rsN = 22;
		break;
		case "$s7": rsN = 23;
		break;
		
		case "$gp": rsN = 28;
		break;
		
		case "$sp": rsN = 29;
		break;
		
		case "$fp": rsN = 30;
		break;
		
		default: rsN = 679;
		break;
		}
		return rsN ;
	}
	
	public ArrayList<Instruction> input()
	{
		ArrayList<Instruction> ins = new ArrayList<Instruction>();
		Scanner input = new Scanner(System.in);
		String x = input.nextLine();
		
		String op = "";
		String rs = "";
		String rt = "";
		String rd = "";
		String ra = "";
		String baseRegister ="";
		String offset = "";
		String num ="";
		String label = "";

		
		x = x.toLowerCase();
		for(int i = 0; i < x.length(); i++)
		{
			
				
				while(x.charAt(i) != ' ')
				{
					op += x.charAt(i);
					i++;
				}
				i++;
				
				if(op.equals("add") || op.equals("sub") || op.equals("slt") 
						|| op.equals("sltu") || op.equals("and") || op.equals("nor") )
				{
					
					if(x.charAt(i) == '$')
					{
						while(x.charAt(i) != ',')
						{
							rd += x.charAt(i);
							i++;
						}
					}
					
					i++;
					i++;
					
					if(x.charAt(i) == '$')
					{
						while(x.charAt(i) != ',')
						{
							rs += x.charAt(i);
							i++;
						}
					}
					
					i++;
					i++;
					
					if(x.charAt(i) == '$')
					{
						while(x.charAt(i) != ';')
						{
							rt += x.charAt(i);
							i++;
						}
						
					}
					
					i++;
					
					ins.add(caseAdd(op ,rs,rt,rd));
					
					op = "";
					rs = "";
					rt = "";
					rd = "";
					ra = "";
					baseRegister ="";
					offset = "";
					num ="";
					label = "";
					
				}
				
				//--------------------------------------------------------------------
				
				if(op.equals("lw") || op.equals("lb") || op.equals("lbu") 
						 || op.equals("sw") || op.equals("sb"))
				{
					if(x.charAt(i) == '$')
					{
						while(x.charAt(i) != ',')
						{
							rt += x.charAt(i);
							i++;
						}
					}
					
					i++;
					i++;
					
					offset += x.charAt(i);
					
					i++;
					i++;
					
					while(x.charAt(i) != ')')
					{
						baseRegister += x.charAt(i);
						i++;
					}
					
					i++;
					i++;
					
					ins.add(caseLw(op ,baseRegister,rt,offset));
					
					op = "";
					rs = "";
					rt = "";
					rd = "";
					ra = "";
					baseRegister ="";
					offset = "";
					num ="";
					label = "";
				}
				
				//--------------------------------------------------------------------
				
				if(op.equals("sll") || op.equals("srl") || op.equals("addi") )
				{
					if(x.charAt(i) == '$')
					{
						while(x.charAt(i) != ',')
						{
							rt += x.charAt(i);
							i++;
						}
					}
					
					i++;
					i++;
					
					if(x.charAt(i) == '$')
					{
						while(x.charAt(i) != ',')
						{
							rs += x.charAt(i);
							i++;
						}
						
					}
					
					i++;
					i++;
					
					while(x.charAt(i) != ';')
					{
					num += x.charAt(i);
					i++;
					}
					
					i++;
					
					ins.add(caseSll(op,rs,rt,num));

					op = "";
					rs = "";
					rt = "";
					rd = "";
					ra = "";
					baseRegister ="";
					offset = "";
					num ="";
					label = "";
				}
				
                //-----------------------------------------------------------------------
				
				if(op.equals("beq") || op.equals("bne") )
				{
					if(x.charAt(i) == '$')
					{
						while(x.charAt(i) != ',')
						{
							rs += x.charAt(i);
							i++;
						}
					}
					
					i++;
					i++;
					
					if(x.charAt(i) == '$')
					{
						while(x.charAt(i) != ',')
						{
							rt += x.charAt(i);
							i++;
						}
						
					}
					
					i++;
					i++;
					
					
					while(x.charAt(i) != ';')
					{
						label += x.charAt(i);
						i++;
					}
						
					
					i++;
					
					ins.add(caseBeq(op, rs, rt, label));
					
					op = "";
					rs = "";
					rt = "";
					rd = "";
					ra = "";
					baseRegister ="";
					offset = "";
					num ="";
					label = "";
				}
				
				//--------------------------------------------------------------------
				if(op.equals("j") || op.equals("jal") )
				{
					while(x.charAt(i) != ';')
					{
						label += x.charAt(i);
						i++;
					}
						
					
					i++;
					
					ins.add(caseJ(op, label));

					op = "";
					label ="";
				}
				//--------------------------------------------------------------------
				 if(op.equals("jr"))
				 {
					 if(x.charAt(i) == '$')
						{
							while(x.charAt(i) != ';')
							{
								ra += x.charAt(i);
								i++;
							}
						}
						
						i++;
						
						ins.add(new Jr());

						op = "";
						rs = "";
						rt = "";
						rd = "";
						ra = "";
						baseRegister ="";
						offset = "";
						num ="";
						label = "";
				 }
			 //------------------------------------------
				 if(op.equals("lui"))
					{
						if(x.charAt(i) == '$')
						{
							while(x.charAt(i) != ',')
							{
								rt += x.charAt(i);
								i++;
							}
						}
						
						i++;
						i++;
						
						while(x.charAt(i) != ';')
						{
							baseRegister += x.charAt(i);
							i++;
						}
						
						i++;
						
						ins.add(new Lui(mipsCases(rt),Integer.parseInt(baseRegister)));
						
						op = "";
						rs = "";
						rt = "";
						rd = "";
						ra = "";
						baseRegister ="";
						offset = "";
						num ="";
						label = "";
					}				 
	
		}
		return ins;
	}

	public static Instruction caseAdd (String op , String rs, String rt, String rd)
	{
		int rsi = mipsCases(rs);
		int rti = mipsCases(rt);
		int rdi = mipsCases(rd);

		switch (op) 
		{
		case "add": return new Add(rsi,rti,rdi);
		case "sub": return new Sub(rsi,rti,rdi);
		case "slt": return new Slt(rsi,rti,rdi);
		case "sltu": return new Sltu(rsi,rti,rdi);
		case "and": return new And(rsi,rti,rdi);
		case "nor": return new Nor(rsi,rti,rdi);
		default: return new NoInstruction();
		}
		
	}
	
	public static Instruction caseLw (String op , String rs, String rt, String offset)
	{
		int rsi = mipsCases(rs);
		int rti = mipsCases(rt);
		int immediate = Integer.parseInt(offset);
	
		switch (op) 
		{
		case "lw": return new Lw(rsi,rti,immediate);
		case "lb": return new Lb(rsi,rti,immediate);
		case "lbu": return new Lbu(rsi,rti,immediate);
		case "sw": return new Sw(rti,rsi,immediate);
		case "sb": return new Sb(rti,rsi,immediate);
		default: return new NoInstruction();
		}
		
	}
	
	public static Instruction caseSll (String op , String rs, String rt, String num)
	{
		int rsi = mipsCases(rs);
		int rti = mipsCases(rt);
		int immediate = Integer.parseInt(num);

		switch (op) 
		{
		case "sll": return new Sll(rsi,immediate,rti);
		case "srl": return new Srl(rsi,immediate,rti);
		case "addi": return new Addi(rsi,rti,immediate);
		default: return new NoInstruction();
		}
		
	}
	
	public static Instruction caseBeq (String op , String rs, String rt, String num)
	{
		int rsi = mipsCases(rs);
		int rti = mipsCases(rt);
		int immediate = Integer.parseInt(num);

		switch (op) 
		{
		case "beq": return new Beq(rsi,rti,immediate);
		case "bne": return new Bne(rsi,rti,immediate);
		default: return new NoInstruction();
		}
		
	}

	public static Instruction caseJ (String op , String rs)
	{
		int rsi = Integer.parseInt(rs);


		switch (op) 
		{
			case "j": return new J(rsi);
			case "jal": return new Jal(rsi);
			default: return new NoInstruction();
		}
		
	}
}
