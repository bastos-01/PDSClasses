package ex2;

public class Request extends Employee {

	public Request(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return "Erro: Não existe nenhum empregado com o nome: " + this.name;
	}

}
