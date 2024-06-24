public class UtilityBillManager {
    private List<UtilityBill> utilityBills;

    // Constructor
    public UtilityBillManager() {
        this.utilityBills = new ArrayList<>();
    }

    // Method to add a new utility bill
    public void addUtilityBill(UtilityBill utilityBill) {
        this.utilityBills.add(utilityBill);
    }

    // Method to get all utility bills
    public List<UtilityBill> getUtilityBills() {
        return this.utilityBills;
    }

    // Method to get a summary of utility bills
    public String getUtilityBillSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Summary of Utility Bills:\n");
        for (UtilityBill bill : this.utilityBills) {
            summary.append(String.format("%s: $%.2f", bill.getBillType(), bill.getBillAmount()));
            if (bill.isPaid()) {
                summary.append(" (Paid)\n");
            } else {
                summary.append(" (Unpaid)\n");
            }
        }
        return summary.toString();
    }
}