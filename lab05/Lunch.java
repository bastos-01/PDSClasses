package GUIAO3;

public class Lunch {
	private String drink;
	private String mainCourse;
	private String side;

	public Lunch(String drink, String mainCourse, String side) {
		this.drink = drink;
		this.mainCourse = mainCourse;
		this.side = side;
	}

	@Override
	public String toString() {
		return " [drink=" + drink + ", mainCourse=" + mainCourse + ", side=" + side + "]";
	}
	
}
