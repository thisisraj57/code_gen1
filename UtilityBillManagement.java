public class UtilityBillManagement {

    private List<UtilityBill> bills;
    private List<UtilityPayment> payments;

    public UtilityBillManagement(List<UtilityBill> bills, List<UtilityPayment> payments) {
        this.bills = bills;
        this.payments = payments;
    }

    public UtilityBillSummary getSummary() {
        double totalBillAmount = 0;
        double totalPaymentAmount = 0;

        for (UtilityBill bill : bills) {
            totalBillAmount += bill.getAmount();
        }

        for (UtilityPayment payment : payments) {
            totalPaymentAmount += payment.getAmount();
        }

        return new UtilityBillSummary(totalBillAmount, totalPaymentAmount);
    }

    public class UtilityBillSummary {

        private double totalBillAmount;
        private double totalPaymentAmount;

        public UtilityBillSummary(double totalBillAmount, double totalPaymentAmount) {
            this.totalBillAmount = totalBillAmount;
            this.totalPaymentAmount = totalPaymentAmount;
        }

        public double getTotalBillAmount() {
            return totalBillAmount;
        }

        public double getTotalPaymentAmount() {
            return totalPaymentAmount;
        }
    }

    public class UtilityBill {

        private String billId;
        private String utilityType;
        private String billingPeriod;
        private double amount;

        public UtilityBill(String billId, String utilityType, String billingPeriod, double amount) {
            this.billId = billId;
            this.utilityType = utilityType;
            this.billingPeriod = billingPeriod;
            this.amount = amount;
        }

        public String getBillId() {
            return billId;
        }

        public String getUtilityType() {
            return utilityType;
        }

        public String getBillingPeriod() {
            return billingPeriod;
        }

        public double getAmount() {
            return amount;
        }
    }

    public class UtilityPayment {

        private String paymentId;
        private String billId;
        private String paymentDate;
        private double amount;

        public UtilityPayment(String paymentId, String billId, String paymentDate, double amount) {
            this.paymentId = paymentId;
            this.billId = billId;
            this.paymentDate = paymentDate;
            this.amount = amount;
        }

        public String getPaymentId() {
            return paymentId;
        }

        public String getBillId() {
            return billId;
        }

        public String getPaymentDate() {
            return paymentDate;
        }

        public double getAmount() {
            return amount;
        }
    }
}