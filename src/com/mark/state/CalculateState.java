package com.mark.state;

import com.mark.context.Context;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CalculateState implements State {
    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;

    @Override
    public void greet() {
        System.out.print("Calculating payments...\uD83E\uDD14");
    }

    @Override
    public String getUserInput(Scanner scanner) {
        throw new UnsupportedOperationException("Class " + getName() + " does not accept User Input.");
    }

    @Override
    public StateResult handle(Context context, Scanner scanner) {
        greet();
        try {
            Integer principal = context.getPrincipal();
            Float interestRate = context.getInterestRate();
            Byte paymentTerms = context.getPaymentTerms();
            System.out.println("principal: " + principal);
            System.out.println("interestRate: " + interestRate);
            System.out.println("paymentTerms: " + paymentTerms);

//            double monthlyRate = (double)(interestRate / PERCENT) / MONTHS_IN_YEAR;
            double monthlyRate = (double)interestRate / MONTHS_IN_YEAR;
            int totalNumberOfPayments = paymentTerms * MONTHS_IN_YEAR;

            double rateFactor = Math.pow((1 + monthlyRate), totalNumberOfPayments);
            double numerator = monthlyRate * rateFactor;
            double denominator = rateFactor - 1;
            double monthlyPayment = principal * (numerator / denominator);

            String formattedMonthlyPayment = NumberFormat.getCurrencyInstance(Locale.US).format(monthlyPayment);
            System.out.println("Your mortgage payment:");
            System.out.println(formattedMonthlyPayment);

            return StateResult.END;
        } catch (NumberFormatException e) {
            System.out.println("UNHANDLED EXCEPTION");
            System.out.println(e);
            return StateResult.RESTART;
        }

    }

    @Override
    public String getName() {
        return "CalculateState";
    }
}
