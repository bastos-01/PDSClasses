package EX3;

public abstract class Chain {
	private Chain successor = null;
	
	public void chr(char c) {
		if (successor != null)
			successor.chr(c);
		else
			System.out.println("Character não reconhecido: " + c + ".");
	}
	
	protected boolean canHandleCharacter(char c, String type) {
		String temp="";
		if(Character.isDigit(c)) {
			temp="num";
		}
		else if(Character.isAlphabetic(c)) {
			temp="letter";
		}
		else
			temp = "!alphanumeric";
		
		return temp.equals(type);
	}
	
	public Chain setSuccessor(Chain successor) {
		this.successor = successor;
		return this;
	}
}
