package org.foxminded.task3.service;

import org.foxminded.task3.model.Division;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivisionServiceTest {

    private final Division division = new Division(78945, 4);
    private final DivisionService divisionService = new DivisionService(division);

    @Test
    void getResultsOfOperation_testGettingResultsOfOperation_whenValuesInput() {
        ArrayList<String> actual = divisionService.getResultsOfOperation();
        ArrayList<String> expected = new ArrayList<>(
                Arrays.asList("78945", "4", "19736", "7", "4", "38", "36",
                        " 29", " 28", "  14", "  12", "   25", "   24", "    1")
        );
        assertEquals(expected, actual);
    }

    @Test
    void getWhereNumberStarts_testGettingWhereNumberStarts_whenValuesInput() {
        ArrayList<Integer> actual = divisionService.getWhereNumberStarts();
        ArrayList<Integer> expected = new ArrayList<>(
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4)
        );
        assertEquals(expected, actual);
    }

    @Test
    void getWhereNumberEnd_testGettingWhereNumberEnd_whenValuesInput() {
        ArrayList<Integer> actual = divisionService.getWhereNumberEnd();
        ArrayList<Integer> expected = new ArrayList<>(
                Arrays.asList(4, 0, 4, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 4)
        );
        assertEquals(expected, actual);
    }

    @Test
    void getResultsOfOperation_testGettingResultsOfOperation_whenZeroAndIntegerInput() {
        Division localDivision = new Division(0, 1);
        DivisionService localDivisionService = new DivisionService(localDivision);

        ArrayList<String> actual = localDivisionService.getResultsOfOperation();
        ArrayList<String> expected = new ArrayList<>(
                Arrays.asList("0", "1", "0", "0")
        );

        assertEquals(expected, actual);
    }

    @Test
    void getWhereNumberStarts_testGettingWhereNumberStarts_whenZeroAndIntegerInput() {
        Division localDivision = new Division(0, 1);
        DivisionService localDivisionService = new DivisionService(localDivision);

        ArrayList<Integer> actual = localDivisionService.getWhereNumberStarts();
        ArrayList<Integer> expected = new ArrayList<>(
                Arrays.asList(0, 0, 0, 0)
        );
        assertEquals(expected, actual);
    }

    @Test
    void getWhereNumberEnd_testGettingWhereNumberEnd_whenZeroAndIntegerInput() {
        Division localDivision = new Division(0, 1);
        DivisionService localDivisionService = new DivisionService(localDivision);

        ArrayList<Integer> actual = localDivisionService.getWhereNumberEnd();
        ArrayList<Integer> expected = new ArrayList<>(
                Arrays.asList(0, 0, 0, 0)
        );
        assertEquals(expected, actual);
    }

    @Test
    void localDivisionService_testConstructingLocalDivisionService_whenZeroValuesInput() {
        Division localDivision = new Division(0, 0);
        Exception exception = assertThrows(ArithmeticException.class,
                () -> new DivisionService(localDivision));
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void localDivisionService_testConstructingLocalDivisionService_whenIntegerAndZeroInput() {
        Division localDivision = new Division(1, 0);
        Exception exception = assertThrows(ArithmeticException.class,
                () -> new DivisionService(localDivision));
        assertEquals("/ by zero", exception.getMessage());
    }


    @Test
    void localDivisionService_testConstructingLocalDivisionService_whenNegativeValuesInput() {
        Division localDivision = new Division(-1, -1);
        Exception exception = assertThrows(NumberFormatException.class,
                () -> new DivisionService(localDivision));
        assertEquals("For input string: \"-\"", exception.getMessage());

    }

    @Test
    void localDivisionService_testConstructingLocalDivisionService_whenNegativeIntegerAndPositiveIntegerInput() {
        Division localDivision = new Division(-1, 1);
        Exception exception = assertThrows(NumberFormatException.class,
                () -> new DivisionService(localDivision));
        assertEquals("For input string: \"-\"", exception.getMessage());
    }

    @Test
    void getResultsOfOperation_testGettingResultsOfOperation_whenPositiveIntegerAndNegativeIntegerInput() {
        Division localDivision = new Division(3, -2);
        DivisionService localDivisionService = new DivisionService(localDivision);

        ArrayList<String> actual = localDivisionService.getResultsOfOperation();
        ArrayList<String> expected = new ArrayList<>(
                Arrays.asList("3", "-2", "-1", "3", "2", "1")
        );

        assertEquals(expected, actual);
    }

    @Test
    void getWhereNumberStarts_testGettingWhereNumberStarts_whenPositiveIntegerAndNegativeIntegerInput() {
        Division localDivision = new Division(3, -2);
        DivisionService localDivisionService = new DivisionService(localDivision);

        ArrayList<Integer> actual = localDivisionService.getWhereNumberStarts();
        ArrayList<Integer> expected = new ArrayList<>(
                Arrays.asList(0, 0, 0, 0, 0, 0)
        );
        assertEquals(expected, actual);
    }

    @Test
    void getWhereNumberEnd_testGettingWhereNumberEnd_whenPositiveIntegerAndNegativeIntegerInput() {
        Division localDivision = new Division(3, -2);
        DivisionService localDivisionService = new DivisionService(localDivision);

        ArrayList<Integer> actual = localDivisionService.getWhereNumberEnd();
        ArrayList<Integer> expected = new ArrayList<>(
                Arrays.asList(0, 1, 1, 0, 0, 0)
        );
        assertEquals(expected, actual);
    }

    @Test
    void division_testConstructingDivision_whenNullAndIntegerInput() {
        assertThrows(NullPointerException.class, () -> new Division(null, 1));
    }

    @Test
    void division_testConstructingDivision_whenIntegerAndNullInput() {
        assertThrows(NullPointerException.class, () -> new Division(1, null));
    }

    @Test
    void division_testConstructingDivision_whenNullValuesInput() {
        assertThrows(NullPointerException.class, () -> new Division(null, null));
    }
}
