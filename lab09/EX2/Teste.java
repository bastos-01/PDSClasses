package EX2;

import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		
		ArrayList<String> ourList = new ArrayList<>();
        Add<String> addCommand = new Add<String>(ourList);
        Remove<String> removeCommand = new Remove<String>(ourList);

        addCommand.execute("firstAdd");
        addCommand.execute("SecondAdd");
        addCommand.execute("ThirdAdd");

        System.out.println("Size after 3 addCommands : "+ourList.size());
        if(ourList.size()>1){
            System.out.println("Element at index 0: " + ourList.get(0));
            System.out.println("Element at index 1: " + ourList.get(1));
            System.out.println("Element at index 2: " + ourList.get(2));
        }

        addCommand.undo();
        addCommand.undo();
        System.out.printf("Size of list after 2 undos: %d, Element at index 0: %s \n", ourList.size(), ourList.get(0));
       
        removeCommand.execute("firstAdd");
        System.out.println("Size of list after removeCommand of firstAdd : " + ourList.size());

        removeCommand.undo();
        System.out.println("Element at index 0 after first removeCommand undo : " + ourList.get(0));
	}

}
