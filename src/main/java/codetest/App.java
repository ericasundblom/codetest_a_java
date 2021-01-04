package codetest;


/**
 * Class containing main method
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Doing my codetest in java!");

        IO myIO = new IO();
        Calculate myCalculator = new Calculate();
        myIO.retrieveInput();
        myCalculator.calculateMonthlyPayment(myIO.getCustomerList());
        myIO.outputResult();
    }
}
