package p1;

public class Loan {
	private double interestRate;
	private int numOfYears;
	private double loanAmount;
	private java.util.Date loanDate;
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getNumOfYears() {
		return numOfYears;
	}
	public void setNumOfYears(int numOfYears) {
		this.numOfYears = numOfYears;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public java.util.Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(java.util.Date loanDate) {
		this.loanDate = loanDate;
	}
	public Loan(double interestRate, int numOfYears, double loanAmount) {
		super();
		this.interestRate = interestRate;
		this.numOfYears = numOfYears;
		this.loanAmount = loanAmount;
	}
	
	

}
