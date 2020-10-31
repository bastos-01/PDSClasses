package ex1;

public class Context {
	
	private Strategy sortingmethod;

    private Telemovel[] teles;
	
	public Context(Strategy sortingmethod) {
		this.teles = new Telemovel[] { 	new Telemovel(500, 4, 12, 2), 
        		new Telemovel(700, 8, 16, 4),
        		new Telemovel(1100, 32, 32, 8), 
        		new Telemovel(300, 4, 10, 3),
        		new Telemovel(1500, 64, 64, 16)
                };
		this.sortingmethod=sortingmethod;
	}
	
	public Telemovel[] sort(String atr) {
		return sortingmethod.sort(this.teles, atr);
	}

	public void setSortingmethod(Strategy sortingmethod) {
		this.sortingmethod = sortingmethod;
	}
	
	
}
