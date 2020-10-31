package GUIAO7;

import java.util.ArrayList;

public class Bloco extends Figure{
	
	private String name;
	private ArrayList<Figure> figs;
	
	public Bloco(String name) {
		this.name=name;
		figs = new ArrayList<>();
	}

	public void add(Figure f) {
		figs.add(f);
		
	}

	public void draw() {
		System.out.println(indent.toString() + this.toString());
		indent.append("   ");
		for(int i=0;i<figs.size();i++) {
			if(figs.get(i) instanceof Bloco) {
				((Bloco) figs.get(i)).draw();
			}
			else {
				System.out.println(indent.toString() + figs.get(i).toString());
			}
		}
		indent.setLength(indent.length() - 3);
		
	}

	@Override
	public String toString() {
		return "Window " + name;
	}

}
