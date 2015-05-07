package components;

public class Alu {
	
	public int execute (int r1, int r2, String operation)
	{
		int r1u = unsigned(r1);
		int r2u = unsigned(r2);
		operation = operation.substring(19);
		operation = operation.toLowerCase();
		   switch (operation) {
           case "add":
               return r1 + r2;
           case "addi":
               return r1 + r2;
           case "lw":
               return r1 + r2;
           case "sub":
                return r1 - r2;
           case "and":
               return r1 & r2;
           case "nor":
               return ~(r1 | r2);
           case "sll":
               return r1*(int)Math.pow(2,r2);
           case "srl":
               return r1/(int)Math.pow(2,r2);
           case "slt":
               return r1 < r2 ? 0 : 1;
           case "sltu":
               return r1u < r2u ? 0 : 1;
           case "lui":
               return r2 *(int)Math.pow(2,16);
 
           default:
               return 0;
       }
	}
	
	public boolean zero(int r1,int r2, String operation)
	{
		operation = operation.substring(19);
		operation = operation.toLowerCase();
		if (operation.equals("beq") && r1-r2 == 0)
			return true;
		if (operation.equals("bne") && r1-r2 != 0)
			return true;
		
		return false;
	}
	
	public static int unsigned(int x)
	{
		if (x>0)
		{
			return x;
		}
		
		if (x<0)
		{
			return 0 - x;
		}
		return 0;
	}

}
