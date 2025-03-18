package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import utility.DBUtil;

public class TransactionIMPL implements TransactionDao {
    @Override
    public String transactiondetails(int accountNumber, int transactionid, List<Double> deposits, List<Double> withdrawals) {
        String msg = "Transaction not done...";

        double totalDeposit = deposits.stream().mapToDouble(Double::doubleValue).sum();
        double totalWithdrawal = withdrawals.stream().mapToDouble(Double::doubleValue).sum();
        double balance = totalDeposit - totalWithdrawal; // Calculate the balance

        try (Connection conn = DBUtil.provideConnection()) {
            String query = "INSERT INTO transactions (accountNumber, transactionId, totalDeposit, totalWithdrawal, balance) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, accountNumber);
                ps.setInt(2, transactionid);
                ps.setDouble(3, totalDeposit); // Use the calculated total deposit
                ps.setDouble(4, totalWithdrawal); // Use the calculated total withdrawal
                ps.setDouble(5, balance); // Use the calculated balance

                int n = ps.executeUpdate();
                if (n > 0) {
                    msg = "Transaction recorded successfully.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            msg = e.getMessage();
        }

        return msg;
    }
}
