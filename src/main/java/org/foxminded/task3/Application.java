package org.foxminded.task3;

import output.Printer;
import model.Division;
import service.DivisionService;

public class Application {
    public static void main(String[] args) {
        Division division = new Division(99999999, 3);

        DivisionService divisionService = new DivisionService(division);

        Printer printer = new Printer();
        String result = printer.printResults(divisionService.getResultsOfOperation(),
                divisionService.getWhereNumberStarts(),
                divisionService.getWhereNumberEnd());
        System.out.println(result);
    }
}
