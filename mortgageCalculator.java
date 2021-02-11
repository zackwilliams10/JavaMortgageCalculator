import java.text.NumberFormat;
import java.util.Scanner;

public class mortgageCalculator {
    public static void main(String[] args){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0; //variable must be outside of while loop
        float monthlyInterest = 0;  //variable must be outside of while loop
        int numberOfPayments = 0;   //variable must be outside of while loop

        Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.print("Principal loan amount: ");
        principal = scanner.nextInt();
        if (principal >= 5000 && principal <= 1_000_000)
            break;
        System.out.println("Please enter a valid dollar value between 5000 and 1000000");
    }
    while (true) {
        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        if (annualInterest >= 1 && annualInterest <= 30) {
            monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
            break;
        }
        System.out.println("Please enter a valid value between 1 and 30");
    }
    while (true) {
        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        if (years >= 1 && years <= 30) {
            numberOfPayments = years *MONTHS_IN_YEAR;
            break;
        }
        System.out.println("Please enter a value between 1 and 30");
    }
        double mortgage = principal
                    * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Your approx monthly Mortgage payment would be: " + mortgageFormatted + " , not including taxes or insurance charges");
    }
}