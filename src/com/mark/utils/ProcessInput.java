package com.mark.utils;

import com.mark.state.StateResult;

public class ProcessInput {
    public static StateResult evaluateInput(String userInput) {
        switch (userInput.trim().toUpperCase()) {
            case "BACK":
                return StateResult.BACK;
            case "EXIT":
                return StateResult.EXIT;
            default:
                return StateResult.CONTINUE;
        }
    }
}