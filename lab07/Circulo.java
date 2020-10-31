package GUIAO7;

public class Circulo extends Figure{
	
	private String name;
	
	public Circulo(String name) {
		this.name=name;
	}

	@Override
	public String toString() {
		return "Círculo " + name;
	}

}
