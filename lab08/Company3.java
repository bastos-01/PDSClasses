package LabEight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company3 {
	
	public static User user;
	private List<Employee2> emps = new ArrayList<>();
	private SocialSecurity sc = new SocialSecurity();
	private Insurance ins = new Insurance();
	private ArrayList<Card> cards = new ArrayList<>();
	private Parking parking = new Parking();
	
	public void admitEmployee(Person2 p, double salary) {
		Employee2 e = new Employee2(p, salary);
		emps.add(e);
		sc.regist(p);
		ins.regist(p);
		cards.add(new Card(p));
		double media = 0;
		for(Employee2 emp: emps) {
			media += emp.getSalary();
		}
		media = media/emps.size();
		if(salary > media) {
			parking.allow(p);
		}
		
		
	}
	
	public void paySalaries(int month) {
		for (Employee2 e : emps) {
			BankAccount ba = e.getBankAccount();
			ba.deposit(e.getSalary());
		}
	}
	public List<Employee2> employees() {
		return Collections.unmodifiableList(emps);
	}

}
