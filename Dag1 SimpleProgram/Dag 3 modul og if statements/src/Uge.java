import java.util.Scanner;
public class Uge {
    public static void main(String[] args) {

        System.out.println(" skriv fra 0 - 6 hvor 0 er mandag  frem til 6 som er søndag, skriv et tal +" +
                " og det vil fortælle hvor mange dage frem hvad dag det er ");
        Scanner input = new Scanner(System.in);

        int week = input.nextInt();
        int dag = input.nextInt();

        String indtast = weekday(week, dag);

        System.out.println( indtast );


    }

    public static String weekday(int weekly, int day) {
        String result = " ";

        if (weekly == 0) {

            if (day == 0) {
                result = " Monday";
            } else if (day == 1) {
                result = " Today is Monday and 1 day from monday is tuesday";
            } else if (day == 2) {
                result = " Today is Monday and 2 day from monday is onsdag";
            } else if (day == 3) {
                result = " Today is Monday and 3 day from monday is thuesday";
            } else if (day == 3) {
                result = " Today is Monday and 4 day from monday is friday";
            } else if (day == 4) {
                result = " Today is Monday and 4 day from monday is saturday";
            } else if (day == 5) {
                result = " Today is Monday and 4 day from monday is suntag";
            } else if (day == 6) {
                result = " Today is Monday and 4 day from monday is friday";
            }
        } else if (weekly == 1) {
            if (day == 1) {
                result = "tirsdag";
            } else if (day == 1) {
                    result = " Today is monday and 1 day from monday is tirsdag";
                } else if (day == 2) {
                    result = " Today is Monday and 2 day from monday is onsdag";
                } else if (day == 3) {
                    result = " Today is Monday and 3 day from monday is thuesday";
                } else if (day == 3) {
                    result = " Today is Monday and 4 day from monday is friday";
                } else if (day == 4) {
                    result = " Today is Monday and 4 day from monday is saturday";
                } else if (day == 5) {
                    result = " Today is Monday and 4 day from monday is suntag";
                } else if (day == 6) {
                    result = " Today is Monday and 4 day from monday is friday";
                }
            }
        return result;

    }
}