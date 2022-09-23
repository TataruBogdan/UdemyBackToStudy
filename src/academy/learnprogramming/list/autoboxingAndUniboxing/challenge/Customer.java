package academy.learnprogramming.list.autoboxingAndUniboxing.challenge;


import java.util.ArrayList;

// should have an arraylist of Doubles(transactions)
// need to add a new customer and initial transaction amount;
public class Customer {

    private String name;


    private ArrayList<Double> transactions;


    // Customer has an initial amount
    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<>();
        addTransaction(initialAmount);
    }

    public void getTransactions() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println("Transactions :" + transactions.get(i));
        }
    }

    public String getName() {
        return name;
    }

    // TODO - expose al transactions ?


    public double addTransaction(double transaction){
        if (transactions.add(transaction)){
            return transaction;
        }
        return -1;
    }



    // create a Customer object at static level
    /*
    public Customer createCustomer(String name, double initialAmount){
        return new Customer(name, initialAmount);
    }*/


}
