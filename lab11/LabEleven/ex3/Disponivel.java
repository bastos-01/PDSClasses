package ex3;

public class Disponivel implements State{

	@Override
	public void regista(Livro l) {
		System.out.println("Impossible operation!");
		
	}

	@Override
	public void reserva(Livro l) {
		l.setState(new Reservado());
		
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
		l.setState(new Emprestado());
		
	}
	@Override
	public String toString() {
		return "[Disponível]";
	}

}
