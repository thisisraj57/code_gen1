class Summary {
    private double totalBillAmount;
    private double totalPaymentAmount;

    public Summary(double totalBillAmount, double totalPaymentAmount) {
        this.totalBillAmount = totalBillAmount;
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public double getTotalBillAmount() {
        return totalBillAmount;
    }

    public void setTotalBillAmount(double totalBillAmount) {
        this.totalBillAmount = totalBillAmount;
    }

    public double getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(double totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }
}