package org.example;

public class App {
    public static void main(String[] args) {
        VariableKeeper variableKeeper = new VariableKeeper(78945, 4);

        DividingNumberService dividingNumberService = new DividingNumberService(variableKeeper);

        Printer printer = new Printer();
        printer.printResults(dividingNumberService.getResultsOfOperation(),
                dividingNumberService.getWhereNumberStarts(),
                dividingNumberService.getWhereNumberEnd());
    }
}
