package com.mark.state;

import com.mark.context.Context;
import com.mark.utils.ProcessInput;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class PrincipalState implements State {
    @Override
    public void greet() {
        System.out.println("Enter your Principal amount.");
        System.out.println("NOTE: Value must be between $10,000 and $10,000,000");
    }

    @Override
    public String getUserInput(Scanner scanner) {
        System.out.print("Principal: ");
        return scanner.nextLine();
    }

    private int stripUserInput(String userInput) throws ParseException {
        String trimmedUserInput = userInput.trim();
        // handles input written as currency, ie $20,000
        if (trimmedUserInput.contains("$")) {
            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
            Number number = format.parse(trimmedUserInput);
            return number.intValue();
        }
        // handles standard integers as well as grouped number, ie 20,000
        NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
        Number number = format.parse(trimmedUserInput);
        return number.intValue();
    }

    @Override
    public StateResult handle(Context context, Scanner scanner) {
        greet();
        String userInput = getUserInput(scanner);
        StateResult stateResult = ProcessInput.evaluateInput(userInput);

        // break flow if user exits
        if (stateResult.shouldExitState()) return stateResult;

        try {
            int output = stripUserInput(userInput);
            //TODO: add limits to the input between 10,000 and 10,000,000
            context.setPrincipal(output);
            return StateResult.CONTINUE;
        }
        catch (ParseException e) {
            System.out.println("Invalid input. Please try again.");
            System.out.println(e);
            return StateResult.REPEAT;
        }
    }

    @Override
    public String getName() {
        return "PrincipalState";
    }
}
