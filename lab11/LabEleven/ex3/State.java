package ex3;

public interface State {
	
	public void regista(Livro l);
	public void reserva(Livro l);
	public void cancelaReserva(Livro l);
	public void devolve(Livro l);
	public void requesita(Livro l);
	
}
