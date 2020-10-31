package GUIAO3;

public class MeatFactory {

	public static Commodity createMeat(Temperature T) {
		if(T.equals(Temperature.WARM))
			return new Pork();
		else
			return new Tuna();
	}

}
