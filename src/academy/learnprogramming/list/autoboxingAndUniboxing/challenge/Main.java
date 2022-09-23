package academy.learnprogramming.list.autoboxingAndUniboxing.challenge;

public class Main {

    public static void main(String[] args) {

        Bank bigBank = new Bank("Big Bank");

        Branch aBranch = new Branch("Some Branch");

        bigBank.addNewBranch(aBranch);
        bigBank.getBankBranches();
        bigBank.searchBranch("Some Branch");
        boolean addedCustomer = bigBank.addNewCustomer("Gigi", 100.00, "Some Branch");
        System.out.println(addedCustomer);
        Customer customer = aBranch.getBranchCustomer("Gigi");
        System.out.println("Customer name " + customer.getName() + " initial amount " +  customer.initialAmount);
        double anotherTransaction = bigBank.addTransaction("Gigi", 200.00, "Another Branch");

        if (anotherTransaction == -1){
            System.out.println("Cannot add transaction");
        } else {
            System.out.println("Transaction amount" + anotherTransaction + " added");
        }
        double thirdTransaction = bigBank.addTransaction("Gigi", 200, "Some Branch");
        if (thirdTransaction == -1){
            System.out.println("Cannot add transaction");
        } else {
            System.out.println("Transaction amount " + thirdTransaction + " added");
        }
        customer.getTransactions();

        bigBank.getBankBranches();
    }
}
