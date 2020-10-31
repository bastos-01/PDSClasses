package GUIAO7;

public class Manager extends EmployeeDecorator{

	public Manager(EmployeeInterface i) {
		super(i);
	}
	
	@Override
	public void start(String Date) {
		i.start(Date);
		
	}

	@Override
	public void terminate(String Date) {
		i.terminate(Date);
		
	}

	@Override
	public void work() {
		i.work();
		Manage();
		
	}
	
	public void Manage() {
		System.out.println(" Managing");
	}
}
