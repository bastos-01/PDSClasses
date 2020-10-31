package LabSix;

import java.util.ArrayList;
import java.util.List;

public class Registos {
	
	// Data elements
	private ArrayList<Empregado> empregados; // Stores the employees
	public Registos() {
	empregados = new ArrayList<>();
	}
	public void insere(Empregado emp) {
		if(!empregados.contains(emp)) {
			empregados.add(emp);
			System.out.println("Employee " + emp.nome() + " added successfully");
		}
		else {
			System.out.println("Employee " + emp.nome() + " already exists!");
		}
	}
	public void remove(int codigo) {
		for(Empregado e: empregados) {
			if(e.codigo() == codigo) {
				empregados.remove(e);
				System.out.println("Employee " + e.nome() + " removed successfully");
				break;
			}
		}
	}
	public boolean isEmpregado(int codigo) {
		for(Empregado e: empregados) {
			if(e.codigo() == codigo) {
				System.out.println("Employee " + e.nome() + " belongs to Petiscos' company");
				return true;
			}
		}
		System.out.println("Employee with the code " + codigo + " does not belong to Petiscos' company");
		return false;
	}
	public List<Empregado> listaDeEmpregados() {
		return empregados;
	}

}
