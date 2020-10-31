import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;


public class NAVAL {
	public static void main(String[] args) {
		String flag = null;
		String file = null;
		int[][] tabuleiro = null; 
		
		for(int i=0;i<args.length;i+=2) {
			flag = args[i];
			switch (flag) {
			case "-c":
				file = args[i+1];
				break;
			default:
				System.out.println("Flag não identificada!");
				System.exit(1);
			}
		}
		
		XMLConfiguration conf = null;
		
		try {
			conf = new XMLConfiguration(file);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}	
		
		//Criação do tabuleiro
		int row = conf.getInt("board.rows");
		int col = conf.getInt("board.collumns");
		tabuleiro = new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++)
				tabuleiro[i][j]=0;
		}
		
		List<Object> ships_name = conf.getList("ships.ship.name");
		List<Object> ships_number = conf.getList("ships.ship.number");
		List<Object> ships_size = conf.getList("ships.ship.size");
		
		ArrayList<Ship> ships = new ArrayList<>();
		
		for(int j=0;j<ships_name.size();j++) {
			for(int i=0;i<Integer.parseInt((String)ships_number.get(j));i++) {
				ships.add(new Ship((String)ships_name.get(j),Integer.parseInt((String)ships_size.get(j))));
			}
		}
		
		//Gerar as posições dos barcos
		int dir;
		int sen;
		int coli;
		int rowi;
		boolean fits=false;
		boolean over=true;
		for(Ship s:ships) {
			fits=false;
			while(!fits) {
				 over=true;
				 Random rand = new Random();
				 //Gerar direcao e sentido e posição inicial
				 dir = rand.nextInt(2);
				 sen = rand.nextInt(2);
				 coli = rand.nextInt(col);
				 rowi = rand.nextInt(row);
				 //Verificar se cabe no tabuleiro
				 
				 //direção horizontal
				 if(dir==0) {
					 //sentido para direita
					 if(sen==0) {
						 if(coli+s.getSize()-1<col) {
							 //verificar que esta posição esta vazia
							 for(int i=coli;i<=coli+s.getSize()-1;i++) {
								 if(tabuleiro[rowi][i]!=0)
									 over=false;
							 }
							 //colocar o id no tabuleiro
							 if(over) {
								 for(int i=coli;i<=coli+s.getSize()-1;i++)
									 tabuleiro[rowi][i]=s.getId();
								 fits=true;
							 }
						 }
					 }
					 //sentido para a esquerda
					 else {
						 if(coli-s.getSize()+1>=0) {
							 //verificar que esta posição esta vazia
							 for(int i=coli;i>=coli-s.getSize()+1;i--) {
								 if(tabuleiro[rowi][i]!=0)
									 over=false;
							 }
							 if(over) {
								 //colocar o id no tabuleiro porque a posição esta vazia
								 for(int i=coli;i>=coli-s.getSize()+1;i--)
									 tabuleiro[rowi][i]=s.getId();
								 fits=true;
							 }
						 }
					 }
				 }
				 //direção vertical
				 else {
					 //sentido para cima
					 if(sen==0) {
						 if(rowi-s.getSize()+1>=0) {
							 //verificar se a posição esta vazia
							 for(int i=rowi;i>=rowi-s.getSize()+1;i--) {
								 if(tabuleiro[i][coli]!=0)
									 over=false;
									
							 }
							 if(over) {
								 //colocar o id no tabuleiro porque a posição se encontra vazia
								 for(int i=rowi;i>=rowi-s.getSize()+1;i--) 
									 tabuleiro[i][coli]=s.getId();
								 fits=true; 
							 }
						 }
					 }
					 //sentido para baixo
					 else {
						 if(rowi+s.getSize()-1<row) {
							 //verificar se a posição está vazia
							 for(int i=rowi;i<=rowi+s.getSize()-1;i++) {
								 if(tabuleiro[i][coli]!=0)
									 over=false;
							 }
							 if(over) {
								 //colocar o id no tabuleiro porque a posição se encontra vazia
								 for(int i=rowi;i<=rowi+s.getSize()-1;i++)
									 tabuleiro[i][coli]=s.getId();
								 fits=true; 
							 }
						 }
					 }
				 }
			}
		}
		
		//Print ao tabuleiro
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(j==col-1) 
					System.out.print(tabuleiro[i][j] + "\n");
				else
					System.out.print(tabuleiro[i][j] + " ");
			}
		}
		
		boolean isitover = false;
		int zerocount=0;
		boolean jogadavalida = false;
		String coord = "";
		Scanner jogada = new Scanner(System.in);
		String parteinteira="";
		int boatid=0;
		int idcount=0;
		String bname = "";
		int bsize=0;
		boolean canproceed = true;
		int tentativas = 0;
		while(!isitover) {
			zerocount=0;
			jogadavalida=false;
			boatid=0;
			idcount=0;
			bname= "";
			bsize=0;
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					//ver se o tabuleiro tem apenas zeros ou seja acabou
					if(tabuleiro[i][j]==0)
						zerocount++;
				}
			}
			//se o tabuleiro estiver cheio de zeros jogo acaba
			if(zerocount==row*col)
				isitover=true;
			
			//pedir ao utilizador para jogar

			
			//Validar a jogada
			while(!jogadavalida) {
				canproceed = true;
				System.out.print("Jogada? ");
				coord = jogada.next();
				parteinteira="";
				//tamanho da jogada so pode ser maximo 3
				if(coord.length()<=3) {
					//Primeiro caracter da jogada tem de ser letra
					if((int)coord.charAt(0)>=65 && (int)coord.charAt(0)<=65+col){
						//verificar se restantes caracteres sao numeros e cabem no tabuleiro
						for(int i=1;i<coord.length();i++) {
							if((int)coord.charAt(i)>=48 && (int)coord.charAt(i)<=57) {
								parteinteira+=String.valueOf(coord.charAt(i));
							}
							else {
								canproceed=false;
								System.out.println("Depois de uma letra maiúscula os caracteres seguintes têm de ser números!");
							}
						}
						if(canproceed) {
							if( Integer.parseInt(parteinteira)<=row) {
								jogadavalida=true;
							}
							else {
								System.out.println("A parte numérica da jogada tem de ser menor ou igual do que " + row + "!");
							}
						}
					}
					else {
						System.out.println("O primeiro caracter da jogada tem de ser uma letra maiúscula entre [A-" + (char)(64+col) + "]!");
					}
				}
				else {
					System.out.println("Cada jogada apenas pode ter no máximo 3 caracteres!");
				}
				

			}
			tentativas++;
			
			//jogada valida logo temos de apontar no tabuleiro
			if(tabuleiro[Integer.parseInt(parteinteira)-1][(int)(coord.charAt(0)-64)-1]==0) {
				System.out.println("Água!");
			}
			else {
				boatid=tabuleiro[Integer.parseInt(parteinteira)-1][(int)(coord.charAt(0)-64)-1];
				tabuleiro[Integer.parseInt(parteinteira)-1][(int)(coord.charAt(0)-64)-1]=0;
				for(int i=0;i<row;i++) {
					for(int j=0;j<col;j++) {
						if(tabuleiro[i][j]==boatid) {
							idcount++;
						}
					}
				}
				//percorrer os barcos para saber qual deles tem o id=boatid
				for(Ship s:ships) {
					if(s.getId()==boatid) {
						bname=s.getName();
						bsize=s.getSize();
					}
				}
				if(idcount==0) {
					System.out.println(bname +  " afundado!");
				}
				else {
					System.out.println("Acertaste no " + bname + ", (" + (bsize-idcount) + "/" + bsize + ")");
				}
			}
		}
		
		System.out.println("Parábens, todos os navios afundados com " + tentativas + " tentativas!");
		
		jogada.close();
		
	}

}
