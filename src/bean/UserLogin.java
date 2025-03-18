package bean;

import java.util.List;

public class UserLogin {
    private int accountNumber;
    private String username;
    private String password;
    private double balance;

    public UserLogin(int accountNumber, String username, String password, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.password = password;
        this.balance = 0.0;
    }

    // Getters and setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void updateBalanceFromTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            if (transaction.getAccountNumber() == this.accountNumber) {
                this.balance = transaction.calculateBalance(); 
            }
        }
    }

    @Override
    public String toString() {
        return "UserLogin [accountNumber=" + accountNumber + ", username=" + username + ", password=" + password + ", balance=" + balance + "]";
    }
}

