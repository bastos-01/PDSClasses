package GUIAO3;

public class SnackLunchBuilder implements LunchBuilder {

	private String drink;
	private String mainCourse;
	private String side;
	
	@Override
	public void buildDrink() {
		this.drink = "Sumo";

	}

	@Override
	public void buildMainCourse() {
		this.mainCourse = "Pão com Panado";

	}

	@Override
	public void buildSide() {
		this.side = "Rissol";

	}

	@Override
	public Lunch getMeal() {
		return new Lunch(drink,mainCourse,side);
	}

}
