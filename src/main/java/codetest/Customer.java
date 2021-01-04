package codetest;


/**
 * Class to build Customers
 */
public class Customer {
    
    String customerName;
    Double totalLoan;
    Double interest;
    Integer years;
    Double monthlyPayment;

    public Customer(String customerName,
                    Double totalLoan,
                    Double interest,
                    Integer years) {

        this.customerName = customerName;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = years;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public Double getTotalLoan() {
        return this.totalLoan;
    }

    public Double getInterest() {
        return this.interest;
    }

    public Integer getYears() {
        return this.years;
    }

    public void setMonthlyPayment(Double mp) {
        this.monthlyPayment = mp;
    }

    public Double getMonthlyPayment() {
        return this.monthlyPayment;
    }
}
