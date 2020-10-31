package GUIAO7;

public class v1Test {

	public static void main(String[] args) {
		EmployeeInterface  e1 = new Employee("Tiago");
		TeamMember t1 = new TeamMember(new Employee("Pedro"));
		TeamLeader t2 = new TeamLeader(e1);
		TeamLeader t3 = new TeamLeader(t1);
		Manager m1 = new Manager(new Employee("Zeca"));
		t1.start("09:00");
		t2.start("10:00");
		m1.start("11:00");
		t1.work();
		t3.work();
		m1.work();
		t1.terminate("17:00");
		t2.terminate("18:00");
		m1.terminate("18:30");
		

	}

}
