package academy.learnprogramming.list.autoboxingAndUniboxing.challenge;

import java.util.ArrayList;

public class Branch {

    private String name;

    private ArrayList<Customer> branchCustomers;


    public Branch(String name) {
        this.name = name;
        this.branchCustomers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // TODO - expose al branchCustomers - Ok can do
    public ArrayList<Customer> getBranchCustomers() {
        return branchCustomers;
    }

    public boolean addCustomer(String customer, double initialAmount) {
        if (getBranchCustomer(customer) == null){
            return branchCustomers.add(new Customer(customer, initialAmount));
        }
        return false;
    }


    //add additional transaction for that customer per branch
    public boolean addCustomerTransaction(String customer, double transaction) {
        Customer foundCustomer = getBranchCustomer(customer);
        if (foundCustomer == null) {
            System.out.println("Cannot find customer");
            return false;
        } else {
            foundCustomer.addTransaction(transaction);
        }
        return false;
    }

    //TODO - must be private
    public Customer getBranchCustomer(String name) {
        for (Customer customer : branchCustomers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
}
