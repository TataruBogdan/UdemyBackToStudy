package academy.learnprogramming.list.arraylistChallenge;

import java.util.InputMismatchException;
import java.util.Scanner;

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
