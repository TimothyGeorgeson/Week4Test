package com.example.consultants.week4test.part2;

public class PigLatin {

    public static void main(String[] args) {

        convert("chicken soup");

    }

    private static String convert(String input)
    {
        String[] splitStr = input.split(" ");
        String result = "";

        for (int i = 0; i < splitStr.length; i++) {
            result += convertToPigLatin(splitStr[i]);
        }

        System.out.println(result);

        return "";
    }

    private static String convertToPigLatin(String input)
    {
        StringBuilder firstPart = new StringBuilder();
        StringBuilder secondPart = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int index = -1;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ')
            {
                if (!(firstPart.toString().equals("") && (secondPart.toString().equals(""))))
                {
                    return result.append(secondPart).append(firstPart).append("ay").toString();
                }
            } else{
                if (isVowel(input.charAt(i)) && index == -1) {
                    secondPart.append(input.charAt(i));
                    index = i;
                } else if(index == -1){
                    firstPart.append(input.charAt(i));
                } else {
                    secondPart.append(input.charAt(i));
                }
            }

        }
        return "";
    }

    private static boolean isVowel(char c)
    {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        {
            return true;
        }
        return false;
    }
}
