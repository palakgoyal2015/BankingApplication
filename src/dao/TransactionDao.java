package dao;

import java.util.List;

public interface TransactionDao {
    String transactiondetails(int accountNumber, int transactionId, List<Double> deposits, List<Double> withdrawals);
}
