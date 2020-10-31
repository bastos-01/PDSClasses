package LabEight;

import java.util.ArrayList;

public class Insurance {
	
private ArrayList<Person2> people = new ArrayList<>();
	
	public void regist (Person2 p) {
		System.out.println(p.getName() + " registado na seguradora");
		people.add(p);
	}

}
