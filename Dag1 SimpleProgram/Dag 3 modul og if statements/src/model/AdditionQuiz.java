package model;

import java.util.Scanner;

public class AdditionQuiz {
  public static void main(String[] args) {
    // det vil sige molous af tiden i ms fra 1971 til nu og tager molus af 10 til tallet får den sidste digit
    int number1 = (int)(System.currentTimeMillis() % 10);
    int number2 = (int)(System.currentTimeMillis() * 7 % 10);
    int number3 = (int)(System.currentTimeMillis() * 5 % 10);

    // Create a Scanner
    Scanner input = new Scanner(System.in);

    System.out.print(
      "What is " + number1 + " * " + number2 + " *" + number3 + "? ");

    int answer = input.nextInt();

    System.out.println(
      number1 + " * " + number2 + " * " + number3 + " = " + answer + " is " +
      (number1 * number2 * number3 == answer));

    System.out.println(" og System.currentTimeMills er den nuværende tid" + " " + System.currentTimeMillis() +
            " som er tiden fra 01-01-1971 til nu i enhenden ms ");

  }
}
