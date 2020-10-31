package GUIAO7;

import java.util.ArrayList;

public class TermFilter extends TextReaderDecorator{
	private ArrayList<String> words;
	public TermFilter(TextReaderInterface i) {
		super(i);
		this.words=new ArrayList<>();
	}
	
	@Override
	public boolean hasNext() {
		if(words.size()>0) {
			return true;
		}
		return super.hasNext();
	}

	@Override
	public String next() {
		if(words.size()==0) {
			String paragraph = super.next();
			String[] w = paragraph.split("\\s");
			for(String s:w) {
				words.add(s);
			}
		}
		String str = words.get(0);
		words.remove(0);
		return str;
		
	}
}
