package org.foxminded.task3.output;

import org.foxminded.task3.model.Division;
import org.foxminded.task3.service.DivisionService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterTest {
    private final Division division = new Division(78945, 4);
    private final DivisionService divisionService = new DivisionService(division);

    @Test
    void printResults_testPrintResults_whenValuesInput() {
        String actual = new Printer().printResults(divisionService.getResultsOfOperation(),
                divisionService.getWhereNumberStarts(),
                divisionService.getWhereNumberEnd());
        String expected = "_78945 |4\n 4     |-----\n -     |19" +
                "736\n_38\n 36\n --\n _29\n  28\n  --\n  _14\n   12\n   --\n   _2" +
                "5\n    24\n    --\n     1\n";

        assertEquals(expected, actual);
    }

}


