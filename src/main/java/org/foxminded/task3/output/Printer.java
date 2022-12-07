package org.foxminded.task3.output;

import java.util.ArrayList;

public class Printer {

    public String printResults(ArrayList<String> allResults,
                               ArrayList<Integer> indicesOfNumbersWhereItStarts,
                               ArrayList<Integer> indicesOfNumbersWhereItEnd) {
        StringBuilder result = new StringBuilder();

        for (int counter = 0; counter < allResults.size(); counter++) {
            if (counter == 0) {
                result.append("_").append(allResults.get(counter)).append(" |").append(allResults.get(1)).append("\n");
            } else if (counter == 4) {
                int blanksLenght = allResults.get(0).length() - allResults.get(4).length();
                String blanks = " ".repeat(blanksLenght);
                result.append(" ").append(allResults.get(counter)).append(blanks).append(" |-----").append("\n");

                int lenghtOfBlanksForDash = indicesOfNumbersWhereItStarts.get(4);
                String blanksForDash = lenghtOfBlanksForDash == 0 ? "" : " ".repeat(lenghtOfBlanksForDash);

                int lenghtOfDash = indicesOfNumbersWhereItEnd.get(4) - indicesOfNumbersWhereItStarts.get(4) + 1;
                String dashes = lenghtOfDash == 0 ? "-" : "-".repeat(lenghtOfDash);

                result.append(" ").append(blanksForDash).append(dashes).append(blanks).append(" |").append(allResults.get(2)).append("\n");
            } else if (counter == allResults.size() - 1) {
                String numberString = allResults.get(counter);

                String number = numberString.trim() == "" ? "0" : numberString;
                int integerDigit = Integer.parseInt(number.trim());
                int lengthOfBlank = indicesOfNumbersWhereItStarts.get(counter) == -1 ? 0 : indicesOfNumbersWhereItStarts.get(counter);

                String blanks = " ".repeat(lengthOfBlank);

                result.append(blanks).append(" ").append(integerDigit).append("\n");
            } else if (counter > 4 && counter % 2 != 0) {
                String number = allResults.get(counter);
                int integerDigit = Integer.parseInt(number.trim());
                String blanks = " ".repeat(indicesOfNumbersWhereItStarts.get(counter));

                result.append(blanks).append("_").append(integerDigit).append("\n");
            } else if (counter > 4) {
                String number = allResults.get(counter);
                int integerDigit = Integer.parseInt(number.trim());
                String blanks = " ".repeat(indicesOfNumbersWhereItStarts.get(counter));
                String blanksForDashes = " ".repeat(indicesOfNumbersWhereItStarts.get(counter - 1));

                int lenghtOfDashes = indicesOfNumbersWhereItEnd.get(counter) - indicesOfNumbersWhereItStarts.get(counter) + 1;
                String dashes = lenghtOfDashes == 0 ? "-" : "-".repeat(lenghtOfDashes);

                result.append(" ").append(blanks).append(integerDigit).append("\n");
                result.append(" ").append(blanksForDashes).append(dashes).append("\n");
            }
        }
        return result.toString();
    }
}
