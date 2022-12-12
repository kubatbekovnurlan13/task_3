package org.foxminded.task3;

import org.foxminded.task3.output.Printer;
import org.foxminded.task3.model.Division;
import org.foxminded.task3.service.DivisionService;

public class Application {
    public static void main(String[] args) {
        Division division = new Division(1000156, 523);

        DivisionService divisionService = new DivisionService(division);

        Printer printer = new Printer();
        String result = printer.printResults(divisionService.getResultsOfOperation(),
                divisionService.getWhereNumberStarts(),
                divisionService.getWhereNumberEnd());

        System.out.println(result);
    }
}
