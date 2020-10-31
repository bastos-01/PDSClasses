package EX3;

public class Teste {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		char[] teste = new char[5];
		
		teste[0]='a';
		teste[1]='1';
		teste[2]='\\';
		teste[3]='@';
		teste[4]='\u0000';
		
		Chain charchain = new Numeric().setSuccessor(new Alphabetical().setSuccessor(new NotAlphanumeric()));
		
		for(char c:teste) {
			charchain.chr(c);
		}
	}

}
