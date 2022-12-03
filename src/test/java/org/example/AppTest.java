package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class AppTest {

    private final VariableKeeper variableKeeper = new VariableKeeper(78945, 4);
    private final DividingNumberService dividingNumberService = new DividingNumberService(variableKeeper);

    @Test
    void firstTest() {
        ArrayList<String> allResults = dividingNumberService.getResultsOfOperation();
        ArrayList<String> expectedResults = new ArrayList<>(
                Arrays.asList("78945", "4", "19736", "7", "4", "38", "36",
                        " 29", " 28", "  14", "  12", "   25", "   24", "    1")
        );
        assertEquals(expectedResults, allResults);
    }

    @Test
    public void secondTest() {
        ArrayList<Integer> whereNumberStarts = dividingNumberService.getWhereNumberStarts();
        ArrayList<Integer> expectedWhereNumberStarts = new ArrayList<>(
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4)
        );
        assertEquals(expectedWhereNumberStarts, whereNumberStarts);
    }

    @Test
    public void thirdTest() {
        ArrayList<Integer> whereNumberEnd = dividingNumberService.getWhereNumberEnd();
        ArrayList<Integer> expectedWhereNumberEnd = new ArrayList<>(
                Arrays.asList(4, 0, 4, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 4)
        );
        assertEquals(expectedWhereNumberEnd, whereNumberEnd);
    }

}
