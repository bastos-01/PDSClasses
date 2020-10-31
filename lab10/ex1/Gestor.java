package ex1;

import java.util.ArrayList;

public class Gestor extends Observer{

	private String nome;
	private ArrayList<Produto> pStock = new ArrayList<>();
	private ArrayList<Produto> pLeilao = new ArrayList<>();
	private ArrayList<Produto> pVendidos = new ArrayList<>();

	public Gestor(String nome) {
		this.nome = nome;
	}

	@Override
	public void update(String message) {
		System.out.println(this.nome + ": " + message);
		
	}
	
	public void iniciarLeilao(Produto p) {
		p.iniciar();
		pStock.remove(p);
		pLeilao.add(p);
	}
	
	public void vender(Produto p) {
		p.vendido();
		pLeilao.remove(p);
		pVendidos.add(p);
	}
	
	
	
}
