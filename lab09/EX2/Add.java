package EX2;

import java.util.Collection;

public class Add<T> implements Command<T>{
	
	private Container<T> c;
	
	public Add(Collection<T> col) {
		this.c = new Container<T>(col);
	}

	@Override
	public boolean execute(T element) {
		boolean success = this.c.getCol().add(element); 
        if(success)
            this.c.getStack().push(element);
        return success;
	}

	@Override
	public boolean undo() {
		 boolean success = this.c.getCol().remove(this.c.getStack().peek());
	        if(success)
	            this.c.getStack().pop();
	        return success;
	}

}
