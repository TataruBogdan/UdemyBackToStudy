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

    // TODo - add validation for adding Branch
    public boolean addBranch(Branch branch){
        bankBranch.add(branch);
        return true;
    }

}
