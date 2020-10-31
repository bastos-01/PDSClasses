package GUIAO3;

public class Tuna implements Commodity{

	@Override
	public Temperature getTemperature() {
		return Temperature.COLD;
	}

	@Override
	public State getState() {
		return State.Solid;
	}

	@Override
	public String toString() {
		return "Tuna [getTemperature()=" + getTemperature() + ", getState()=" + getState() + "]";
	}


}
