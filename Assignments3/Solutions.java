package Assignment3;

import java.util.Arrays;

public class Book {
    int size;
    int price;
    String name;

    public Book(int size) {
        this.size = size;
    }

    public Book(int size, int price, String name) {
        super();
        this.size = size;
        this.price = price;
        this.name = name;
    }

    public Book(int price) {
        //we cannot have both Book constructor with one same type parameter
        //taking in, it should either be int size or int prize
        //or else the compiler might get confused
        this.price = price;
    }

    public void setName(String name) {
        //there should be a type declaration in the method declaration sentence
        //should not be "return name", that belongs to
        //a getter method
        return = name;
    }
}


//2.

class Clock {
    String time;
    //since time is a String, the method should return a String, not void
    void getTime() {
        return time;
    }

    void setTime(String t) {
        time = t;
    }
}



    class Solution{

        public static void main(String[] args) {
            Solution s= new Solution();
            //s.removeVowelsFromString("aerRUPILKIAAAa");
            s.checkIfTwoStringsAreAnagram("asa a", " aaa   s");
        }
    //3. remove vowels in a string
    public String removeVowelsFromString(String input) {
        if (input == null) {
            return null;
        }

        if (input.length() == 0) {
            return "";
        }

        int index = 0;
        char[] chars = input.toCharArray();

        for (int i = 0; i < input.length(); i++) {
            if (chars[i] != 'a' &&
                    chars[i] != 'e' &&
                    chars[i] != 'i' &&
                    chars[i] != 'o' &&
                    chars[i] != 'u' &&
                    chars[i] != 'A' &&
                    chars[i] != 'E' &&
                    chars[i] != 'I' &&
                    chars[i] != 'O' &&
                    chars[i] != 'U') {
                chars[index++] = chars[i];
            }
        }

        char[] resultChars = new char[index];
        for (int i = 0; i < index; i++) {
            resultChars[i] = chars[i];
        }
        String result = new String(resultChars);
        System.out.println(result);
        return result;
    }

    //4.

        public boolean checkIfTwoStringsAreAnagram(String s1, String s2) {
            boolean isAnagram = false;
            if (s1 == null && s2 == null) {
                isAnagram = true;
                System.out.println(isAnagram);
                return isAnagram;
            }
            if (s1 == null || s2 == null) {
                System.out.println(isAnagram);
                return isAnagram;
            }
            String new_s1 = s1.replaceAll(" ", "");
            String new_s2 = s2.replaceAll(" ", "");

            if (new_s1.length() == new_s2.length()) {
                char[] s1AsChar = new_s1.toCharArray();
                char[] s2AsChar = new_s2.toCharArray();
                Arrays.sort(s1AsChar);
                Arrays.sort(s2AsChar);
                isAnagram = Arrays.equals(s1AsChar, s2AsChar);
            }
            System.out.println(isAnagram);
            return isAnagram;
        }

}
class Calculator {
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double substract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if(num2 != 0) {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("invalid input");
        }
    }

    public double squareRoot(double num) {
        return Math.sqrt(num);
    }

    public double square(double num) {
        return Math.pow(num, 2);
    }

    public double cube(double num) {
        return Math.pow(num, 3);
    }

    public double fahrenheitToCelsius(double num) {
        return (num - 32) / 1.8;
    }

    public double celsiusToFahrenheit(double num) {
        return num * 1.8 + 32;
    }

    public double feetToInch(double num) {
        return num / 12;
    }

    public double inchToFeet(double num) {
        return num * 12;
    }

    public double[] solveQuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            double[] res = new double[1];
            res[0] = -c / b;
            return res;
        }
        double delta = b * b - 4 * a * c;
        if ( delta >= 0) {
            double[] res = new double[2];
            res[0] = (-b + Math.sqrt(delta)) / (2 * a);
            res[1] = (-b - Math.sqrt(delta)) / (2 * a);
            return res;
        } else {
            return null;
        }
    }
}

