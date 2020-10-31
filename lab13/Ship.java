
public class Ship {
	private String name;
	private int size;
	private static int num = 1;
	private final int id;
	
	public Ship(String name, int size) {
		this.name=name;
		this.size=size;
		this.id=num++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Ship [name=" + name + ", size=" + size + ", id=" + id + "]";
	}
	
	
}
