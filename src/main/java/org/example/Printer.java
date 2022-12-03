package org.example;

import java.util.ArrayList;

public class Printer {

    public void printResults(ArrayList<String> allResults,
                             ArrayList<Integer> indicesOfNumbersWhereItStarts,
                             ArrayList<Integer> indicesOfNumbersWhereItEnd) {

//        ArrayList<Integer> indicesOfNumbersWhereItStarts = deteremineWhereNumberStarts(allResults);
//        ArrayList<Integer> indicesOfNumbersWhereItEnd = deteremineWhereNumberEnd(allResults);

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
