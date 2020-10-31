package ex3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Livro l1 = new Livro("Java Anti-Stress", 1, 2018, "Omodionah");
		Livro l2 = new Livro("A Guerra dos Padrões", 2, 2019, "Jorge Omel");
		Livro l3 = new Livro("A Procura da Luz", 3, 2017, "Khumatkli");

		ArrayList<Livro> livros = new ArrayList<>();
		livros.add(l1);
		livros.add(l2);
		livros.add(l3);

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("*** Biblioteca ***");
			
			for (Livro livro : livros)
				System.out.println(livro);
			System.out.println(">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela \n");
			System.out.print(">> ");

			String line = sc.nextLine();

			String[] input = line.split(",");
			int numLivro = Integer.parseInt(input[0]) - 1;
			int op = Integer.parseInt(input[1]);

			switch (op) {
			
				case 1:
					livros.get(numLivro).regista();
					break;
					
				case 2:
					livros.get(numLivro).requesita();
					break;
	
				case 3:
					livros.get(numLivro).devolve();
					break;
	
				case 4:
					livros.get(numLivro).reserva();
					break;
	
				case 5:
					livros.get(numLivro).cancelaReserva();
					break;
			}
			
		} while (true);

	}

}
