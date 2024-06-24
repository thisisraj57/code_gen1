class Bill implements Transaction {
    private String billId;
    private String utilityName;
    private double amount;
    private Date dueDate;

    public Bill(String billId, String utilityName, double amount, Date dueDate) {
        this.billId = billId;
        this.utilityName = utilityName;
        this.amount = amount;
        this.dueDate = dueDate;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getUtilityName() {
        return utilityName;
    }

    public void setUtilityName(String utilityName) {
        this.utilityName = utilityName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public Date getDate() {
        return dueDate;
    }

    @Override
    public void setDate(Date date) {
        this.dueDate = date;
    }
}