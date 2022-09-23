package academy.learnprogramming.list.autoboxingAndUniboxing.challenge;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> bankBranch;

    public Bank(String name) {
        this.name = name;
        this.bankBranch = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void getBankBranches() {
        for (Branch branch: bankBranch) {
            System.out.println("Bank has: branch " + branch.getName());
        }
    }


    public boolean addNewBranch(Branch branch){
        int foundBranch = bankBranch.indexOf(branch);
        if (foundBranch != -1){
            System.out.println("Cannot add branch. Branch already exists");
            return false;
        }
        bankBranch.add(branch);
        return true;
    }

    // add a customer to that branch with initial transaction
    public boolean addNewCustomer(String name, double transaction,String branch){
        Branch foundBranch = findBranch(branch);
        // if branch exists
        if (foundBranch != null){
            //search to see if the customer exists
            Customer foundCustomer = findCustomer(name, branch);
            if (foundCustomer == null){
                foundBranch.addCustomer(name, transaction);
                return true;
            }
            System.out.println("Customer already exists");
            return false;
        }
        return false;
    }

    private Customer findCustomer(String customer, String branch){
        Branch foundBranch = findBranch(branch);
        if (foundBranch != null){
            return foundBranch.getBranchCustomer(customer);
        }
        return null;
    }

    public double addTransaction(String customer, double transaction, String branch){
        Branch foundBranch = findBranch(branch);
        if (foundBranch != null){
            Customer foundCustomer = foundBranch.getBranchCustomer(customer);
            return foundCustomer.addTransaction(transaction);
        }else {
            return -1;
        }
    }

    public boolean searchBranch(String name){
        for (int i = 0; i < bankBranch.size(); i++) {
            if (bankBranch.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    private Branch findBranch(String name){
        for (int i = 0; i < bankBranch.size(); i++) {
            if (bankBranch.get(i).getName().equals(name)){
                return bankBranch.get(i);
            }
        }
        return null;
    }



}
