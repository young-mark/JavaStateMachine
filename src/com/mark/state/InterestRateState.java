package com.mark.state;

import com.mark.context.Context;
import com.mark.utils.ProcessInput;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class InterestRateState implements State {
    @Override
    public void greet() {
        System.out.println("Enter your Annual Interest Rate.");
        System.out.println("NOTE: Value must be between 0% and 50%.");
    }

    @Override
    public String getUserInput(Scanner scanner) {
        System.out.print("Interest rate: ");
        return scanner.nextLine();
    }

    private float stripUserInput(String userInput) throws ParseException {
        NumberFormat format = NumberFormat.getPercentInstance(Locale.US);
        Number number = format.parse(userInput);
        return number.floatValue();
    }

    @Override
    public StateResult handle(Context context, Scanner scanner) {
        greet();
        String userInput = getUserInput(scanner);
        StateResult stateResult = ProcessInput.evaluateInput(userInput);

        // break flow if user exits
        if (stateResult.shouldExitState()) return stateResult;

        try {
            float output = stripUserInput(userInput);
            //TODO: add limits to the input between 0% and 50%
            context.setInterestRate(output);
            return StateResult.CONTINUE;
        }
        catch (ParseException e) {
            System.out.println("Invalid input. Please try again.");
            return StateResult.REPEAT;
        }
    }

    @Override
    public String getName() {
        return "InterestRateState";
    }
}
