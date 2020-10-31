package GUIAO7;

public class Quadrado extends Figure{

	private String name;
	
	public Quadrado(String name) {
		this.name=name;
	}

	@Override
	public String toString() {
		return "Quadrado " + name;
	}

}
