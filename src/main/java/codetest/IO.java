package codetest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Class to handle the inputfile
 */
public class IO {

    private List<Customer> customerList;

    /**
     * Retrieve data from txt file
     */
    public void retrieveInput() {

        customerList = new ArrayList<>();

        String customerName;
        Double totalLoan;
        Double interest;
        Integer years;

        try {
            FileReader reader = new FileReader("prospects.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            // grab the content of the file
            while ((line = bufferedReader.readLine()) != null) {          

                // don't treat everything
                if(!line.contains("Customer,Total loan,Interest,Years")
                    && !line.isEmpty() && !line.startsWith(".")) {

                   String[] arrOfStr = line.split(",", 5); // max 5 parts

                    customerName = arrOfStr[0].replace('"', ' ').strip(); // cleaning string some
                    try {
                        totalLoan = Double.parseDouble(arrOfStr[1]);
                        interest = Double.parseDouble(arrOfStr[2]);
                        years = Integer.parseInt(arrOfStr[3]);
                    } catch(NumberFormatException ne) { // if two names entered
                        customerName = customerName + " " + arrOfStr[1].replace('"', ' ').strip();
                        totalLoan = Double.parseDouble(arrOfStr[2]);
                        interest = Double.parseDouble(arrOfStr[3]);
                        years = Integer.parseInt(arrOfStr[4]);
                    }

                    // create Customers of the input
                    Customer customer = new Customer(customerName, totalLoan, interest, years);

                    // save the customers in a list
                    customerList.add(customer);

                }
            }
            reader.close();
 
            // tell about exception
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Output the result
     */
    public void outputResult() {

        // Model:
        // Prospect 1: CustomerName wants to borrow X € for a period of Z years and pay E € each month

        for(Customer customer:customerList) {

            // outputting to terminal (spec. just said print)
            System.out.printf(
                "%s wants to borrow %.2f € for a period of %d years and pay %.2f € each month\n", 
                customer.getCustomerName(), customer.getTotalLoan(), 
                customer.getYears(), customer.getMonthlyPayment());
        }

    }

    /**
     * Getter for the customer list
     * @return
     */
    public List<Customer> getCustomerList() {
        return customerList;
    }
    
}
