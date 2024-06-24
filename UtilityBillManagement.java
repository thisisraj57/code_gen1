public class UtilityBillManagement {

    private List<Bill> bills;
    private List<Payment> payments;

    public UtilityBillManagement(List<Bill> bills, List<Payment> payments) {
        this.bills = bills;
        this.payments = payments;
    }

    public Map<String, Double> getBillSummary() {
        Map<String, Double> summary = new HashMap<>();
        for (Bill bill : bills) {
            summary.put(bill.getUtilityType(), bill.getAmount());
        }
        return summary;
    }

    public Map<String, Double> getPaymentSummary() {
        Map<String, Double> summary = new HashMap<>();
        for (Payment payment : payments) {
            summary.put(payment.getUtilityType(), payment.getAmount());
        }
        return summary;
    }

    public static void main(String[] args) {
        List<Bill> bills = new ArrayList<>();
        bills.add(new Bill("Electricity", 100.0));
        bills.add(new Bill("Water", 50.0));
        bills.add(new Bill("Gas", 75.0));

        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment("Electricity", 100.0));
        payments.add(new Payment("Water", 50.0));

        UtilityBillManagement utilityBillManagement = new UtilityBillManagement(bills, payments);

        Map<String, Double> billSummary = utilityBillManagement.getBillSummary();
        System.out.println("Bill Summary:");
        for (Map.Entry<String, Double> entry : billSummary.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }

        Map<String, Double> paymentSummary = utilityBillManagement.getPaymentSummary();
        System.out.println("Payment Summary:");
        for (Map.Entry<String, Double> entry : paymentSummary.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }
}