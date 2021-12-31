public class CheckingAccount extends BankAccount{

    public CheckingAccount(String accountOwnerName, double currentAccountBalance){
        super(accountOwnerName, currentAccountBalance);
    }
    double currentAccountBalance = getCurrentAccountBalance();

    @Override
    public double deposit(double amountToDeposit){
        if(amountToDeposit <= 0) throw new IllegalArgumentException("Incorrect deposit amount");
        else{
            currentAccountBalance = currentAccountBalance + amountToDeposit;
        }
        return(currentAccountBalance);
    }

    public double withdraw(double withdrawAmount, int currentMonth){
        if(withdrawAmount <= 0) throw new IllegalArgumentException("Incorrect withdraw amount");
        else{
            if(withdrawAmount > currentAccountBalance && currentAccountBalance > 0){
                return(currentAccountBalance);
            } else if(withdrawAmount > currentAccountBalance && currentAccountBalance < 0) {
                return(withdrawAmount);
            } else {
                currentAccountBalance = currentAccountBalance - withdrawAmount;
                return (currentAccountBalance);
            }
        }
    }
    public void transferMoney(double amountToTransfer, BankAccount accountToTransferTo, int currentMonth){
        double actualTransferAmount = amountToTransfer * 0.97;
        accountToTransferTo.deposit(actualTransferAmount);
        currentAccountBalance = currentAccountBalance - amountToTransfer;
    }

}
