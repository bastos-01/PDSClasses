package LabThree;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {

	static Rua rua;
	
	public static void main(String[] args) {
		
		String cmd = ""; //input
		rua = new Rua();
		
		System.out.println("Usage: \n\tLoad <Filename> \n\tMap \n\tAdd <nome> <x1> <x2> \n\tRemove <name> \n\tList \n\tLookup <name> \n\tClear \n\tQuit \n");
		
		Scanner sc = null;
		boolean printcmd = false;
		if(args.length!=0) {
			try {
				sc = new Scanner(new File(args[0]));
				printcmd = true;
			}catch(FileNotFoundException e) {
				System.out.println("O ficheiro " + args[0] + " passado na linha de comandos não existe!");
				System.exit(0);
			}
		}
		else {
			sc = new Scanner(System.in);
		}
		
		while(!cmd.toUpperCase().equals("QUIT")) {
			
			System.out.println("Command: ");
			cmd = sc.next().toUpperCase();
			//Dar print ao comando caso esteja a ler os comandos de um ficheiro
			if(printcmd) {
				System.out.println(cmd);
			}
			
			switch(cmd) {
				
			case "LOAD":
				//caso o input esteja correto
				if(sc.hasNext()) {
					String file = sc.next();
					//chama a função que faz o comando load
					load(file);
				}
				//caso o utilizador não coloque o ficheiro
				else {
					System.out.println("Não introduziu um ficheiro!");
				}
				break;
				
			case "MAP":
				//cria um novo mapa
				Map<ArrayList<Integer>,Set<Membro>> mapa = new TreeMap<>(new Comparator<ArrayList<Integer>>() {
					//comparator que ordena as famílias por abrangência 
					@Override
					public int compare(ArrayList<Integer> ob1, ArrayList<Integer> ob2) {
						int dif1 = ob1.get(1)-ob1.get(0);
						int dif2 = ob2.get(1)-ob2.get(0);
						
						//da mesma familia
						if(dif2 == dif1 && ob1.get(0)==ob2.get(0) && ob1.get(1)==ob2.get(1)) {
							return 0;
						}
						//menor abrangência
						else if(dif2==dif1) { 
							return -1;
						}
						else {
							return dif2-dif1;
						}
					}
				});
				//percorrer as familias e adicionar ao mapa
				for(Familia f:rua.getFamilias()) {
					ArrayList<Integer> doors = new ArrayList<>();
					doors.add(f.getX1());
					doors.add(f.getX2());
					Set<Membro> membs = f.getMembros();
					mapa.put(doors,membs);
				}
				//print do mapa no terminal
				mapPrint(mapa);
				break;
			
			case "ADD":
				//se o utilizador introduziu informações do membro que quer adicionar
				if(sc.hasNext()) {
					String [] input = sc.nextLine().split(" ");
					//se o utilizador não colocou os 3 campos desejados
					if(input.length != 4) {
						System.out.println("Usage: Add <nome> <x1> <x2>");
						break;
					}
					//chama a função add que adiciona o membro
					add(input[1],Integer.parseInt(input[2]), Integer.parseInt(input[3]));
				}
				//se o utilizador não colocou informações
				else {
					System.out.println("Não introduziu informações do membro a adicionar!");
				}
				break;
				
			case "REMOVE":
				//se o utilizador não coloca o nome par remover
				if(!sc.hasNext()) {
					System.out.println("Introduza um nome que quer remover!");
				}
				//se coloca o nome
				else {
					//chama a função que faz o remove
					remove(sc.next());
				}
				break;
				
			case "LIST":
				//chama a função que lista os membros
				list();
				break;
				
			case "LOOKUP":
				//se o utilizador coloca membro
				if(sc.hasNext()) {
					String nome = sc.next();
					//chama a função que faz o comando lookup
					lookup(nome);
				}
				//se o utilizador não coloca membro
				else {
					System.out.println("Introduza um nome para procurar!");
				}
				break;
			case "CLEAR":
				//limpa a rua e cria uma nova
				rua = new Rua();
				break;
			case "QUIT":
				//acaba o programa
				break;
			default:
				System.out.println("Input inválido!");
			
			}
			
		}
		sc.close();
		System.out.println("Fim do programa!");
		System.exit(0);

	}
	
	//******************************************************* LOOKUP COMMAND *******************************************************
	
	private static void lookup(String nome) {
		//percorrer os membros da rua
		for(Membro m: rua.getMembros()) {
			if(m.getNome().equals(nome)) { 
				//percorrer as familias
				for(Familia f: rua.getFamilias()) {
					//encontrar o membro e dá print do x1 e x2 da familia e os membros
					if(f.getMembros().contains(m)) {
						System.out.printf("%s %s :", f.getX1(), f.getX2());
						for(Membro memb: f.getMembros()) {
							System.out.printf(" %s ", memb.getNome());
						}
					}
				}
				System.out.println();
				return;
			}
		}
		//caso não encontre o nome
		System.out.println("Nome procurado não existe!");
		return;
		
	}
	
	//******************************************************* LIST COMMAND *******************************************************

	private static void list() {
		//percorrer os membros da rua
		for(Membro m: rua.getMembros()) {
			//print das stats cada membro
			System.out.printf("%15s%5s%5s", m.getNome(), m.getX1(), m.getX2());
			System.out.println();
		}
		
	}
	
	//******************************************************* REMOVE COMMAND *******************************************************

	private static void remove(String nome) {
		//percorrer os membros da rua
		for(Membro m: rua.getMembros()) {
			if(m.getNome().equals(nome)) {
				//encontrar o nome procurado
				for(Familia f: rua.getFamilias()) {
					//percorrer as familias 
					if(f.getMembros().contains(m)) {
						//encontra a familia que contem o membro procurado
						f.removeMember(m); //remove da familia
						rua.getMembros().remove(m); //remove dos membros da rua
						System.out.println("Removido com sucesso!");
						return;
					}
				}
				
			}
		}
		//caso não encontre o membro
		System.out.println("O nome introduzido não existe!");
		return;
		
		
	}
	
	////******************************************************* MAP COMMAND *******************************************************

	private static void mapPrint(Map<ArrayList<Integer>, Set<Membro>> mapa) {
		int min = 1000;
		int max = 0;
		//se a rua estiver vazia
		if(rua.getMembros().size() == 0) {
			System.out.println("A rua está vazia!");
			return;
		}
		System.out.print("FAMILY");
		System.out.printf("%20s" , "NAME");
		//ir buscar o mínimo e máximo valor de x1 e x2
		for(Familia f: rua.getFamilias()) {
			if(f.getX1() < min) {
				min = f.getX1();
			}
			if(f.getX2() > max) {
				max = f.getX2();
			}
		}
		for(int i = min; i <= max; i++) {
			System.out.printf("%4s", i);
		}
		System.out.println();
		int contador = 1;
		Set set = mapa.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry<ArrayList<Integer>, Set<Membro>> m = (Entry) it.next();
			Iterator it2 = m.getValue().iterator();
			while(it2.hasNext()) {
				System.out.format("%6s%20s", contador, it2.next());
				for(int i = min; i <= max; i++  ) {
					if(i>=m.getKey().get(0) && i <= m.getKey().get(1)) {
						System.out.format("%4s", "X");
					}
					else {
						System.out.format("%4s", "");
					}
				}
				System.out.println();
			}
			contador++;
		}
		
	}
	
	//******************************************************* LOAD COMMAND *******************************************************

	public static void load(String filename) {
		
		Scanner reader = null;
		
		try {
			reader = new Scanner(new File(filename));
		}catch(FileNotFoundException e){
			System.out.println("O ficheiro " + filename + " não existe!");
			return;
		}
		
		String linha = "";
		//boolean que verifica se o ficheiro tem linha introdutória
		boolean hasIntro = false;
		
		if(reader.hasNextLine()) {
			
			linha = reader.nextLine();
			
			//caso tenha linha introdutoria
			if(linha.charAt(0) == '>') {
				hasIntro = true;
			}
		}
		//caso ficheiro esteja vazio
		else{
			System.out.println("Ficheiro vazio!");
			reader.close();
			return;
		}
		
		//percorrer ficheiro
		while(reader.hasNextLine()) {
			
			if(hasIntro) {
				linha = reader.nextLine();
			}
			
			// Guardar dados de cada linha
			String valores = linha.split(" ")[0];
			String nome = linha.split(" ")[1];
			int x1 = Integer.parseInt(valores.split("-")[0]);
			int x2 = Integer.parseInt(valores.split("-")[1]);
			
			boolean retval = false;
			
			//regex para validação dos nomes
			if(nome.matches("[A-Za-z0-9._@]+") && Character.isLetter(nome.charAt(0)) && (Character.isLetter(nome.charAt(nome.length()-1)) || Character.isDigit(nome.charAt(nome.length()-1)))  && nome.length()<=30 && nome.length()>=3 )
				retval = true;
			
			if(retval) {
				// adicionar membro à rua
				Membro m = new Membro(nome, x1, x2);
				//caso o membro não exista já na rua
				if(rua.compararMembro(m)) {
					rua.addMember(m);
					addMembroFamilia(m, x1, x2);
				}
			}
			//caso o nome não seja bem validado
			else {
				System.out.println("O nome " + nome + " não é válido e não foi adicionado à rua!");
			}
			
			hasIntro = true;
		}
		reader.close();
		
	}
	
	//******************************************************* ADD COMMAND *******************************************************
	
	public static void add(String nome, int x1, int x2) {
		
		Membro newMemb = new Membro(nome, x1, x2);
		
		//caso o membro que está a ser adicionado já exita na rua
		if(rua.getMembros().contains(newMemb)) {
			System.out.println("O membro introduzido já existe nesta Rua!");
			return;
		}
		
		//caso ainda não exista na rua
		rua.addMember(newMemb);
		addMembroFamilia(newMemb, x1, x2);
		System.out.println("Adicionado com sucesso!");
		
	}
	
	//******************************************************* ADD MEMBER TO FAMILY *******************************************************
	
	public static void addMembroFamilia(Membro m, int x1, int x2) {
		
		//verificar se já existe a familia com esta localização
		ArrayList<Familia> familias = rua.getFamilias();
		boolean flag = false;
		
		for(Familia f: familias) {
			int val1 = f.getX1();
			int val2 = f.getX2();
			//caso encontre a familia adiciona o membro
			if(x1 == val1 && x2 == val2) {
				f.addMember(m);
				m.setFamilia(f.getId());
				flag = true;
			}
		}
		
		//caso não exista familia
		if(!flag) {
			//adicionar uma nova familia e o membro a mesma
			Familia fam = new Familia(x1, x2);
			rua.addFam(fam);
			fam.addMember(m);
		}
	}
	
	

}