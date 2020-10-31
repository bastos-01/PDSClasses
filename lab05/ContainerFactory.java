package GUIAO3;

public class ContainerFactory {

	public static Container createContainerFor(Commodity c) {
		if(c instanceof Milk)
			return new TermicBottle();
		else if(c instanceof FruitJuice)
			return new PlasticBottle();
		else if(c instanceof Tuna)
			return new PlasticBag();
		else
			return new Tupperware();
	}

	@Override
	public String toString() {
		return "ContainerFactory [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
