package GUIAO3;

public class Milk implements Commodity{

	@Override
	public Temperature getTemperature() {
		return Temperature.WARM;
	}

	@Override
	public State getState() {
		return State.Liquid;
	}

	@Override
	public String toString() {
		return "Milk [getTemperature()=" + getTemperature() + ", getState()=" + getState() + "]";
	}


	
}
