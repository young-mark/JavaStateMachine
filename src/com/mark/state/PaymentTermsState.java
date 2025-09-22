package com.mark.state;

import com.mark.context.Context;
import com.mark.utils.ProcessInput;

import java.util.Scanner;

public class PaymentTermsState implements State {
    @Override
    public void greet() {
        System.out.println("How long is your loan term?");
        System.out.println("Please enter in years. (1 - 50)");
    }

    @Override
    public String getUserInput(Scanner scanner) {
        System.out.print("Number of years: ");
        return scanner.nextLine();
    }

    @Override
    public StateResult handle(Context context, Scanner scanner) {
        greet();
        String userInput = getUserInput(scanner);
        StateResult stateResult = ProcessInput.evaluateInput(userInput);

        //break flow if user exists
        if (stateResult.shouldExitState()) return stateResult;

        try {
            byte output = Byte.parseByte(userInput);
            //TODO: restrict the input between 1 and 50
            context.setPaymentTerms(output);
            return StateResult.CONTINUE;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
            return StateResult.REPEAT;
        }
    }

    @Override
    public String getName() {
        return "PaymentTermsState";
    }
}
