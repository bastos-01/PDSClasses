package EX3;

public class Alphabetical extends Chain{
	
	public void chr(char c) {
		if (canHandleCharacter(c, "letter"))
		System.out.println("It is a letter: " + c);
		else
			super.chr(c);
	}
}
