package GUIAO3;

public class LunchDirector {
	
	private LunchBuilder lunch;
	
	public LunchDirector(LunchBuilder lunch) {
		this.lunch = lunch;
	}

	public void constructMeal() {
		lunch.buildDrink();
		lunch.buildMainCourse();
		lunch.buildSide();
		
	}

	public Lunch getMeal() {
		return lunch.getMeal();
	}

}
