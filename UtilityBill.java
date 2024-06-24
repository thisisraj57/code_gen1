public class UtilityBill {
    private int billId;
    private String billType;
    private double billAmount;
    private boolean isPaid;

    // Constructor
    public UtilityBill(int billId, String billType, double billAmount, boolean isPaid) {
        this.billId = billId;
        this.billType = billType;
        this.billAmount = billAmount;
        this.isPaid = isPaid;
    }

    // Getters and setters
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}