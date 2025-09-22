package com.mark;

import com.mark.context.Context;
import com.mark.machine.MortgageStateMachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new Scanner(System.in));
        MortgageStateMachine machine = new MortgageStateMachine();
        machine.start(context);

    }
}