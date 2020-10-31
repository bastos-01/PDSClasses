package ex1;

public class Test {
	
	 public static void main(String[] args) {
		 
	        Produto p1 = new Produto(10, "P1");
	        Produto p2 = new Produto(12, "P2");
	        Produto p3 = new Produto(9, "P3");
	        Produto p4 = new Produto(14, "P4");
	        Produto p5 = new Produto(22, "P5");

	        Cliente c1 = new Cliente("C1");
	        Cliente c2 = new Cliente("C2");
	        Cliente c3 = new Cliente("C3");

	        Gestor gestor = new Gestor("Gestor");

	        gestor.iniciarLeilao(p1);
	        gestor.iniciarLeilao(p2);
	        gestor.iniciarLeilao(p3);
	        gestor.iniciarLeilao(p4);
	        gestor.iniciarLeilao(p5);
	        
	        c1.licita(p1, 20);
	        c1.licita(p2, 25);
	        c2.licita(p1, 30);
	        c3.licita(p1, 40);
	        c1.licita(p4, 50);
	        
	        gestor.vender(p1);
	        gestor.vender(p2);
	    }
	
}
