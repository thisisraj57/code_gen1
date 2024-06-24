public class UtilityBillManagement {

    // Data Model
    private List<UtilityBill> bills;
    private List<UtilityPayment> payments;

    // Constructor
    public UtilityBillManagement(List<UtilityBill> bills, List<UtilityPayment> payments) {
        this.bills = bills;
        this.payments = payments;
    }

    // Methods
    public void viewSummary() {
        // Display a summary of all utility bills and payments, including amounts and due dates.

        System.out.println("------------------------------------------");
        System.out.println("Utility Bill Summary");
        System.out.println("------------------------------------------");

        System.out.println("Upcoming Bills:");
        for (UtilityBill bill : bills) {
            if (!bill.isPaid()) {
                System.out.println("-" + bill.getDescription() + " - Amount: $" + bill.getAmount() + " - Due Date: " + bill.getDueDate());
            }
        }

        System.out.println("------------------------------------------");

        System.out.println("Recent Payments:");
        for (UtilityPayment payment : payments) {
            System.out.println("-" + payment.getDescription() + " - Amount: $" + payment.getAmount() + " - Date: " + payment.getDate());
        }
    }

    public void viewDetail(int billId) {
        // Display detailed information on individual utility transactions.

        UtilityBill bill = getBillById(billId);

        System.out.println("------------------------------------------");
        System.out.println("Utility Bill Detail");
        System.out.println("------------------------------------------");

        System.out.println("Description: " + bill.getDescription());
        System.out.println("Amount: $" + bill.getAmount());
        System.out.println("Due Date: " + bill.getDueDate());

        System.out.println("------------------------------------------");

        System.out.println("Payments:");
        for (UtilityPayment payment : payments) {
            if (payment.getBillId() == billId) {
                System.out.println("-" + payment.getDescription() + " - Amount: $" + payment.getAmount() + " - Date: " + payment.getDate());
            }
        }
    }

    private UtilityBill getBillById(int billId) {
        // Helper method to get a bill by its ID.

        for (UtilityBill bill : bills) {
            if (bill.getId() == billId) {
                return bill;
            }
        }

        return null;
    }
}