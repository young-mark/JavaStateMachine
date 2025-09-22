package com.mark.state;

import com.mark.context.Context;
import java.util.Scanner;

public interface State {
    void greet();
    String getUserInput(Scanner scanner);
    StateResult handle(Context context, Scanner scanner);
    // TODO: consider adding validation method
    String getName();
}