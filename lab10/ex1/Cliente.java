package ex1;

public class Cliente extends Observer{
	
	private String nome;

	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public void licita(Produto p, double val) {
		p.Licitar(this, val);
	}

	@Override
	public void update(String message) {
		System.out.println(this.nome + ": " + message);
	}
	
	

}
