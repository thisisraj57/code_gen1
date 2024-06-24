class Payment implements Transaction {
    private String paymentId;
    private String utilityName;
    private double amount;
    private Date paymentDate;

    public Payment(String paymentId, String utilityName, double amount, Date paymentDate) {
        this.paymentId = paymentId;
        this.utilityName = utilityName;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
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
        return paymentDate;
    }

    @Override
    public void setDate(Date date) {
        this.paymentDate = date;
    }
}