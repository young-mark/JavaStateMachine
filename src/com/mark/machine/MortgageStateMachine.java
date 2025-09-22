package com.mark.machine;

import com.mark.context.Context;
import com.mark.state.*;

import java.util.List;
import java.util.NoSuchElementException;

public class MortgageStateMachine {
    private final List<State> states = List.of(
            new PrincipalState(),
            new InterestRateState(),
            new PaymentTermsState(),
            new CalculateState()
    );

    private String currentState = null;

    public MortgageStateMachine() {
        printStartingMessage();
        setStartingState();
    }

    void setStartingState() {
        currentState = states.getFirst().getName();
    }

    void printStartingMessage() {
        System.out.println("");
        System.out.println("===================================");
        System.out.println("Welcome to the Mortgage Calculator.");
        System.out.println("===================================");
    }

    int findIndexByName(List<State> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        throw new NoSuchElementException("State with name " + name + " doesn't exist.");
    }

    private void changeState(StateResult result, Context context) {
        Integer stateIndex = null;
        switch (result) {
            case CONTINUE:
                // go to next state
                stateIndex = findIndexByName(states, currentState);
                currentState = states.get(stateIndex + 1).getName();
                start(context);
                break;
            case BACK:
                // go to previous state
                stateIndex = findIndexByName(states, currentState);
                if(stateIndex > 0) {
                    currentState = states.get(stateIndex - 1).getName();
                } else {
                    currentState = states.get(stateIndex).getName();
                }
                start(context);
                break;
            case EXIT:
                // terminate program (user)
                System.out.println("Terminating program...");
                System.exit(1);
                break;
            case REPEAT:
                // restart from current state
                start(context);
                break;
            case END:
                // end program (successful run)
                System.out.println("Thank you for using Mortgage Caclulator!");
                break;
            case RESTART:
                // restart program from beginning
                System.out.println("Fatal error. Restarting program...");
                printStartingMessage();
                setStartingState();
                break;
            default:
               // throw error, this shouldn't occur
               throw new NoSuchElementException("State with name " + result + " doesn't exist.");

        }
    }

    public void start(Context context) {
        System.out.println("");
        changeState(states
                .get(findIndexByName(states, currentState))
                .handle(context, context.getScanner()), context);
    }

}
