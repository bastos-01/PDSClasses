package LabEight;

import java.util.ArrayList;

public class SocialSecurity {
	
	private ArrayList<Person2> people = new ArrayList<>();
	
	public void regist (Person2 p) {
		System.out.println(p.getName() + " registado na segurança social");
		people.add(p);
	}
	

}
