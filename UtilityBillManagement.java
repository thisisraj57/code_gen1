public class UtilityBillManagement {

    private List<UtilityBill> utilityBills;
    private List<Payment> payments;

    public UtilityBillManagement(List<UtilityBill> utilityBills, List<Payment> payments) {
        this.utilityBills = utilityBills;
        this.payments = payments;
    }

    public Summary getSummary() {
        Summary summary = new Summary();
        for (UtilityBill utilityBill : utilityBills) {
            summary.addUtilityBill(utilityBill);
        }
        for (Payment payment : payments) {
            summary.addPayment(payment);
        }
        return summary;
    }

    public static class Summary {
        private double totalBillAmount;
        private double totalPaidAmount;
        private double outstandingAmount;

        public void addUtilityBill(UtilityBill utilityBill) {
            totalBillAmount += utilityBill.getAmount();
        }

        public void addPayment(Payment payment) {
            totalPaidAmount += payment.getAmount();
        }

        public double getTotalBillAmount() {
            return totalBillAmount;
        }

        public double getTotalPaidAmount() {
            return totalPaidAmount;
        }

        public double getOutstandingAmount() {
            return totalBillAmount - totalPaidAmount;
        }
    }

    public static class UtilityBill {
        private String id;
        private String type;
        private double amount;

        public UtilityBill(String id, String type, double amount) {
            this.id = id;
            this.type = type;
            this.amount = amount;
        }

        public String getId() {
            return id;
        }

        public String getType() {
            return type;
        }

        public double getAmount() {
            return amount;
        }
    }

    public static class Payment {
        private String id;
        private double amount;

        public Payment(String id, double amount) {
            this.id = id;
            this.amount = amount;
        }

        public String getId() {
            return id;
        }

        public double getAmount() {
            return amount;
        }
    }
}