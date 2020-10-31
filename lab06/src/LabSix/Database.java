package LabSix;

import java.util.Vector;

public class Database {
	
	private Vector<Employee> employees; // Stores the employees
	
	public Database() {
		employees = new Vector<>();
	}
	
	public boolean addEmployee(Employee employee) {
		
		if(!employees.contains(employee)) {
			employees.add(employee);
			System.out.println("Employee " + employee.getName() + " added successfully");
			return true;
		}
		else {
			return false;
		}
		
	}
	public void deleteEmployee(long emp_num) {
		
		for(Employee e: employees) {
			if(e.getEmpNum() == emp_num) {
				employees.remove(e);
				System.out.println("Employee " + e.getName() + " removed successfully");
				break;
			}
		}
		
	}
	public Employee[] getAllEmployees() {
		
		Employee[] emps = new Employee[employees.size()];
		
		for(int i=0; i < employees.size(); i++) {
			emps[i] = employees.get(i);
		}
		
		return emps;
	}

}
