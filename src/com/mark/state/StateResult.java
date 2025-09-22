package com.mark.state;

public enum StateResult {
    CONTINUE,
    BACK,
    EXIT,
    REPEAT,
    END,
    RESTART;

    public boolean shouldExitState() {
        return this == EXIT || this == BACK;
    }
}
