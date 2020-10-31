package GUIAO7;

public class v2Test {

	public static void main(String[] args) {
	        TextReaderInterface reader = new TextReader("ex2Teste.txt");
	        System.out.println(reader.next());

	        CoderFilter cf = new CoderFilter(reader);
	        System.out.println(cf.next());

	        ReverseFilter rf = new ReverseFilter(new TermFilter(reader));
	        System.out.println(rf.next());


	}

}
