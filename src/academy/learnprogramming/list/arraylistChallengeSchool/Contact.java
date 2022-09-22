package academy.learnprogramming.list.arraylistChallengeSchool;

public class Contact {

    private String name;
    private String phoneNUmber;

    public Contact(String name, String phoneNUmber) {
        this.name = name;
        this.phoneNUmber = phoneNUmber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNUmber;
    }

    // we don't have to create a new object instance for this contact class.

    //factory method as well.
    public static Contact createContact(String name, String phoneNUmber){
        return new Contact(name, phoneNUmber);
    }
}
