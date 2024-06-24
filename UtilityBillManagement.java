public class UtilityBillManagement {

    public static void main(String[] args) {
        // Create a list of utility bills
        List<UtilityBill> utilityBills = List.of(
                new UtilityBill("Electricity", 100.0, "2023-03-15"),
                new UtilityBill("Gas", 50.0, "2023-04-15"),
                new UtilityBill("Water", 25.0, "2023-05-15")
        );

        // Create a list of utility payments
        List<UtilityPayment> utilityPayments = List.of(
                new UtilityPayment("Electricity", 100.0, "2023-03-15"),
                new UtilityPayment("Gas", 50.0, "2023-04-15")
        );

        // Display a summary of all utility bills and payments
        System.out.println("Utility Bill Summary");
        System.out.println("--------------------");
        for (UtilityBill bill : utilityBills) {
            System.out.println(bill);
        }
        for (UtilityPayment payment : utilityPayments) {
            System.out.println(payment);
        }

        // Display detailed information on individual utility transactions
        System.out.println("Detailed Transaction Information");
        System.out.println("----------------------------");
        for (UtilityTransaction transaction : utilityBills) {
            System.out.println(transaction);
        }
        for (UtilityTransaction transaction : utilityPayments) {
            System.out.println(transaction);
        }
    }

    public static class UtilityBill implements UtilityTransaction {

        private String type;
        private double amount;
        private String dueDate;

        public UtilityBill(String type, double amount, String dueDate) {
            this.type = type;
            this.amount = amount;
            this.dueDate = dueDate;
        }

        @Override
        public String getType() {
            return type;
        }

        @Override
        public double getAmount() {
            return amount;
        }

        @Override
        public String getDueDate() {
            return dueDate;
        }

        @Override
        public String toString() {
            return "UtilityBill{" +
                    "type='" + type + '\'' +
                    ", amount=" + amount +
                    ", dueDate='" + dueDate + '\'' +
                    '}';
        }
    }

    public static class UtilityPayment implements UtilityTransaction {

        private String type;
        private double amount;
        private String date;

        public UtilityPayment(String type, double amount, String date) {
            this.type = type;
            this.amount = amount;
            this.date = date;
        }

        @Override
        public String getType() {
            return type;
        }

        @Override
        public double getAmount() {
            return amount;
        }

        @Override
        public String getDueDate() {
            return null;
        }

        @Override
        public String toString() {
            return "UtilityPayment{" +
                    "type='" + type + '\'' +
                    ", amount=" + amount +
                    ", date='" + date + '\'' +
                    '}';
        }
    }

    public interface UtilityTransaction {

        String getType();

        double getAmount();

        String getDueDate();
    }
}