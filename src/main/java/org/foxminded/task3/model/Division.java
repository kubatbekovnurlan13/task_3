package org.foxminded.task3.model;

public class Division {
    private final int dividend;
    private final int divider;

    public Division(Integer dividend, Integer divider) {
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
