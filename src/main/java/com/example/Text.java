package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    public static void main(String[] args) {
        String text = "Once upon a time a Wolf was lapping at a spring on a hillside, when," +
                " looking up, what should he see but a Lamb just" +
                " beginning to drink a little lower down.";

        textProcessingAndOutputAllWordsAlphabeticallyConsole(text);
    }

    public static void textProcessingAndOutputAllWordsAlphabeticallyConsole(String text) {
        StringBuilder sb = new StringBuilder(text);
        String[] words = getArrayOfWordsFromText(sb);
        String[][] wordsAndNumber = getArrayOfNonRepeatingWordsAndNumber(words);

        displayWordsWithCertainLetter(wordsAndNumber);
    }

    public static String[] getArrayOfWordsFromText(StringBuilder sb) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(sb);
        String[] words = new String[getNumberWordsInText(sb)];
        int count = 0;

        while (matcher.find()) {
            words[count] = sb.substring(matcher.start(), matcher.end()).toLowerCase();
            count++;
        }

        return words;
    }

    public static int getNumberWordsInText(StringBuilder sb) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(sb);
        int count = 0;

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public static String[][] getArrayOfNonRepeatingWordsAndNumber(String[] words) {
        String[][] wordsAndNumber = new String[words.length][2];
        int numberMatches = 0;
        int index = 0;

        for (String word : words) {
            for (String[] strings : wordsAndNumber) {
                if (word.equals(strings[0])) {
                    numberMatches++;
                }
            }

            if (numberMatches == 0) {
                wordsAndNumber[index][0] = word;
                wordsAndNumber[index][1] = "" + getNumberOccurrencesWordInArray(words, word);
                index++;
            }

            numberMatches = 0;
        }

        return wordsAndNumber;
    }

    public static int getNumberOccurrencesWordInArray(String[] words, String word) {
        int count = 0;

        for (String s : words) {
            if (s.equals(word)) {
                count++;
            }
        }

        return count;
    }

    public static void displayWordsWithCertainLetter(String[][] wordsAndNumber) {
        char lowerCase = 'a';
        char upperCase = 'A';
        char firstSymbol;
        int count = 0;

        for (int i = 0; i < 26; i++) {
            System.out.print(upperCase + ": ");
            for (String[] strings : wordsAndNumber) {
                if (strings[0] != null) {
                    firstSymbol = strings[0].charAt(0);
                    if (lowerCase == firstSymbol) {
                        System.out.println(strings[0] + " " + strings[1]);
                        count++;
                    }
                }
            }
            if (count == 0) {
                System.out.println();
            } else {
                count = 0;
            }

            lowerCase = (char) (lowerCase + 1);
            upperCase = (char) (upperCase + 1);
        }
    }
}
