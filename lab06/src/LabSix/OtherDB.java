package LabSix;

import java.util.HashSet;

public class OtherDB {
	
	private HashSet<Trabalhador> trabalhadores;
	private Database db1;
	private Registos db2;
	
	public OtherDB(Database db1, Registos db2) {
		trabalhadores = new HashSet<>();
		this.db1 = db1;
		this.db2 = db2;
		
	}
	
	public boolean addTrabalhador(Trabalhador trabalhador) {
		
		if(!trabalhadores.contains(trabalhador)) {
			trabalhadores.add(trabalhador);
			System.out.println("Employee " + trabalhador.getName() + " added successfully");
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void deleteTrabalhador(long num) {
		
		for(Trabalhador t: trabalhadores) {
			if(t.getEmpNum() == num) {
				trabalhadores.remove(t);
				System.out.println("Employee " + t.getName() + " removed successfully");
				return;
			}
		}
		
		for(Employee e: db1.getAllEmployees()) {
			if(e.getEmpNum() == num) {
				db1.deleteEmployee(num);
				System.out.println("Employee " + e.getName() + " removed successfully");
				return;
			}
		}
		
		for(Empregado e: db2.listaDeEmpregados()) {
			if(e.codigo() == num) {
				db2.remove((int)num);
				System.out.println("Employee " + e.nome() + " removed successfully");
				return;
			}
		}	
		
	}
	
	public boolean isTrabalhador(long num) {
		for(Trabalhador t: trabalhadores) {
			if(t.getEmpNum() == num) {
				System.out.println("Employee " + t.getName() + " belongs to the company");
				return true;
			}
		}
		
		for(Employee e: db1.getAllEmployees()) {
			if(e.getEmpNum() == num) {
				System.out.println("Employee " + e.getName() + " belongs to the company");
				return true;
			}
		}
		
		for(Empregado e: db2.listaDeEmpregados()) {
			if(e.codigo() == num) {
				System.out.println("Employee " + e.nome() + " belongs to the company");
				return true;
			}
		}
		System.out.println("Employee with the code " + num + " does not belong to the company");
		return false;
		
	}
	
	public void printTrabalhadores() {
		
		for(Trabalhador t: trabalhadores) {
			System.out.println(t);
		}
		for(Employee e: db1.getAllEmployees()) {
			System.out.println(e);
		}
		for(Empregado e: db2.listaDeEmpregados()) {
			System.out.println(e);
		}
		
		
	}

}
