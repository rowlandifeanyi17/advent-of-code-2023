package adventOfCode2023;

import java.util.ArrayList;
import java.util.List;

public class DayOne {
    int firstIndex = -1;
    int lastIndex = -1;
    int wordFirstIndex = 10000000;
    int wordLastIndex = -1;
    String firstDigit = "";
    String lastDigit = "";
    int wordFistDigit = 0;
    int wordLastDigit = 0;
    List<String> numbers = getNumbers();

    public void partOne() {
        System.out.println("Day One Part 1 & 2:");
        ReadFiles getLines = new ReadFiles();
        List<String> lines = getLines.getFiles("src/adventOfCode2023/inputFiles/dayOnePartOne.txt");
        getDigit(lines);
    }

    private void getDigit(List<String> lines) {
        int sum = 0;

        for (String line : lines) {
            getDigitsPartOne(line);
            getDigitsPartTwo(line);

            sum += getFinalDigit();
            resetDigit();
        }

        System.out.println("Sum = " + sum);
    }

    private void getDigitsPartOne(String line) {
        int diff = 48;
        int compare = 0;
        boolean isFirst = false;
        boolean foundInt = false;

        for (int i = 0; i < line.length(); i++) {
            char digit = line.charAt(i);
            int ascii = (int) digit;

            compare = ascii - diff;
            if ((compare > -1) && (compare < 10)) {
                if (!isFirst) {
                    firstDigit = String.valueOf(digit);
                    firstIndex = i;
                    isFirst = true;
                }
                lastDigit = String.valueOf(digit);
                lastIndex = i;
                foundInt = true;
            }
        }
    }

    private void getDigitsPartTwo(String line){
        for (int i = 1; i < 10; i++) {
            String number = numbers.get(i-1);
            int newWordFirstIndex = line.indexOf(number);

            if (newWordFirstIndex != -1) {
                if (newWordFirstIndex < wordFirstIndex) {
                    wordFirstIndex = newWordFirstIndex;
                    wordFistDigit = i;
                }
            }

            int newWordLastIndex = line.lastIndexOf(number);
            if (newWordLastIndex != -1) {
                if (newWordLastIndex > wordLastIndex) {
                    wordLastIndex = newWordLastIndex;
                    wordLastDigit = i;
                }
            }
        }
    }

    private int getFinalDigit() {

        int finalFirstDigit = 0;
        int finalLastDigit = 0;

        // Compare firstDigits
        if ((firstIndex == -1)) {
            finalFirstDigit = wordFistDigit;
        } else if ((wordFirstIndex == -1)) {
            finalFirstDigit = Integer.parseInt(firstDigit);
        } else if (firstIndex < wordFirstIndex) {
            finalFirstDigit = Integer.parseInt(firstDigit);
        } else {
            finalFirstDigit = wordFistDigit;
        }

        // compare lastDigit
        if ((lastIndex == -1)) {
            finalLastDigit = wordLastDigit;
        } else if ((wordLastIndex == -1)) {
            finalLastDigit = Integer.parseInt(lastDigit);
        } else if (lastIndex > wordLastIndex) {
            finalLastDigit = Integer.parseInt(lastDigit);
        } else {
            finalLastDigit = wordLastDigit;
        }

        return Integer.parseInt(String.valueOf(finalFirstDigit) + String.valueOf(finalLastDigit));
    }

    List<String> getNumbers() {
        List<String> numbers = new ArrayList<>();
        numbers.add("one");
        numbers.add("two");
        numbers.add("three");
        numbers.add("four");
        numbers.add("five");
        numbers.add("six");
        numbers.add("seven");
        numbers.add("eight");
        numbers.add("nine");
        return numbers;
    }

    private void resetDigit() {
        firstIndex = -1;
        lastIndex = -1;
        firstDigit = "";
        lastDigit = "";

        wordFirstIndex = 10000000;
        wordLastIndex = -1;
        wordFistDigit = 0;
        wordLastDigit = 0;
    }
}
