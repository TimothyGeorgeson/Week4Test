package com.example.consultants.week4test.part2;

public class PigLatin {

    public static void main(String[] args) {

        System.out.println(convert("chicken soup"));

    }

    private static String convert(String input) {
        String[] splitStr = input.split(" ");
        String result = "";

        for (int i = 0; i < splitStr.length; i++) {
            result += convertToPigLatin(splitStr[i]);
        }

        return result;
    }

    private static String convertToPigLatin(String input) {
        StringBuilder firstPart = new StringBuilder();
        StringBuilder secondPart = new StringBuilder();
        int index = -1;

        for (int i = 0; i < input.length(); i++) {

            if (isVowel(input.charAt(i)) && index == -1) {
                secondPart.append(input.charAt(i));
                index = i;
            } else if (index == -1) {
                firstPart.append(input.charAt(i));
            } else {
                secondPart.append(input.charAt(i));
            }
        }
        return secondPart.append(firstPart).append("ay ").toString();
    }

    private static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
