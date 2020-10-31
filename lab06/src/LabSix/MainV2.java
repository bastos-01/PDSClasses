package LabSix;

import java.io.File;

public class MainV2 {
	
	 public static void main(String[] args){
	        Contacts aplication = new Contacts();

	        File txtFile = new File("ex2Text.txt");
	        File binFile = new File("binTeste.dat");
	        ContactsStorageInterface txtStorage = new Txt(txtFile);
	        ContactsStorageInterface binStorage = new Binary(binFile);
	        
	        //Loading Text File
	        aplication.openAndLoad(txtStorage);

	        //Searching by name
	        System.out.println(aplication.getByName("Pedro Bastos"));

	        //Adding new contact and checking if it was added
	        aplication.add(new Contact(92156, "Antonio Costa"));
	        System.out.println(aplication.getByName("Antonio Costa"));
	       

	        //Removing and checking if it got removed
	        aplication.remove(aplication.getByName("Pedro Bastos"));
	        System.out.println("Checking if Pedro Bastos is the list after being removed: " + aplication.exist(new Contact(93150,"Pedro Bastos")));
	        
	        
	        // ------------------------------------------------------------------------------------------------------------------------------------

	        System.out.println("\n");
	        //Saving list to binary file 
	        aplication.saveAndClose(binStorage);
	        System.out.println(aplication.getContacts());
	        
	        //Reseting list of contacts
	        aplication.resetContacts();
	        aplication.getContacts();
	        
	        //Opening binary file
	        aplication.openAndLoad(binStorage);
	        System.out.println(aplication.getContacts());
	        
	        
	    }

}
