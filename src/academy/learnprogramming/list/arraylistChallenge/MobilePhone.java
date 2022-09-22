package academy.learnprogramming.list.arraylistChallenge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class MobilePhone {

    // create an Array List of Contacts

    private static ArrayList<Contacts> contactsList = new ArrayList<>();


    public ArrayList<Contacts> getContactsList() {
        return contactsList;
    }

    // store/save a contact into our contactsList
    // is our contact saves -> true or false
    //TODO - search to see if the name already exist - if do don't add
    public boolean addNewContact(String name, String phoneNumber){
        if (findContact(name)){
            System.out.println("Contact with name" + name + " already exists");
            return false;
        }
        contactsList.add(new Contacts(name, phoneNumber));
        return true;


    }

    // modify an existing contact with a new contact
    // exist the contact ?
    // return replaced contact
    public Contacts updateContact(String existingContact, String newContact, String newTelephoneNumber){
        int foundContactIndex = findContactIndex(existingContact); // found old contact ?
        Contacts contact = new Contacts(newContact, newTelephoneNumber);
        if (foundContactIndex != -1){
            Contacts replacedContact = contactsList.set(foundContactIndex, contact);
            return replacedContact;
        }
        return null;
    }

    public boolean findContact(String name) {
        for (Contacts contact : contactsList) {
            if (contact.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    // find contact index
    private int findContactIndex(String name) {

        for (Contacts contact : contactsList) {
            if (contact.getName().equals(name)) {
                return contactsList.indexOf(contact);
            }
        }
        return -1;
    }

    // search the contact by name
    // return the object found or null
    public Contacts searchContact(String name) {
        int foundContact = findContactIndex(name); // found contact ?
        if (foundContact != -1) {
            return contactsList.get(foundContact);
        }
        return null;
    }

    // remove an existing contact
    public Contacts removeContact(String name){
        Contacts foundContact = searchContact(name); // found contact ?
        boolean removed = contactsList.remove(foundContact);
        if (removed){
            return foundContact;
        }
        return null;
    }




}
