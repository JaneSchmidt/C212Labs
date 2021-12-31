public class SavingsAccount extends BankAccount{
    private int lastMonth = 0;
    private int withdrawalsThisMonth = 0;
    public SavingsAccount(String accountOwnerName, double currentAccountBalance){
        super(accountOwnerName, currentAccountBalance);
    }

    public int getWithdrawalsThisMonth(){return(withdrawalsThisMonth);}
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
        if(currentMonth == lastMonth) {
            if (withdrawalsThisMonth == 6) throw new IllegalArgumentException("You have already withdrawn/transferred 6 times this month");
            else {
                if(withdrawAmount <= 0) throw new IllegalArgumentException("Incorrect withdraw amount");
                else if(withdrawAmount > currentAccountBalance && currentAccountBalance > 0){
                    return(currentAccountBalance);
                } else if(withdrawAmount > currentAccountBalance && currentAccountBalance < 0) {
                    return(withdrawAmount);
                } else {
                    currentAccountBalance = currentAccountBalance - withdrawAmount;
                    withdrawalsThisMonth++;
                    return (currentAccountBalance);
                }
            }
        } else{
            withdrawalsThisMonth = 0;
            lastMonth = currentMonth;
            if(withdrawAmount <= 0) throw new IllegalArgumentException("Incorrect withdraw amount");
            else if(withdrawAmount > currentAccountBalance && currentAccountBalance > 0){
                return(currentAccountBalance);
            } else if(withdrawAmount > currentAccountBalance && currentAccountBalance < 0) {
                return(withdrawAmount);
            } else {
                currentAccountBalance = currentAccountBalance - withdrawAmount;
                withdrawalsThisMonth++;
                return (currentAccountBalance);
            }
        }
    }
    public void transferMoney(double amountToTransfer, BankAccount accountToTransferTo, int currentMonth){
        double actualTransferAmount = amountToTransfer * 0.97;
        if (withdrawalsThisMonth == 6) throw new IllegalArgumentException("You have already withdrawn/transferred 6 times this month");
        else{
            accountToTransferTo.deposit(actualTransferAmount);
            withdrawalsThisMonth++;
            currentAccountBalance = currentAccountBalance - amountToTransfer;
        }

    }


}
