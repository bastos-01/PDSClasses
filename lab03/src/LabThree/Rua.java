package LabThree;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Rua {
	
	private Set<Membro> membros;
	private ArrayList<Familia> familias;

	public Rua() {
		familias = new ArrayList<>();
		membros = new TreeSet<>(); 
	}

	public Set<Membro> getMembros() {
		return membros;
	}

	public void setMembros(Set<Membro> membros) {
		this.membros = membros;
	}

	public ArrayList<Familia> getFamilias() {
		return familias;
	}

	public void setFamilias(ArrayList<Familia> familias) {
		this.familias = familias;
	}
	
	public void addMember(Membro m) {
		membros.add(m);
	}
	
	public void addFam(Familia f) {
		familias.add(f);
	}
	
	public boolean compararMembro(Membro m) {
		for(Membro memb: membros) {
			if(memb.getNome().equals(m.getNome())) {
				return false;
			}
		}
		return true;
	}
	
	

}
