package GUIAO3;

public class CrastoLunchBuilder implements LunchBuilder {
	private String drink;
	private String mainCourse;
	private String side;
	
	@Override
	public void buildDrink() {
		this.drink = "Vinho Tinto";

	}

	@Override
	public void buildMainCourse() {
		this.mainCourse = "Bacalhau á lagareiro";
	}

	@Override
	public void buildSide() {
		this.side="Broa";

	}

	@Override
	public Lunch getMeal() {
		return new Lunch(drink,mainCourse,side);
	}

}
