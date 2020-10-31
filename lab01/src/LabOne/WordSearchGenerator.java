package LabOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordSearchGenerator {
	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException {
		
		String flag = null;
		String file = null;
		int len = 0;
		String savefile = null;
		ArrayList<String> keys = new ArrayList<>();
		char[][] puzzle = null;
		
		for(int i=0;i<args.length;i+=2) {
			flag = args[i];
			
			switch (flag) {
			case "-i":
				file = args[i+1];
				break;
			case "-s":
				len = Integer.parseInt(args[i+1]);
				break;
			case "-o":
				savefile = args[i+1];
				break;
			default:
				System.out.println("Flag n�o identificada!");
				System.exit(1);
			}
		}
		
		Scanner reader = null;
		
		try {
			reader = new Scanner(new File(file),"utf-8");
		} catch(FileNotFoundException e) {
			System.out.println("O ficheiro n�o existe!");
			System.exit(1);
		}
		
		if(len>50) {
			System.out.println("Sopa de letras demasiado grande!");
			System.exit(1);
		}
		else {
			puzzle = new char[len][len];
		}
		
		reader.useDelimiter("[^a-zA-Z0-9]+");
		String word = null;
		
		while(reader.hasNext()) {
			word = reader.next();
			if(word.length()<4) {
				System.out.println("Chave demasiado pequena!");
				System.exit(1);
			}
			if(word.toUpperCase().equals(word)) {
				System.out.println("Uma chave tem todas as letras mai�sculas!");
				System.exit(1);
			}
			for(int i=0;i<word.length();i++) {
				if(!Character.isLetter(word.charAt(i))) {
					System.out.println("Uma das chaves tem caracteres n�o alfab�ticos!");
					System.exit(1);
				}
			}
			keys.add(word);
		}
		
		reader.close();
		
		Random rand = new Random();
		
		//Gera��o da sopa de letras
		boolean bool = false;
		int col = 0;
		int line = 0;
		int dir = 0;
		int c=0;
		
		for(String x:keys) {
			bool=false;
			while(!bool) {
				c=0;
				col = rand.nextInt(len);
				line = rand.nextInt(len);
				
				dir = rand.nextInt(7);
				
				switch(dir) {
				case 0:
					//dire��o para cima
					if(line-x.length()+1>=0) {
						for(int j=0;j<x.length();j++) {
							if(puzzle[line-j][col]=='\u0000' || puzzle[line-j][col]==Character.toUpperCase(x.charAt(j)))
								c++;
						}
						if(c==x.length()) {
							bool=true;
							for(int i=0;i<x.length();i++) {
								puzzle[line-i][col]=Character.toUpperCase(x.charAt(i));
							}
						}
					}
					break;
				case 1:
					//dire��o para baixo
					if(line+x.length()-1<len) {
						for(int j=0;j<x.length();j++) {
							if(puzzle[line+j][col]=='\u0000' || puzzle[line+j][col]==Character.toUpperCase(x.charAt(j)))
								c++;
						}
						if(c==x.length()) {
							bool=true;
							for(int i=0;i<x.length();i++) {
								puzzle[line+i][col]=Character.toUpperCase(x.charAt(i));
							}
						}
					}
					break;
				case 2:
					//dire��o para direita
					if(col+x.length()-1<len) {
						for(int j=0;j<x.length();j++) {
							if(puzzle[line][col+j]=='\u0000' || puzzle[line][col+j]==Character.toUpperCase(x.charAt(j)))
								c++;
						}
						if(c==x.length()) {
							bool=true;
							for(int i=0;i<x.length();i++){
								puzzle[line][col+i]=Character.toUpperCase(x.charAt(i));
							}
						}
					}
					break;
				case 3:
					//dire��o para a esquerda
					if(col-x.length()+1>=0) {
						for(int j=0;j<x.length();j++) {
							if(puzzle[line][col-j]=='\u0000' || puzzle[line][col-j]==Character.toUpperCase(x.charAt(j)))
								c++;
						}
						if(c==x.length()) {
							bool=true;
							for(int i=0;i<x.length();i++) {
								puzzle[line][col-i]=Character.toUpperCase(x.charAt(i));
							}
						}
					}
					break;
				case 4:
					//dire��o para esquerda e para cima
					if(col-x.length()+1>=0 && line-x.length()+1>=0) {
						for(int j=0;j<x.length();j++) {
							if(puzzle[line-j][col-j]=='\u0000' || puzzle[line-j][col-j]==Character.toUpperCase(x.charAt(j)))
								c++;
						}
						if(c==x.length()) {
							bool=true;
							for(int i=0;i<x.length();i++) {
								puzzle[line-i][col-i]=Character.toUpperCase(x.charAt(i));
							}
						}
					}
					break;
				case 5:
					//dire��o para a direita e para cima
					if(line-x.length()+1>=0 && col+x.length()-1<len) {
						for(int j=0;j<x.length();j++) {
							if(puzzle[line-j][col+j]=='\u0000' || puzzle[line-j][col+j]==Character.toUpperCase(x.charAt(j)))
								c++;
						}
						if(c==x.length()) {
							bool=true;
							for(int i=0;i<x.length();i++) {
								puzzle[line-i][col+i]=Character.toUpperCase(x.charAt(i));
							}
						}
					}
					break;
				case 6:
					//dire��o para a direita e para baixo
					if(line+x.length()-1<len && col+x.length()-1<len) {
						for(int j=0;j<x.length();j++) {
							if(puzzle[line+j][col+j]=='\u0000' || puzzle[line+j][col+j]==Character.toUpperCase(x.charAt(j)))
								c++;
						}
						if(c==x.length()) {
							bool=true;
							for(int i=0;i<x.length();i++) {
								puzzle[line+i][col+i]=Character.toUpperCase(x.charAt(i));
							}
						}
					}
					break;
				case 7:
					//dire��o para a esquerda e para baixo
					if(line+x.length()-1<len && col-x.length()+1>=0) {
						for(int j=0;j<x.length();j++) {
							if(puzzle[line+j][col-j]=='\u0000' || puzzle[line+j][col-j]==Character.toUpperCase(x.charAt(j)))
								c++;
						}
						if(c==x.length()) {
							bool=true;
							for(int i=0;i<x.length();i++) {
								puzzle[line+i][col-i]=Character.toUpperCase(x.charAt(i));
							}
						}
					}
					break;
				default:
					System.out.println("N�mero random gerado inv�lido!");
					System.exit(1);
				}
			}
		}
		
		//gerar as letras da sopa que ainda nao foram geradas
		
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				if(puzzle[i][j]=='\u0000') {
					puzzle[i][j]=(char)(rand.nextInt(26) + 'A');
				}
			}
		}
		
		
		//Escrever o puzzle num ficheiro
		
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(new File(savefile));
		} catch (IOException e) {
			System.out.println("Imposs�vel escrever no ficheiro!");
			System.exit(1);
		}
		
		
		//Escrever o puzzle no ficheiro
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				writer.write(puzzle[i][j]);
			}
			writer.write("\n");
		}
		
		//Escrever as chaves no ficheiro
		for(int i=0;i<keys.size();i++) {
			writer.write(keys.get(i) + ";");
		}
		
		writer.close();
		
		System.out.println("Sopa de letras gerada com sucesso!");
	}

}
