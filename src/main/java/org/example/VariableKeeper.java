package org.example;

public class VariableKeeper {
    private int dividend;
    private int divider;

    public VariableKeeper(int dividend, int divider) {
        this.dividend = dividend;
        this.divider = divider;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivider() {
        return divider;
    }

}
