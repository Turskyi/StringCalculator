package io.github.turskyi;

public class Main {
    public static void main(String[] args) {
        final int result = StringCalculator.add ("//$,@\n1$2@3");
        System.out.println ("Result: " + result); // Output: Result: 6
    }
}