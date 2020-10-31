package GUIAO3;

public class CentralCantineLunchBuilder implements LunchBuilder {
	private String drink;
	private String mainCourse;
	private String side;
	
	@Override
	public void buildDrink() {
		this.drink = "Água";

	}

	@Override
	public void buildMainCourse() {
		this.mainCourse = "Grelhada mista";

	}

	@Override
	public void buildSide() {
		this.side = "Queijo Fresco";

	}

	@Override
	public Lunch getMeal() {
		return new Lunch(drink,mainCourse,side);
	}

}
