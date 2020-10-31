package LabSix;

import java.util.ArrayList;
import java.util.List;

public class Contacts implements ContactsInterface{
	
	private List<Contact> contacts;
	private ContactsStorageInterface str = null;
	
	public Contacts () {
		this.contacts = new ArrayList<>();
	}
	
	@Override
	public void openAndLoad(ContactsStorageInterface store) {
		if(store.loadContacts() != null) {
			contacts.addAll(store.loadContacts());
			System.out.println("Contacts loaded successfully from the file!");
		}
		else {
			System.out.println("The file is empty!");
		}
		
	}

	@Override
	public void saveAndClose() {
		if(str.saveContacts(contacts))
			System.out.println("Sucesso!");
		else
			System.out.println("Contactos nao foram guardados!");
		
		
	}

	@Override
	public void saveAndClose(ContactsStorageInterface store) {
		
		str = store;
		boolean retVal = str.saveContacts(contacts);
		
		if(retVal) {
			System.out.println("Contacts saved successfully in the file!");
		}
		else {
			System.out.println("Error saving contacts!");
		}
		
	}

	@Override
	public boolean exist(Contact contact) {
		
		for(Contact c: contacts) {
			if(c.getNum() == contact.getNum()) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Contact getByName(String name) {
		
		for(Contact c: contacts) {
			if(c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public boolean add(Contact contact) {
		if(contacts.contains(contact)) {
			System.out.println("Contact already exists in the list!");
			return false;
		}
		else {
			System.out.println("Adding " + contact.getName() + " ...");
			contacts.add(contact);
			return true;
		}
	}

	@Override
	public boolean remove(Contact contact) {
		if(contacts.contains(contact)) {
			System.out.println("Removing " + contact.getName() + " ...");
			contacts.remove(contact);
			return true;
		}
		else {
			System.out.println("Failed to remove because contact is not in the list!");
			return false;
		}
		
	}
	
	public List<Contact> getContacts(){
		if(contacts.size() == 0) {
			System.out.println("No contacts!");
			return null;
		}
		return contacts;
	}
	
	public boolean resetContacts(){
        try{
            contacts.removeAll(contacts);
            System.out.println("Contacts deleted");
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
