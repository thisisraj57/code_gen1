class represents a single transaction related to a utility bill
public class Transaction {
    private String transactionType;  // Type of transaction, e.g. payment, adjustment
    private double amount;  // Amount of the transaction
    private String transactionDate;  // Date of the transaction

    // Constructor for creating a transaction
    public Transaction(String transactionType, double amount, String transactionDate) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    // Getters for transaction type, amount, and transaction date
    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }
}