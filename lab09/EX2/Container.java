package EX2;

import java.util.Collection;
import java.util.Stack;

public class Container<T> {
	
	 private Stack<T> stack; 
	 private Collection<T> col;

	 Container(Collection<T> col){
	        this.col = col;
	        this.stack = new Stack<>();
	    }

	public Stack<T> getStack() {
		return stack;
	}

	public Collection<T> getCol() {
		return col;
	}

	 

}
