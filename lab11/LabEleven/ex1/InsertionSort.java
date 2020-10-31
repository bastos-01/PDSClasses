package ex1;

public class InsertionSort implements Strategy{

	@Override
	public Telemovel[] sort(Telemovel[] teles, String atr) {
		
		switch(atr) {
		case "preco":
			for(int i=0;i<teles.length-1;i++) {
				for(int j=0;j<teles.length-i-1;j++) {
					if(teles[j].getPreco()>teles[j+1].getPreco()) {
						Telemovel temp = teles[j];
						teles[j] = teles[j+1];
						teles[j+1] = temp;
					}	
				}
					
			}
			return teles;
		case "memoria":
			for(int i=0;i<teles.length-1;i++) {
				for(int j=0;j<teles.length-i-1;j++) {
					if(teles[j].getMemoria()>teles[j+1].getMemoria()) {
						Telemovel temp = teles[j];
						teles[j] = teles[j+1];
						teles[j+1] = temp;
					}	
				}
					
			}
			return teles;
			
		case "camera":
			for(int i=0;i<teles.length-1;i++) {
				for(int j=0;j<teles.length-i-1;j++) {
					if(teles[j].getCamera()>teles[j+1].getCamera()) {
						Telemovel temp = teles[j];
						teles[j] = teles[j+1];
						teles[j+1] = temp;
					}	
				}
					
			}
			return teles;
			
		case "cpu":
			for(int i=0;i<teles.length-1;i++) {
				for(int j=0;j<teles.length-i-1;j++) {
					if(teles[j].getProcessador()>teles[j+1].getProcessador()) {
						Telemovel temp = teles[j];
						teles[j] = teles[j+1];
						teles[j+1] = temp;
					}	
				}
					
			}
			return teles;
		default:
			return null;
		}
	}

}
