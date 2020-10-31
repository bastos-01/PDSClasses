package EX1;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T>{
	
	private T[] vec;
	private int nElem;
	private final static int ALLOC = 50;
	private int dimVec = ALLOC;
	
	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (T[]) new Object[dimVec];
		nElem = 0;
	}
	
	public boolean addElem(T elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}
	
	private void ensureSpace() {
		if (nElem>=dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem );
			vec = newArray;
		}
	}
	
	public boolean removeElem(T elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem-i-1 > 0) // not last element
					System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
				vec[--nElem] = null; // libertar último objecto para o GC
				return true;
			}
		}
		return false;
	}
	
	public int totalElem() {
		return nElem;
	}
	
	public T getElem(int i) {
		return (T) vec[i];
	}
	
	public Iterator<T> iterator() {
		return new VectorIterator<T>();
	}
	
	public ListIterator<T> listiterator() {
		return new VectorListIterator<T>();
		
	}
	
	public ListIterator<T> listiterator(int i) {
		return new VectorListIterator<T>(i);
		
	}
	private class VectorIterator<K> implements Iterator<K> {
	
		private int indice;
		
		VectorIterator() {
			indice = 0;
		}
		
		public boolean hasNext() {
			return (indice < nElem);
		}
		
		@SuppressWarnings("unchecked")
		public K next() {
			if (hasNext())
				return (K)VectorGeneric.this.vec[indice++];
			throw new NoSuchElementException("only " + nElem + " elements");
		}
		
	
	}
	private class VectorListIterator<T> implements ListIterator<T> {
		private int index;
		
		VectorListIterator(){
			index=0;
		}
		
		VectorListIterator(int i){
			index=i;
		}
		
		
		@Override
		public boolean hasNext() {
			return (index < nElem);
		}

		@Override
		public T next() {
			if (hasNext())
				return (T)VectorGeneric.this.vec[index++];
			throw new NoSuchElementException("only " + nElem + " elements");
		}

		@Override
		public boolean hasPrevious() {
			return (index > 0);
		}

		@Override
		public T previous() {
			if (hasPrevious())
				return (T)VectorGeneric.this.vec[index--];
			throw new NoSuchElementException("only " + nElem + " elements");
		}

		@Override
		public int nextIndex() {
			if(hasNext()) {
				int i = index;
				return i++;
			}
			throw new NoSuchElementException("only " + nElem + " elements");
		}

		@Override
		public int previousIndex() {
			if(hasPrevious()) {
				int i = index;
				return i--;
			}
			throw new NoSuchElementException("only " + nElem + " elements");
		}

		@Override
		public void set(T e) {
			throw new UnsupportedOperationException("Operacao nao suportada!");
			
		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException("Operacao nao suportada!");
			
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Operacao nao suportada!");
			
		}

	}
}
