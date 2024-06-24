public class Main {
    public static void main(String[] args) {
        UtilityBillManager utilityBillManager = new UtilityBillManager();

        // Add some utility bills
        utilityBillManager.addUtilityBill(new UtilityBill(1, "Electric", 100.00, true));
        utilityBillManager.addUtilityBill(new UtilityBill(2, "Water", 50.00, false));
        utilityBillManager.addUtilityBill(new UtilityBill(3, "Gas", 75.00, true));

        // Get the utility bill summary
        String summary = utilityBillManager.getUtilityBillSummary();

        // Print the summary
        System.out.println(summary);
    }
}