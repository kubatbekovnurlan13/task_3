package org.foxminded.task3.output;

import org.foxminded.task3.model.Division;
import org.foxminded.task3.service.DivisionService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterTest {
    @Test
    void printResults_testPrintResults_whenSomeValuesInput() {
        Division division = new Division(78945, 4);
        DivisionService divisionService = new DivisionService(division);

        String actual = new Printer().printResults(divisionService.getResultsOfOperation(),
                divisionService.getWhereNumberStarts(),
                divisionService.getWhereNumberEnd());
        String expected = "_78945 |4\n 4     |-----\n -     |19" +
                "736\n_38\n 36\n --\n _29\n  28\n  --\n  _14\n   12\n   --\n   _2" +
                "5\n    24\n    --\n     1\n";

        assertEquals(expected, actual);
    }

    @Test
    void printResults_testPrintResults_whenAnotherValuesInput() {
        Division division = new Division(1000156, 523);
        DivisionService divisionService = new DivisionService(division);

        String actual = new Printer().printResults(divisionService.getResultsOfOperation(),
                divisionService.getWhereNumberStarts(),
                divisionService.getWhereNumberEnd());
        String expected = "_1000156 |523\n  523    |-----\n  ---    |1912\n" +
                " _4771\n  4707\n  ----\n   _645\n    523\n    ---\n   _1226\n    1046\n    ----\n     180\n";

        assertEquals(expected, actual);
    }

}


