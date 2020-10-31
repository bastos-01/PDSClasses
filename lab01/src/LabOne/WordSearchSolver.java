package LabOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordSearchSolver {

	public static void main(String[] args) {
		
		char[][] sopa_de_letras = null;
		Scanner reader = null;
		int line_count;
		String linha = "";
		ArrayList<String> keys = new ArrayList<>();
		ArrayList<Integer> wordpos = new ArrayList<>();
		ArrayList<String> wordseg = new ArrayList<>();
		//este array ser� uma c�pia do keys e ter� os palindromos 2x seguidas cada 1
		ArrayList<String> keys2 = new ArrayList<>();
		
		String file = args[0];
		
		long start = System.nanoTime();
		
		try {
			reader = new Scanner(new File(file),"utf-8");
		} catch (FileNotFoundException e) {
			System.out.println("O ficheiro n�o existe!");
			System.exit(1);
		}
		
		line_count = 0;
		linha = reader.nextLine();
		int count = linha.length();
		if(count>50) {
			System.out.println("Puzzle demasiado grande!");
			System.exit(1);
		}

		sopa_de_letras = new char[count][count];
		for(int j = 0;j<count;j++) {
			sopa_de_letras[line_count][j] = linha.charAt(j);
		}
		line_count++;

		while(reader.hasNextLine() && line_count<count ) {
			if(linha.length()!=count) {
				System.out.println("Puzzle n�o � quadrado!");
				System.exit(1);
			}
			linha = reader.nextLine();
			if(!linha.toUpperCase().equals(linha)) {
				System.out.println("O puzzle tem letras min�sculas!");
				System.exit(1);
			}
			for(int i=0;i<count;i++) {
				if(!Character.isLetter(linha.charAt(i))) {
					System.out.println("O puzle tem caracteres nao alfab�ticos!");
					System.exit(1);
				}
				sopa_de_letras[line_count][i]=linha.charAt(i);
			}
			line_count++;
		}
		if(line_count!=count) {
			System.out.println("O puzzle nao � quadrado!");
			System.exit(1);
		}
		
		reader.useDelimiter("[^a-zA-Z0-9]+");
		
		String word = null;
		
		while(reader.hasNext()) {
			word = reader.next();
			if(word.toUpperCase().equals(word)) {
				System.out.println("Uma das chaves est� toda em letras mai�sculas!");
				System.exit(1);
			}
			else if(word.length()>=4)
				keys.add(word);
			else {
				System.out.println("Uma das chaves � demasiado pequena!");
				System.exit(1);
			}
				
		}
		
		reader.close();
		//Verificar se alguma das chaves est� contida noutra
		
		for(int i=0;i<keys.size();i++) {
			for(int j=0;j<keys.size();j++) {
				if( i != j) {
					if(keys.get(i).contains(keys.get(j))) {
					System.out.println("Uma das chaves est� contida na outra!");
					System.exit(1);
					}
				}
			}
		}
		
		//Adicionar as chaves ao keys2
		
		for(int i = 0;i<keys.size();i++) {
			keys2.add(keys.get(i));
			if(isPalyndrome(keys.get(i)))
				keys2.add(keys.get(i));
		}

		//Fazer a pesquisa
				int wordcount = 0;
				boolean isin = false;
				int wordline=0;
				int wordcol=0;
				String wordtrail = null;
				int times = 0;
				
				for(String x:keys) {
					for(int i=0;i<count;i++) {
						for(int j=0;j<count;j++) {
							if(Character.toLowerCase(sopa_de_letras[i][j])==Character.toLowerCase(x.charAt(wordcount))) {
								// VERIFICAR SE ESTA PARA CIMA
									if(i-x.length()+1>=0) {
										wordcount = 1;
										for(int y = 1;y<x.length();y++) {
											if(Character.toLowerCase(sopa_de_letras[i-y][j])==Character.toLowerCase(x.charAt(wordcount))) {
												wordcount++;
											}
											else
												break;
										}

										if(wordcount==x.length()) {
											wordline = i+1;
											wordcol = j+1;
											wordtrail = "Up";
											if(isin==false) {
												isin=true;
												if(isPalyndrome(x)) {
													wordpos.add(wordline);
													wordpos.add(wordcol);
													wordseg.add(wordtrail);
												}
											}
											else {
												if(isPalyndrome(x) && times<2) {
													times++;
												}
												else {
													System.out.println("A palavra aparece 2x na sopa de letras!");
													System.exit(1);
												}
											}
										}
										wordcount = 0;
									}
									
									//VERIFICAR SE ESTA PARA BAIXO
										if(i+x.length()-1<count) {
											wordcount = 1;
											for(int y = 1;y<x.length();y++) {
												if(Character.toLowerCase(sopa_de_letras[i+y][j])==Character.toLowerCase(x.charAt(wordcount))) {
													wordcount++;
												}
												else
													break;
											}
											if(wordcount==x.length()) {
												wordline = i+1;
												wordcol = j+1;
												wordtrail = "Down";
												if(isin==false) {
													isin=true;
													if(isPalyndrome(x)) {
														wordpos.add(wordline);
														wordpos.add(wordcol);
														wordseg.add(wordtrail);
													}
												}
												else {
													if(isPalyndrome(x) && times<2) {
														times++;
													}
													else {
														System.out.println("A palavra aparece 2x na sopa de letras!");
														System.exit(1);
													}
												}
											}
											wordcount = 0;
										}
									//VERIFICAR SE ESTA PARA A DIREITA
											if(j+x.length()-1<count) {
												wordcount = 1;
												for(int y = 1;y<x.length();y++) {
													if(Character.toLowerCase(sopa_de_letras[i][j+y])==Character.toLowerCase(x.charAt(wordcount)))
														wordcount++;
													else
														break;
												}
												if(wordcount==x.length()) {
													wordline = i+1;
													wordcol = j+1;
													wordtrail = "Right";
													if(isin==false) {
														isin=true;
														if(isPalyndrome(x)) {
															wordpos.add(wordline);
															wordpos.add(wordcol);
															wordseg.add(wordtrail);
														}
													}
													else {
														if(isPalyndrome(x) && times<2) {
															times++;
														}
														else {
															System.out.println("A palavra aparece 2x na sopa de letras!");
															System.exit(1);
														}
													}
												}
											}
											//VERIFICAR SE ESTA PARA A ESQUERDA
												if(j-x.length()+1>=0) {
													wordcount = 1;
													for(int y = 1;y<x.length();y++) {
														if(Character.toLowerCase(sopa_de_letras[i][j-y])==Character.toLowerCase(x.charAt(wordcount)))
															wordcount++;
														else
															break;
													}
													if(wordcount==x.length()) {
														wordline = i+1;
														wordcol = j+1;
														wordtrail = "Left";
														if(isin==false) {
															isin=true;
															if(isPalyndrome(x)) {
																wordpos.add(wordline);
																wordpos.add(wordcol);
																wordseg.add(wordtrail);
															}
														}
														else {
															if(isPalyndrome(x) && times<2) {
																times++;
															}
															else {
																System.out.println("A palavra aparece 2x na sopa de letras!");
																System.exit(1);
															}
														}
													}
												}
												//VERIFICAR SE ESTA PARA A ESQUERDA E PARA CIMA(DIAGONAL)
													if(j-x.length()+1>=0 && i-x.length()+1>=0) {
														wordcount = 1;
														for(int y = 1;y<x.length();y++) {
															if(Character.toLowerCase(sopa_de_letras[i-y][j-y])==Character.toLowerCase(x.charAt(wordcount)))
																wordcount++;
															else
																break;
														}
														if(wordcount==x.length()) {
															wordline = i+1;
															wordcol = j+1;
															wordtrail = "Up-Left";
															if(isin==false) {
																isin=true;
																if(isPalyndrome(x)) {
																	wordpos.add(wordline);
																	wordpos.add(wordcol);
																	wordseg.add(wordtrail);
																}
															}
															else {
																if(isPalyndrome(x) && times<2) {
																	times++;
																}
																else {
																	System.out.println("A palavra aparece 2x na sopa de letras!");
																	System.exit(1);
																}
															}
														}
													}
													//VERIFICAR SE ESTA PARA A DIREITA E PARA CIMA(DIAGONAL)
														if(i-x.length()+1>=0 && j+x.length()-1<count) {
															wordcount = 1;
															for(int y = 1;y<x.length();y++) {
																if(Character.toLowerCase(sopa_de_letras[i-y][j+y])==Character.toLowerCase(x.charAt(wordcount)))
																	wordcount++;
																else
																	break;
															}
															if(wordcount==x.length()) {
																wordline = i+1;
																wordcol = j+1;
																wordtrail = "Up-Right";
																if(isin==false) {
																	isin=true;
																	if(isPalyndrome(x)) {
																		wordpos.add(wordline);
																		wordpos.add(wordcol);
																		wordseg.add(wordtrail);
																	}
																}
																else {
																	if(isPalyndrome(x) && times<2) {
																		times++;
																	}
																	else {
																		System.out.println("A palavra aparece 2x na sopa de letras!");
																		System.exit(1);
																	}
																}
															}
														}
														//VERIFICAR SE ESTA PARA A DIREITA E PARA BAIXO(DIAGONAL)
															if(i+x.length()-1<count && j+x.length()-1<count) {
																wordcount = 1;
																for(int y = 1;y<x.length();y++) {
																	if(Character.toLowerCase(sopa_de_letras[i+y][j+y])==Character.toLowerCase(x.charAt(wordcount)))
																		wordcount++;
																	else
																		break;
																}
																if(wordcount==x.length()) {
																	wordline = i+1;
																	wordcol = j+1;
																	wordtrail = "Down-Right";
																	if(isin==false) {
																		isin=true;
																		if(isPalyndrome(x)) {
																			wordpos.add(wordline);
																			wordpos.add(wordcol);
																			wordseg.add(wordtrail);
																		}
																	}
																	else {
																		if(isPalyndrome(x) && times<2) {
																			times++;
																		}
																		else {
																			System.out.println("A palavra aparece 2x na sopa de letras!");
																			System.exit(1);
																		}
																	}
																}
															}
															//VERIFICAR SE ESTA PARA A ESQUERDA E PARA BAIXO(DIAGONAL)
																if(i+x.length()-1<count && j-x.length()+1>=0) {
																	wordcount = 1;
																	for(int y = 1;y<x.length();y++) {
																		if(Character.toLowerCase(sopa_de_letras[i+y][j-y])==Character.toLowerCase(x.charAt(wordcount)))
																			wordcount++;
																		else
																			break;
																	}
																	if(wordcount==x.length()) {
																		wordline = i+1;
																		wordcol = j+1;
																		wordtrail = "Down-Left";
																		if(isin==false) {
																			isin=true;
																			if(isPalyndrome(x)) {
																				wordpos.add(wordline);
																				wordpos.add(wordcol);
																				wordseg.add(wordtrail);
																			}
																		}
																		else {
																			if(isPalyndrome(x) && times<2) {
																				times++;
																			}
																			else {
																				System.out.println("A palavra aparece 2x na sopa de letras!");
																				System.exit(1);
																			}
																		}
																	}
																}
									
								}
							wordcount = 0;
								
						}
					}
					if(isin == true) {
						
						wordpos.add(wordline);
						wordpos.add(wordcol);
						wordseg.add(wordtrail);
						isin = false;
					}
					else {
						System.out.println("A palavra " + x + " n�o existe na sopa de letras!");
						System.exit(1);
					}
					times = 0;
				}
			    long end = System.nanoTime();

			    double elapsedTime =(double) (end - start)/1_000_000_000.0;
				
				//Fazer print do output final
				int wordpos_counter = 1;
		
				for(int i=0;i<keys2.size();i++) {
					System.out.printf("\n%-15s %-5s %5s,%-5s %-10s",keys2.get(i).toUpperCase(),keys2.get(i).length(),wordpos.get(wordpos_counter-1),wordpos.get(wordpos_counter),wordseg.get(i));
					wordpos_counter+=2;
				}
				System.out.println("\n");
				System.out.printf("Demorou %3.2fs.",elapsedTime);


			}
		public static boolean isPalyndrome(String str) {
			String temp = "";
			for(int i=str.length()-1;i>=0;i--) {
				temp+=str.charAt(i);
			}
			if(temp.equals(str))
				return true;
			else
				return false;
			}

}
