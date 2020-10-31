package ex5;

public class Main {

	public static void main(String[] args) {

		if (args.length == 2) {
			int k = 0;
			boolean recursive = false;

			for (String i : args) {

				if (i.equals("-r")) {
					k++;
					recursive = true;
				}

			}
			System.out.println("Analysing " + args[k].split("/")[args[k].split("/").length - 1]);

			SizeCalc calculator = new SizeCalc();

			System.out.println("Total: " + calculator.getSize(args[k], recursive) + "kB");

		} else {

			System.out.println("Analysing " + args[0].split("/")[args[0].split("/").length - 1]);
			SizeCalc calculator = new SizeCalc();
			System.out.println("Total: " + calculator.getSize(args[0], false) + "kB");
		}
	}

}
