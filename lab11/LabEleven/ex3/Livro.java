package ex3;

public class Livro {
	
	private State state;
	private String titulo;
	private int isbn;
	private int ano;
	private String autor;
	
	public Livro(String titulo, int isbn, int ano, String autor) {
		this.state = new Inventario();
		this.titulo = titulo;
		this.isbn = isbn;
		this.ano = ano;
		this.autor = autor;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void regista() {
        this.state.regista(this);
    }

    public void reserva() {
        this.state.reserva(this);
    }

    public void cancelaReserva() {
        this.state.cancelaReserva(this);
    }

    public void devolve() {
        this.state.devolve(this);
    }

    public void requesita() {
        this.state.requesita(this);
    }

    public String toString() {
        return String.format("Book: %-5d %-20s %-20s %-15s", isbn, titulo, autor,
                this.state.toString());
    }
	
	
	
	
	

}
