package org.example;

import java.util.ArrayList;

public class DividingNumberService {
    private final ArrayList<String> resultsOfOperation;
    private final ArrayList<Integer> whereNumberStarts;
    private final ArrayList<Integer> whereNumberEnd;

    public DividingNumberService(VariableKeeper variableKeeper) {
        this.resultsOfOperation = resultsOfOperation(variableKeeper.getDividend(), variableKeeper.getDivider());
        this.whereNumberStarts = deteremineWhereNumberStarts(this.resultsOfOperation);
        this.whereNumberEnd = deteremineWhereNumberEnd(this.resultsOfOperation);

    }

    public ArrayList<String> getResultsOfOperation() {
        return resultsOfOperation;
    }

    public ArrayList<Integer> getWhereNumberStarts() {
        return whereNumberStarts;
    }

    public ArrayList<Integer> getWhereNumberEnd() {
        return whereNumberEnd;
    }

    private ArrayList<String> resultsOfOperation(int dividend, int divider) {

        int[] separateIntegersOfDividend = makeFromDividendToSeparateIntegerArray(dividend);

        ArrayList<String> resultsOfOperation = new ArrayList<>();
        resultsOfOperation.add(String.valueOf(dividend));
        resultsOfOperation.add(String.valueOf(divider));
        resultsOfOperation.add(String.valueOf(dividend / divider));


        for (int indexOfColumnInSeparateIntegers = 0; indexOfColumnInSeparateIntegers < separateIntegersOfDividend.length; indexOfColumnInSeparateIntegers++) {

            int integerForSubtract = makeIntegerForSubtract(separateIntegersOfDividend, indexOfColumnInSeparateIntegers);

            if (integerForSubtract > divider) {

                StringBuilder stringForSubtract = new StringBuilder(String.valueOf(integerForSubtract));
                int lengthOfIntegerThatGoesForSubtract = String.valueOf(integerForSubtract).length();

                int amountOfColumnInDigit = indexOfColumnInSeparateIntegers + 1;

                int lengthOfBlanksOfDividend = amountOfColumnInDigit - lengthOfIntegerThatGoesForSubtract;

                for (int counterOfBlanks = 0; lengthOfBlanksOfDividend > counterOfBlanks; counterOfBlanks++) {
                    stringForSubtract.insert(0, " ");
                }

                resultsOfOperation.add(stringForSubtract.toString());

                int lesserIntegerForSubtract = integerForSubtract / divider * divider;
                int integerResultOfSubtraction = integerForSubtract - lesserIntegerForSubtract;

                StringBuilder lesserStringForSubtract = new StringBuilder(String.valueOf(lesserIntegerForSubtract));
                int lengthOfBlanksOfDivider = stringForSubtract.toString().length() - lesserStringForSubtract.length();

                for (int counterOfBlanks = 0; lengthOfBlanksOfDivider > counterOfBlanks; counterOfBlanks++) {
                    lesserStringForSubtract.insert(0, " ");
                }

                resultsOfOperation.add(lesserStringForSubtract.toString());

                String stringResultOfSubtraction = integerResultOfSubtraction + " ".trim();

                for (int y = indexOfColumnInSeparateIntegers; y >= 0; y--) {
                    if (integerResultOfSubtraction == 0) {
                        separateIntegersOfDividend[y] = 0;
                    }
                    if (integerResultOfSubtraction != 0) {
                        int lengthOfStringResultOfSubtraction = stringResultOfSubtraction.length();
                        for (int j = indexOfColumnInSeparateIntegers; j >= 0; j--) {
                            if (lengthOfStringResultOfSubtraction > 0) {
                                separateIntegersOfDividend[j] = Integer.parseInt(stringResultOfSubtraction.substring(lengthOfStringResultOfSubtraction - 1, lengthOfStringResultOfSubtraction));
                            } else {
                                separateIntegersOfDividend[j] = 0;
                            }
                            lengthOfStringResultOfSubtraction--;
                        }
                    }
                }
            }
        }

        StringBuilder lastNumber = new StringBuilder();
        for (int each : separateIntegersOfDividend) {
            if (each == 0)
                lastNumber.append(" ");
            else lastNumber.append(each);
        }
        resultsOfOperation.add(lastNumber.toString());
        return resultsOfOperation;

//        printResults(resultsOfOperation);
    }

    private ArrayList<Integer> deteremineWhereNumberStarts(ArrayList<String> resultsOfOperation) {
        ArrayList<Integer> indicesOfNumbersWhereItStarts = new ArrayList<>();

        for (String result : resultsOfOperation) {
            boolean determineIndex = false;
            for (int i = 0; result.length() > i; i++) {
                if (!result.substring(i, i + 1).isBlank() && !determineIndex) {
                    indicesOfNumbersWhereItStarts.add(i);
                    determineIndex = true;
                }
            }
            if (!determineIndex) {
                indicesOfNumbersWhereItStarts.add(-1);
            }
        }

        return indicesOfNumbersWhereItStarts;
    }

    private ArrayList<Integer> deteremineWhereNumberEnd(ArrayList<String> resultsOfOperation) {
        ArrayList<Integer> indicesOfNumbersWhereItEnd = new ArrayList<>();

        for (String result : resultsOfOperation) {
            boolean determineIndex = false;
            for (int i = result.length() - 1; 0 <= i; i--) {
                if (!result.substring(i).isBlank() && !determineIndex) {
                    indicesOfNumbersWhereItEnd.add(i);
                    determineIndex = true;
                }
            }
            if (!determineIndex) {
                indicesOfNumbersWhereItEnd.add(-1);
            }
        }

        return indicesOfNumbersWhereItEnd;
    }

    private int[] makeFromDividendToSeparateIntegerArray(int dividend) {
        String[] dividentArrString = (dividend + " ").trim().split("");
        int[] dividentArrInt = new int[dividentArrString.length];

        for (int i = 0; i < dividentArrString.length; i++) {
            dividentArrInt[i] = Integer.parseInt(dividentArrString[i]);
        }

        return dividentArrInt;
    }

    private int makeIntegerForSubtract(int[] separateIntegersOfDividend, int i) {

        StringBuilder stringValueForSubtract = new StringBuilder();
        for (int j = 0; j <= i; j++) {
            stringValueForSubtract.append(separateIntegersOfDividend[j]);
        }

        return Integer.parseInt(stringValueForSubtract.toString().trim());
    }

}
