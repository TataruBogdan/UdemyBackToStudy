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

    public String getPhoneNUmber() {
        return phoneNUmber;
    }

    // we don't have to create a new object instance for this contact class.
    public static Contact createContact(String name, String phoneNUmber){
        return new Contact(name, phoneNUmber);
    }
}
