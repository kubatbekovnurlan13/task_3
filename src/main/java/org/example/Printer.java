package org.example;

import java.util.ArrayList;

public class Printer {
    public void print(int dividend, int divider) {

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

        printResults(resultsOfOperation);
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

    private ArrayList<Integer> deteremineWhereNumberStarts(ArrayList<String> allResults) {
        ArrayList<Integer> indicesOfNumbersWhereItStarts = new ArrayList<>();

        for (String result : allResults) {
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

    private ArrayList<Integer> deteremineWhereNumberEnd(ArrayList<String> allResults) {
        ArrayList<Integer> indicesOfNumbersWhereItEnd = new ArrayList<>();

        for (String result : allResults) {
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

    private void printResults(ArrayList<String> allResults) {

        ArrayList<Integer> indicesOfNumbersWhereItStarts = deteremineWhereNumberStarts(allResults);
        ArrayList<Integer> indicesOfNumbersWhereItEnd = deteremineWhereNumberEnd(allResults);

        for (int counter = 0; counter < allResults.size(); counter++) {
            if (counter == 0) {
                System.out.println("_" + allResults.get(counter) + " |" + allResults.get(1));
            } else if (counter == 4) {
                int blanksLenght = allResults.get(0).length() - allResults.get(4).length();
                String blanks = " ".repeat(blanksLenght);
                System.out.println(" " + allResults.get(counter) + blanks + " |-----");

                int lenghtOfBlanksForDash = indicesOfNumbersWhereItStarts.get(4);
                String blanksForDash = lenghtOfBlanksForDash == 0 ? "" : " ".repeat(lenghtOfBlanksForDash);

                int lenghtOfDash = indicesOfNumbersWhereItEnd.get(4) - indicesOfNumbersWhereItStarts.get(4) + 1;
                String dashes = lenghtOfDash == 0 ? "-" : "-".repeat(lenghtOfDash);

                System.out.println(" " + blanksForDash + dashes + blanks + " |" + allResults.get(2));
            } else if (counter == allResults.size() - 1) {
                String number = allResults.get(counter);
                int integerDigit = Integer.parseInt(number.trim());
                String blanks = " ".repeat(indicesOfNumbersWhereItStarts.get(counter));

                System.out.println(blanks + " " + integerDigit);

            } else if (counter > 4 && counter % 2 != 0) {
                String number = allResults.get(counter);
                int integerDigit = Integer.parseInt(number.trim());
                String blanks = " ".repeat(indicesOfNumbersWhereItStarts.get(counter));

                System.out.println(blanks + "_" + integerDigit);
            } else if (counter > 4) {
                String number = allResults.get(counter);
                int integerDigit = Integer.parseInt(number.trim());
                String blanks = " ".repeat(indicesOfNumbersWhereItStarts.get(counter));
                String blanksForDashes = " ".repeat(indicesOfNumbersWhereItStarts.get(counter - 1));

                int lenghtOfDashes = indicesOfNumbersWhereItEnd.get(counter) - indicesOfNumbersWhereItStarts.get(counter) + 1;
                String dashes = lenghtOfDashes == 0 ? "-" : "-".repeat(lenghtOfDashes);

                System.out.println(" " + blanks + integerDigit);
                System.out.println(" " + blanksForDashes + dashes);
            }
        }
    }

}
