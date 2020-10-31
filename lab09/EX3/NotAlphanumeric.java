package EX3;

public class NotAlphanumeric extends Chain{
	
	public void chr(char c) {
		if (canHandleCharacter(c, "!alphanumeric"))
		System.out.println("It is not alphanumeric: " + c);
		else
			super.chr(c);
	}
}
