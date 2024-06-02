//Manaog, Christian Joshua C>
//BSCS-DS 1st YEAR
// 03/06/2024

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manaog_Christian_MidtermReq {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
    //input must only be in numerical value
    // error handling is implemented
        try {
            System.out.print("Enter a binary number: ");
            BigInteger binaryNumber = scanner.nextBigInteger();
            BigInteger decimalNumber = conversionMethod(binaryNumber);
            System.out.print("Conversion(Decimal): " + decimalNumber);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
    
    //method to convert binary to decimal
    //proper naming of method and variables
    public static BigInteger conversionMethod(BigInteger binaryNumber) {
        //default value will be 0
        BigInteger numDecimal = BigInteger.ZERO; 

        //default value will be 1
        BigInteger numPosition = BigInteger.ONE;

        //creates a loop that will check the binary number until it becomes 0
        while (binaryNumber.compareTo(BigInteger.ZERO) > 0 ) {

            //gets the last digit (rightmost)
            BigInteger rightMost = binaryNumber.remainder(BigInteger.TEN);

            //adds the value of the last digit (0 or 1) multiplied by its position to the decimal
            numDecimal = numDecimal.add(rightMost.multiply(numPosition));

            //increments the position 
            numPosition = numPosition.multiply(BigInteger.TWO);

            //removes the last digit from binary number by shifting one digit to the right
            binaryNumber = binaryNumber.divide(BigInteger.TEN);
        }
        return numDecimal;
    }
}
