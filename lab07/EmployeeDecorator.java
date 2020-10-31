package GUIAO7;

public abstract class EmployeeDecorator implements EmployeeInterface{
	protected EmployeeInterface i;
	
	public EmployeeDecorator(EmployeeInterface i) {
		this.i=i;
	}
	
	public void start(String Date) {
		i.start(Date);
	}
	public void terminate(String Date) {
		i.terminate(Date);
	}
	public void work() {
		i.work();
	}
}
