package academy.learnprogramming.list.arraylistChallenge;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
* create a program that implements a very simple mobile phone with the following capabilities.
* The ability to store, to modify, to remove, and to query contact names.
* The contact names are those records for people who have been added as a contact on the mobile phone.
* create a separate class for contacts. actual fields we want would be name and phone number.
* create a master class(MobilePhone) that holds the ArrayList of Contacts.
* MobilePhone class itself has the functionality listed above.
* add a menu of options that are available to quit, to print a list of contacts,
* to add a new contact, update an existing contact,to remove a contact, and also the search / find a contact.
* Be sure, when you're adding or updating, that you check if a contact already exists, by using the name.
* be sure not to expose any of the inner workings of the ArrayList to any class that's accessing this.
* no direct ints.  .get(i) in the ArrayList.
* mobile phone class we're only dealing with contact objects only. */


public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static MobilePhone mobilePhoneList = new MobilePhone();

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        // while user in not chose quit
        printInstructions();
        while (!quit) {
            try {
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        quit = true;
                        break;
                    case 2:
                        printListOfContacts();
                        break;
                    case 3:
                        addNewContact();
                        break;
                    case 4:
                        updateExistingContact();
                        break;
                    case 5:
                        removeContact();
                        break;
                    case 6:
                        searchContact();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong choice " + e.getMessage());
            }
            scanner.nextLine();
        }
    }


    // create the menu of options
    public static void printInstructions() {

        System.out.println("\nPress: ");
        System.out.println("\t 1. Quit.");
        System.out.println("\t 2. Print list of contacts.");
        System.out.println("\t 3. Add new contact.");
        System.out.println("\t 4. Update a contact.");
        System.out.println("\t 5. Remove a contact.");
        System.out.println("\t 6. Search/find a contact.");
    }

    // action ->
    public static void printListOfContacts() {

        if (mobilePhoneList.getContactsList().isEmpty()) {
            System.out.println("No contacts found");
        } else {
            for (Contacts contact : mobilePhoneList.getContactsList()) {
                System.out.println(contact.getName() + " telephone number :" + contact.getPhoneNumber());
            }
        }
    }


    public static void addNewContact() {
        System.out.println("Enter a new contact name: ");
        String contactName = scanner.next();
        System.out.println("Enter the telephone number");
        String phoneNumber = scanner.next();
        boolean foundContact = mobilePhoneList.findContact(contactName);
        if (!foundContact) {
            mobilePhoneList.addNewContact(contactName, phoneNumber);
            System.out.println("Contact " + contactName + " with phone number " + phoneNumber + " added");
        } else {
            System.out.println("Cannot add contact, contact already exist");
        }
    }

    public static void updateExistingContact() {
        System.out.println("Enter a existing contact name to update");
        String existingContactName = scanner.next();
        boolean found = mobilePhoneList.findContact(existingContactName);
        if (found){
            System.out.println("Enter new contact name");
            String newContact = scanner.next();
            System.out.println("Enter new the telephone number");
            String phoneNumber = scanner.next();
            Contacts previousContact = mobilePhoneList.updateContact(existingContactName, newContact, phoneNumber);
            System.out.println("Previous contact " + previousContact.getName() + " replaced");
        }else {
            System.out.println("Contact not found");
        }
    }

    public static void removeContact() {

        System.out.println("Enter contact name to remove ");
        String contactToRemove = scanner.next();
        boolean found = mobilePhoneList.findContact(contactToRemove);
        if (found){
            Contacts removedContact = mobilePhoneList.removeContact(contactToRemove);
            System.out.println("Contact " + removedContact.getName() + " removed");
        } else {
            System.out.println("Cannot find " + contactToRemove);
        }
    }

    public static void searchContact() {
        System.out.println("Enter contact name to search ");
        String contactToSearch = scanner.next();
        boolean found = mobilePhoneList.findContact(contactToSearch);
        if (found){
            Contacts searchContact = mobilePhoneList.searchContact(contactToSearch);
            System.out.println("Found " + searchContact.getName() + " phone number: " + searchContact.getPhoneNumber());
        } else {
            System.out.println("Cannot find " + contactToSearch);
        }

    }
}
