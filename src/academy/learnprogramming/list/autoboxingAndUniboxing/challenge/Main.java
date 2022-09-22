package academy.learnprogramming.list.autoboxingAndUniboxing.challenge;

public class Main {

    public static void main(String[] args) {

        Bank bigBank = new Bank("Big Bank");

        Branch aBranch = new Branch("Some Branch");

        bigBank.addBranch(aBranch);
        bigBank.getBankBranches();

    }
}
