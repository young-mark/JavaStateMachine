package com.mark;

import com.mark.context.Context;
import com.mark.machine.MortgageStateMachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new Scanner(System.in));
        MortgageStateMachine machine = new MortgageStateMachine();
        machine.start(context);

//        while(principal == null) {
//            System.out.print("Principal: ");
//            String userPrincipal = scanner.next();
//
//            try {
//                principal = Integer.parseInt(userPrincipal);
//                if(principal <= 0) {
//                    System.out.println("Please enter a positive whole number.");
//                    principal = null;
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input. Please enter a valid integer.");
//            }
//        }
//        System.out.println("You entered " + principal);
//
//        while(rate == null) {
//            System.out.print("Annual Interest Rate: ");
//            String userRate = scanner.next();
//
//            try {
//                rate = Float.parseFloat(userRate);
//                if(rate < 0) {
//                    System.out.println("Please enter a positive number");
//                    rate = null;
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input. Please enter a valid decimal number.");
//            }
//        }
//        System.out.println("You entered " + rate);
//
//        while(period == null) {
//            System.out.print("Period (Years): ");
//            String userPeriod = scanner.next();
//
//            try {
//                period = Byte.parseByte(userPeriod);
//                if(period <= 0) {
//                    System.out.println("Please enter a valid year.");
//                    period = null;
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input. Please enter a valid year.");
//            }
//        }
//        System.out.println("You entered " + period);
//
//        double monthlyRate = (double)(rate / PERCENT) / MONTHS_IN_YEAR;
//        int numberOfPayments = period * MONTHS_IN_YEAR;
//
//        double rateFactor = Math.pow((1 + monthlyRate), numberOfPayments);
//        double numerator = monthlyRate * rateFactor;
//        System.out.println("numerator " + numerator);
//
//        double denominator = rateFactor - 1;
//        System.out.println("denominator " + denominator);
//
//
//        double mortgage = principal * (numerator / denominator);
//        System.out.println("mortgage: " + mortgage);
//
//        String formattedMortgage = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
//
//        System.out.println("Formatted output: " + formattedMortgage);

    }
}