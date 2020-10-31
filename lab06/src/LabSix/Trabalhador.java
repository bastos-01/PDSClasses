package LabSix;

public class Trabalhador {
	
	private String name;
	private long num;
	private double salary;
	
	public Trabalhador(String name, long num, double salary) {
	this.name = name;
	this.num = num;
	this.salary = salary;
	}
	public String getName() {
	return name;
	}
	public long getEmpNum() {
	return num;
	}
	public double getSalary() {
	return salary;
	}
	
	public String toString() {
		return "Trabalhador [name=" + name + ", emp_num=" + num + ", salary=" + salary + "]";
	}

}
