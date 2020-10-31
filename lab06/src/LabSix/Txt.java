package LabSix;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Txt implements ContactsStorageInterface{
	
	private File txtFile;
	
	public Txt(File txtFile) {
		this.txtFile = txtFile;
	}

	@Override
	public List<Contact> loadContacts() {
		
		List<Contact> contactos = new ArrayList<>();
		Scanner reader = null;
		
		try {
			reader = new Scanner(txtFile);
		}catch(Exception e) {
			System.out.println("ERROR! " + e.toString());
		}
		String[] line;
		while(reader.hasNext()) {
			line = reader.nextLine().split("\t");
			for(String s: line) {
				Contact c = new Contact(Integer.parseInt(s.split(" - ")[0]), s.split(" - ")[1]);
				if(!contactos.contains(c)) {
					contactos.add(c);
				}
				
			}
		}
		reader.close();
		
		return contactos;
	}

	@Override
	public boolean saveContacts(List<Contact> list) {
		try{
            FileWriter writer = new FileWriter(txtFile);
            
            for(Contact c : list){
                writer.write(c.getNum() + " - " + c.getName() + "\t");
            }
            
            writer.close();
            return true;
            
        }catch(Exception e){
        	System.out.println("ERROR! " + e.toString());
            return false;
        }
    }
	

}
