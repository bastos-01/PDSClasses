package GUIAO7;

public class Rectangulo extends Figure{

	private String name;
	
	public Rectangulo(String name) {
		this.name=name;
	}

	@Override
	public String toString() {
		return "Rectangulo " + name;
	}

}
