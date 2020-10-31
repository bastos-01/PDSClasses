package GUIAO3;

public class FruitJuice implements Commodity{
	
	private  String Fruit = "Orange";
	
	@Override
	public Temperature getTemperature() {
		return Temperature.COLD;
	}

	@Override
	public State getState() {
		return State.Liquid;
	}

	@Override
	public String toString() {
		return "FruitJuice [Fruit=" + Fruit + ", getTemperature()=" + getTemperature() + ", getState()=" + getState()
				+ "]";
	}

	

	
}
