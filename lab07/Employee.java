package GUIAO7;

public class Employee implements EmployeeInterface{
	private String name;
	private String start_date;
	private String end_date;
	
	public Employee(String name) {
		this.name=name;
	}

	@Override
	public void start(String Date) {
		start_date=Date;
		System.out.println(name + " started at " + start_date + ".");
		
	}

	@Override
	public void terminate(String Date) {
		end_date=Date;
		System.out.println(name + " terminated at " + end_date + ".");
	}

	@Override
	public void work() {
		System.out.print("\n"+ name + " is working");
		
	}

}
