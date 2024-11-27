package p1;


public class Loan {
	private double interestRate;
	private int Years;
	private double loanAmount;
	private java.util.Date loanDate;

/**Default constructor */

	public Loan(){
		this (7.5, 30, 100000);
	}
/** Construct a loan with specified annual interest rate,

number of years and loan amount
*/ 
	public Loan(double annualinterestRate, int numOfYears,
			double loanAmount) {
			this.interestRate = interestRate;
			this.Years = Years;
			this.loanAmount = loanAmount;
			loanDate = new java.util.Date();
	}
public double getInterestRate() {
	return interestRate;
}
public void setInterestRate(double interestRate) {
	this.interestRate = interestRate;
}
public int getYears() {
	return Years;
}
public void setYears(int years) {
	Years = years;
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
}
