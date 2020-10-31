package LabEight;

import java.util.ArrayList;

public class Parking {
	
	private ArrayList<Person2> people = new ArrayList<>();
	
	public void allow (Person2 p) {
		System.out.println(p.getName() + " tem autorização para estacionar");
		people.add(p);
	}

}
