
public class TestBankAccount {
    public static void main(String[] args) {
        CheckingAccount myBank = new CheckingAccount("jane", 100.0);
        myBank.withdraw(10.0, 12);
        myBank.deposit(200);
        SavingsAccount newBank = new SavingsAccount("Joel", 350.75);
        myBank.transferMoney(20.0, newBank, 12);

        // testing # of withdrawals
        System.out.println("Starting Balance: " + newBank.currentAccountBalance);
        newBank.withdraw(20.0, 12);
        System.out.println("after withdraw of 20: " + newBank.currentAccountBalance);
        // this shouldn't count as a withdrawal
        newBank.withdraw(2000.0, 12);
        System.out.println("after withdraw of 2000: " + newBank.currentAccountBalance);
        newBank.deposit(200);
        System.out.println("after deposit of 200: " + newBank.currentAccountBalance);
        newBank.transferMoney(20.0, myBank, 12);
        System.out.println("after transfer of 20: " + newBank.currentAccountBalance);
        newBank.withdraw(20.0, 12);
        newBank.withdraw(20.0, 12);
        newBank.withdraw(20.0, 12);
        newBank.withdraw(20.0, 12);
        //this should give an error
        newBank.withdraw(20.0, 12);

    }
}
