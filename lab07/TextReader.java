package GUIAO7;

import java.io.File;
import java.util.Scanner;

public class TextReader implements TextReaderInterface{
	private File file;
	private Scanner reader;
	public TextReader(String file) {
		try{
			this.file= new File(file);
			this.reader=new Scanner(this.file);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	@Override
	public boolean hasNext() {
		return reader.hasNextLine();
	}

	@Override
	public String next() {
		return reader.next();
	}

}
