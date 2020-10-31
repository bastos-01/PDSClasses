package GUIAO7;

public class TeamMember extends EmployeeDecorator{

	public TeamMember(EmployeeInterface i) {
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
		Colaborate();
	}
	
	public void Colaborate() {
		System.out.print(" Colaborating");
	}

}
