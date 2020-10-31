package GUIAO3;

public class BeverageFactory {

	public static Commodity createBeverage(Temperature T) {
		if(T.equals(Temperature.WARM)) 
			return new Milk();
		else
			return new FruitJuice();
	}

	@Override
	public String toString() {
		return "BeverageFactory [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
