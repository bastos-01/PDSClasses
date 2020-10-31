package LabSix;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Binary implements ContactsStorageInterface{
	
	private File binFile;
	
	public Binary(File f) {
		this.binFile = f;
	}

	@Override
	public List<Contact> loadContacts() {

		List<Contact> contactos = new ArrayList<>();
		
		try {
			FileInputStream fr = new FileInputStream(binFile);
			
			String line = "";
			int ch;
			
		    while ((ch = fr.read()) != -1) {
		    	line = line + (char) ch;
		    }
		    String[] contacts = line.split("\t");
		    for(String c: contacts) {
		    	contactos.add(new Contact(Integer.parseInt(c.split(" - ")[0]), c.split(" - ")[1]));
		    }
		    fr.close();
		    
		    
		    
			
		}catch(Exception e) {
			System.out.println("ERROR! " + e.toString());
		}
		
	
		
		return contactos;
	}

	@Override
	public boolean saveContacts(List<Contact> list) {
		try{
			FileOutputStream writer = new FileOutputStream(binFile);
            
            for(Contact c : list){
                writer.write((c.getNum() + " - " + c.getName() + "\t").getBytes());
            }
            writer.close();
            return true;
            
        }catch(IOException e){
        	e.printStackTrace();
            return false;
        }
	}

}
