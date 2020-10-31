package ex1;

import java.util.ArrayList;
import java.util.List;

public class Produto {
	
	private List<Observer> observers;
	private static int codigo;
	private double preço_base;
	private String descricao;
	private Estado estado;
	
	
	
	public Produto(double preço_base, String descricao) {
		this.observers = new ArrayList<>();
		this.preço_base = preço_base;
		this.descricao = descricao;
		this.estado = Estado.STOCK;
	}

	public void Licitar(Observer o, double val) {
		
		if(this.estado == Estado.LEILAO) {
	
			if(!observers.contains(o))
				observers.add(o);
			
			if(this.preço_base < val) {
				this.preço_base = val;
				for(Observer obs: observers) {
					obs.update("O produto " + this.descricao + " está no valor " + val);
				}
			}
		}

	}
	
	public void iniciar() {
		this.estado = Estado.LEILAO;
	}
	
	public void vendido() {
		this.estado = Estado.VENDAS;
		for(Observer obs: observers) {
			obs.update("O produto " + this.descricao + " foi vendido!");
		}
	}

}
