class UtilityBillManagement {

    // Data structures to store utility bills and payments
    private Map<String, List<Bill>> bills;
    private Map<String, List<Payment>> payments;

    // Constructor to initialize the system
    public UtilityBillManagement() {
        this.bills = new HashMap<>();
        this.payments = new HashMap<>();
    }

    // Method to add a new bill
    public void addBill(String utilityName, Bill bill) {
        if (bills.containsKey(utilityName)) {
            bills.get(utilityName).add(bill);
        } else {
            bills.put(utilityName, List.of(bill));
        }
    }

    // Method to add a new payment
    public void addPayment(String utilityName, Payment payment) {
        if (payments.containsKey(utilityName)) {
            payments.get(utilityName).add(payment);
        } else {
            payments.put(utilityName, List.of(payment));
        }
    }

    // Method to get a summary of all bills and payments
    public Map<String, Summary> getSummary() {
        Map<String, Summary> summary = new HashMap<>();
        for (Map.Entry<String, List<Bill>> entry : bills.entrySet()) {
            String utilityName = entry.getKey();
            List<Bill> utilityBills = entry.getValue();

            double totalBillAmount = 0;
            double totalPaymentAmount = 0;
            for (Bill bill : utilityBills) {
                totalBillAmount += bill.getAmount();
            }

            List<Payment> utilityPayments = payments.getOrDefault(utilityName, Collections.emptyList());
            for (Payment payment : utilityPayments) {
                totalPaymentAmount += payment.getAmount();
            }

            Summary utilitySummary = new Summary(totalBillAmount, totalPaymentAmount);
            summary.put(utilityName, utilitySummary);
        }
        return summary;
    }

    // Method to get detailed information on individual utility transactions
    public List<Transaction> getTransactions(String utilityName) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.addAll(bills.getOrDefault(utilityName, Collections.emptyList()));
        transactions.addAll(payments.getOrDefault(utilityName, Collections.emptyList()));
        Collections.sort(transactions, Comparator.comparing(Transaction::getDate));
        return transactions;
    }

}