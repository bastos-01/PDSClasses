package GUIAO7;

public class TeamLeader extends EmployeeDecorator{

	public TeamLeader(EmployeeInterface i) {
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
		Plan();
		
	}
	
	public void Plan() {
		System.out.print(" Planning");
	}
}
