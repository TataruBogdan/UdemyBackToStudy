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

    public ArrayList<Customer> getBranchCustomers() {
        return branchCustomers;
    }

    public boolean addCustomer(String customer, double initialAmount) {
        return branchCustomers.add(new Customer(customer, initialAmount));
    }

    //add additional transaction for that customer per branch
    public boolean addTransaction(String customer, double transaction) {
        Customer foundCustomer = getBranchCustomer(customer);
        if (foundCustomer == null) {
            System.out.println("Cannot find customer");
            return false;
        } else {
            for (int i = 0; i < branchCustomers.size(); i++) {
                branchCustomers.get(i).addTransaction(transaction);
                return true;
            }
        }
        return false;
    }

    public Customer getBranchCustomer(String name) {
        for (Customer customer : branchCustomers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }


}
