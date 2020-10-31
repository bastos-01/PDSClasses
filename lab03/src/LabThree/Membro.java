package LabThree;

public class Membro implements Comparable<Membro> {
	
	private int famId;
	private String nome;
	private int x1;
	private int x2;
	
	public Membro( String nome, int x1, int x2) {
		this.nome = nome;
		this.x1 = x1;
		this.x2 = x2;
	}

	public int getFamilia() {
		return famId;
	}

	public void setFamilia(int familia) {
		this.famId = familia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	@Override
	public int compareTo(Membro o) {
		return this.getNome().compareTo(o.getNome());
	}

	@Override
	public String toString() {
		return nome;
	}
	
	
	
	
	
	
	

}
