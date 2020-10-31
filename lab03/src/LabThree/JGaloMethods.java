package LabThree;

import java.util.ArrayList;

public class JGaloMethods implements JGaloInterface {
	private char[][] galo = null;
	private char player;
	private static int count;
	private ArrayList<String> combinations;
	private static int galocount = 0;
	
	public JGaloMethods(char player) {
		if(Character.toUpperCase(player)!='X' && Character.toUpperCase(player)!='O') {
			System.out.println("Player inválido! O Player pode ser 'O' ou 'X'!");
			System.exit(0);
		}
		this.player=Character.toUpperCase(player);
		this.galo = new char[3][3];
		this.combinations = new ArrayList<>();
	}
	
	@Override
	public char getActualPlayer() {
		if(count==0) {
			return this.player;
		}
		if(this.player=='X') {
			this.player = 'O';
		}
		else {
			this.player='X';
		}
		return this.player;
	}

	@Override
	public boolean setJogada(int lin, int col) {
		count++;
		if(this.galo[lin-1][col-1]!='\u0000')
			return false;
		this.galo[lin-1][col-1] = this.player;
		return true;
	}

	@Override
	public boolean isFinished() {
		int tam = this.galo.length;
		String temp = "";
		int contador = 1;
		
		//Guardar nas combinações as linhas 
		for(int i=0;i<tam;i++) {
			for(int j=0;j<tam;j++) {
				temp+=this.galo[i][j];
			}
			this.combinations.add(temp);
			temp = "";
		}
		
		//Guardar as colunas
		for(int i=0;i<tam;i++) {
			for(int j=0;j<tam;j++) {
				temp+=this.galo[j][i];
			}
			this.combinations.add(temp);
			temp = "";
		}
		
		//Guardar uma das diagonais
		for(int i=0;i<tam;i++) {
			temp+=this.galo[i][i];
		}
		this.combinations.add(temp);
		temp="";
		
		//Guardar a outra diagonal
		for(int i=0;i<tam;i++) {
			temp+=this.galo[i][tam-1-i];
		}
		this.combinations.add(temp);
		temp="";
		
		
		char element;
		//Percorrer a lista e ver se ja alguem ganhou
		for(String str:this.combinations) {
			element = str.charAt(0);
			if(element!='\u0000') {
				for(int i=1;i<tam;i++) {
					if(str.charAt(i)==element)
						contador++;
					if(contador==tam)
						return true;
				}
				contador=1;
			}
		}
		
		//Percorrer o jogo do galo e ver se já está todo preenchido
		for(int i=0;i<tam;i++) {
			for(int j=0;j<tam;j++) {
				if(this.galo[i][j]!='\u0000')
					galocount++;
				System.out.println(galocount);
			}
		}
		
		//Verficar se o contador foi incrementado tam*tam vezes ou seja se o jogo ja esta todo preenchido
		if(galocount==tam*tam)
			return true;
		else
			galocount=0;
		return false;
	}

	@Override
	public char checkResult() {
		if(galocount==this.galo.length*this.galo.length)
			return ' ';
		return this.player;
	}

}
