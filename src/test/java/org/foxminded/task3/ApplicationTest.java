package org.foxminded.task3;

import model.Division;
import org.junit.jupiter.api.Test;
import output.Printer;
import service.DivisionService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ApplicationTest {

    private final Division division = new Division(78945, 4);
    private final DivisionService divisionService = new DivisionService(division);
    private final String result = new Printer().printResults(divisionService.getResultsOfOperation(),
            divisionService.getWhereNumberStarts(),
            divisionService.getWhereNumberEnd());

    @Test
    void firstTest() {
        ArrayList<String> allResults = divisionService.getResultsOfOperation();
        ArrayList<String> expectedResults = new ArrayList<>(
                Arrays.asList("78945", "4", "19736", "7", "4", "38", "36",
                        " 29", " 28", "  14", "  12", "   25", "   24", "    1")
        );
        assertEquals(expectedResults, allResults);
    }

    @Test
    public void secondTest() {
        ArrayList<Integer> whereNumberStarts = divisionService.getWhereNumberStarts();
        ArrayList<Integer> expectedWhereNumberStarts = new ArrayList<>(
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4)
        );
        assertEquals(expectedWhereNumberStarts, whereNumberStarts);
    }

    @Test
    public void thirdTest() {
        ArrayList<Integer> whereNumberEnd = divisionService.getWhereNumberEnd();
        ArrayList<Integer> expectedWhereNumberEnd = new ArrayList<>(
                Arrays.asList(4, 0, 4, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 4)
        );
        assertEquals(expectedWhereNumberEnd, whereNumberEnd);
    }

    @Test
    public void fourthTest() {
        String result = this.result;
        String expectedResult = "_78945 |4\n 4     |-----\n -     |19" +
                "736\n_38\n 36\n --\n _29\n  28\n  --\n  _14\n   12\n   --\n   _2" +
                "5\n    24\n    --\n     1\n";

        assertEquals(expectedResult, result);
    }

}
