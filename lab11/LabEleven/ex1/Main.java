package ex1;

public class Main {
	
	public static void main(String[] args) {
        
       System.out.println("Bubble sort:");
       Context c = new Context(new BubbleSort());
       System.out.println("Ordenado pelo preço: ");
       Telemovel[] teles = c.sort("preco");
       for(Telemovel t: teles) {
    	   System.out.println(t);
       }
       
       System.out.println();
       c.setSortingmethod(new InsertionSort());
       System.out.println("Insertion sort:");
       System.out.println("Ordenado pela memoria: ");
       teles = c.sort("memoria");
       for(Telemovel t: teles) {
    	   System.out.println(t);
       }
  
       
       System.out.println();
       c.setSortingmethod(new MergeSort());
       System.out.println("Merge sort:");
       System.out.println("Ordenado pelo cpu: ");
       teles = c.sort("cpu");
       for(Telemovel t: teles) {
    	   System.out.println(t);
       }
       
       
       
	}

}
