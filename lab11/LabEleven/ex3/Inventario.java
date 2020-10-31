package ex3;

public class Inventario implements State{

	@Override
	public void regista(Livro l) {
		l.setState(new Disponivel());
		
	}

	@Override
	public void reserva(Livro l) {
		System.out.println("Impossible operation!");
		
	}

	@Override
	public void cancelaReserva(Livro l) {
		System.out.println("Impossible operation!");
		
	}

	@Override
	public void devolve(Livro l) {
		System.out.println("Impossible operation!");
		
	}

	@Override
	public void requesita(Livro l) {
		System.out.println("Impossible operation!");
		
	}

	@Override
	public String toString() {
		return "[Inventario]";
	}
	

}
