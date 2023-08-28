import java.util.Scanner;

public class NewChildApp {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println(" indtast alder ");
        int alder = input.nextInt();

        String insti = institution(alder);
        System.out.println(insti);


    }

    public static String institution(int age) {
        String result = "";
        if (age == 0) {

            String skole = " Home ";
            result = skole;

        } else if (age < 0 && age <= 2) {
            String skole = " nursery ";
            result = skole;
        } else if (age < 2 && age <= 5) {

            String skole = " kindergarden ";
            result = skole;
        } else if (age >= 6 && age <= 16) {
            String skole = " i skole  ";
            result = skole;

        } else if (age >= 17) {
            String skole = " ude af skole ";
            result = skole;
        }
        return result;
    }
}
