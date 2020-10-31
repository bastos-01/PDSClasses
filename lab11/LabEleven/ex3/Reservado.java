package ex3;

public class Reservado implements State{

	@Override
	public void regista(Livro l) {
		System.out.println("Impossible operation!");
		
	}

	@Override
	public void reserva(Livro l) {
		System.out.println("Impossible operation!");
		
	}

	@Override
	public void cancelaReserva(Livro l) {
		l.setState(new Disponivel());
		
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
		return "[Reservado]";
	}

}
