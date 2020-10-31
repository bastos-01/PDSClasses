package LabThree;

import java.util.*;

public class Familia {
	
	private int id;
	private int x1;
	private int x2;
	private Set<Membro> membros;
	
	public Familia(int x1, int x2) {
		this.x1 = x1;
		this.x2 = x2;
		this.membros = new TreeSet<>();
	}

	public int getId() {
		return id;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public Set<Membro> getMembros() {
		return membros;
	}

	public void setMembros(Set<Membro> membros) {
		this.membros = membros;
	}
	
	public void addMember(Membro m) {
		membros.add(m);
	}
	public void removeMember(Membro m) {
		membros.remove(m);
	}

	@Override
	public String toString() {
		return "X1,X2: " + x1 + "," + x2 + "\t membros:" + membros + "\n";
	}

	
	
	
	

}
