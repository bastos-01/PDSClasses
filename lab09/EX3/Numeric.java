package EX3;

public class Numeric extends Chain{
	
	public void chr(char c) {
		if (canHandleCharacter(c, "num"))
		System.out.println("It is a number: " + c);
		else
			super.chr(c);
	}
}
