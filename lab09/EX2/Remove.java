package EX2;

import java.util.Collection;

public class Remove<T> implements Command<T>{
	
	private Container<T> c;
	
	public Remove(Collection<T> col) {
		this.c = new Container<T>(col);
	}
	
	@Override
    public boolean execute(T element){
        boolean success = this.c.getCol().remove(element);
        if(success) 
            this.c.getStack().push(element);
        return success;
    }

    @Override
    public boolean undo(){
        boolean success = this.c.getCol().add(this.c.getStack().peek());
        if(success)
            this.c.getStack().pop();
        return success;
    }

	

}
