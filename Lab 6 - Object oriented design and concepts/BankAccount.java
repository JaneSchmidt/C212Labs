public abstract class BankAccount {
    private String accountOwnerName;
    private double currentAccountBalance;
    // all fields need to be private or protected
    //
    public BankAccount(String accountOwnerName, double currentAccountBalance){
        this.accountOwnerName = accountOwnerName;
        this.currentAccountBalance = currentAccountBalance;
    }

    public double getCurrentAccountBalance(){return(currentAccountBalance);}
    public void setCurrentAccountBalance(double newBalance){currentAccountBalance = newBalance;}
    public void setAccountOwnerName(String name){accountOwnerName = name;}
    public String getAccountOwnerName(){return(accountOwnerName);}

    public double deposit(double amountToDeposit){
        if(amountToDeposit <= 0) throw new IllegalArgumentException("Incorrect deposit amount");
        else{
            currentAccountBalance = currentAccountBalance + amountToDeposit;
        }
        return(currentAccountBalance);
    }

    public abstract double withdraw(double withdrawAmount, int currentMonth);

    public abstract void transferMoney(double amountToTransfer, BankAccount accountToTransferTo, int currentMonth);
}
