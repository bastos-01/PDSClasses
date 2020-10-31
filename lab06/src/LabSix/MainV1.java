package LabSix;

import java.util.List;

public class MainV1 {

	public static void main(String[] args) {
		
		Database bd = new Database();
		Registos registos = new Registos();
		
		System.out.println("Sweets company: \n");
		Employee employee1 = new Employee("Pedro Bastos", 93150, 10000);
		Employee employee2 = new Employee("Tiago Oliveira", 93456, 20000);
		Employee employee3 = new Employee("João André", 93125, 30000);
		
		bd.addEmployee(employee1);
		bd.addEmployee(employee2);
		bd.addEmployee(employee3);
		System.out.println();
		
		bd.deleteEmployee(93150);
		System.out.println();
		
		Employee[] emps = bd.getAllEmployees();
		System.out.println("List of current employees:\n");
		for(Employee e: emps) {
			System.out.println(e);
		}
		
		// -------------------------------------------------------------------
		
		System.out.println("\n-------------------------------------------------------------------\n");
		
		System.out.println("Petiscos company: \n");
		Empregado empregado1 = new Empregado("Pedro", "Bastos", 93150, 10000);
		Empregado empregado2 = new Empregado("Tiago", "Oliveira", 93456, 20000);
		Empregado empregado3 = new Empregado("João", "André", 93125, 30000);
		
		registos.insere(empregado1);
		registos.insere(empregado2);
		registos.insere(empregado3);
		
		System.out.println();
		registos.isEmpregado(empregado1.codigo());
		registos.remove(empregado1.codigo());
		registos.isEmpregado(empregado1.codigo());
		System.out.println();
		
		System.out.println("List of current employees: \n");
		List<Empregado> empregados = registos.listaDeEmpregados();
		for(Empregado e: empregados) {
			System.out.println(e);
		}
		
		// -------------------------------------------------------------------
		// Teste do exercício 1.2
		
		OtherDB newDB = new OtherDB(bd, registos);
		System.out.println("\n-------------------------------------------------------------------\n");
		
		System.out.println("New company: \n");
		
		Trabalhador t1 = new Trabalhador("António Costa", 80096, 10000);
		Trabalhador t2 = new Trabalhador("Marcelo Rebelo de Sousa", 80101, 20000);
		Trabalhador t3 = new Trabalhador("Pinto da Costa", 85076, 30000);
		
		newDB.addTrabalhador(t1);
		newDB.addTrabalhador(t2);
		newDB.addTrabalhador(t3);
		
		System.out.println();
		newDB.isTrabalhador(t1.getEmpNum());
		newDB.deleteTrabalhador(t1.getEmpNum());
		newDB.isTrabalhador(t1.getEmpNum());
		System.out.println();
		
		System.out.println("List of current employees: \n");
		newDB.printTrabalhadores();
		
		
	}

}
