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
        this.transactions.add(initialAmount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public double addTransaction(double transaction){
        if (transactions.add(transaction)){
            return transaction;
        }
        return -1;
    }
}
