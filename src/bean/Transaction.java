package bean;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private int accountNumber;
    private List<Double> deposits;
    private List<Double> withdrawals;
    private int transactionid;

    public Transaction(int accountNumber,int transactionid,List<Double> deposits,List<Double>withdrawls) {
        this.accountNumber = accountNumber;
        this.transactionid=transactionid;
        this.deposits = new ArrayList<>();
        this.withdrawals = new ArrayList<>();
    }

    // Methods to add deposit and withdrawal
    public void addDeposit(double amount) {
        this.deposits.add(amount);
    }

    public void addWithdrawal(double amount) {
        this.withdrawals.add(amount);
    }

    // Method to calculate balance
    public double calculateBalance() {
        double totalDeposit = 0.0;
        for (double deposit : deposits) {
            totalDeposit += deposit;
        }

        double totalWithdrawal = 0.0;
        for (double withdrawal : withdrawals) {
            totalWithdrawal += withdrawal;
        }

        return totalDeposit - totalWithdrawal;
    }

    // Getters and setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<Double> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Double> deposits) {
        this.deposits = deposits;
    }

    public List<Double> getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(List<Double> withdrawals) {
        this.withdrawals = withdrawals;
    }

    @Override
    public String toString() {
        return "Transaction [accountNumber=" + accountNumber + ", deposits=" + deposits + ", withdrawals=" + withdrawals + ", balance=" + calculateBalance() + "]";
    }
}
