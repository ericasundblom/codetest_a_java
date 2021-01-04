package codetest;

import java.util.List;


/**
 * Class for calculating the montly payment
 */
public class Calculate {
    
    // Given these instructions

    // E = Fixed monthly payment
    // b = Interest on a monthly basis
    // U = Total loan
    // p = Number of payments

    // E = U[b(1 + b)^p]/[(1 + b)^p - 1];

    // Usage of java.math or similar math dependencies are not allowed

    /**
     * Method to calculate the monthly payment
     * @param customerList
     */
    public void calculateMonthlyPayment(List<Customer> customerList) {
        
        for(Customer customer:customerList) {

            Double b = (customer.getInterest()/100)/12; // convert percent and change interest to monthly
            Double U = customer.getTotalLoan();
            Integer p = customer.getYears()*12; // paying monthly so years * 12
               
            // handle power of manually first
            double uped = 1+b;
            for(int n=2; n<=p; n++) {
                uped = uped * (1+b);
            }
            // do the rest of the calculation
            Double E = U*(b*uped)/(uped-1);
    
            customer.setMonthlyPayment(E);
        }
    }
}

