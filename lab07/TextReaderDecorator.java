package GUIAO7;

public abstract class TextReaderDecorator implements TextReaderInterface{
	protected TextReaderInterface i;
	
	public TextReaderDecorator(TextReaderInterface i) {
		this.i=i;
	}
	
	@Override
	public boolean hasNext() {
		return i.hasNext();
	}

	@Override
	public String next() {
		return i.next();
	}

}
