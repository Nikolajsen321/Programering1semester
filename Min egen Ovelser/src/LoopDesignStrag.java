import java.util.Scanner;
public class LoopDesignStrag {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        /* hvor dan skriver man en kode som fx spørg 5 spørgsmål efter hinanden?


         */
        final int NUMBER_OF_QUESTIONS = 5;  // antal spørgsmål
        int corretCount = 0; // antal korekte svar
        int count = 0; // antal spørgsål

        long startTime = System.currentTimeMillis();

        String output = " ";

        while( count < NUMBER_OF_QUESTIONS){
            // lav 2 random tal
            int number1 = (int)(Math.random() * 10);
            int number2 = (int)(Math.random() * 10);

            // hvis number1 < number2 skift, number1 med number2
            if(number1 < number2 ){
                int temp = number1;
                number1 = number2;
                number2 = temp;
            }
            // få eleven til at svare på hvad number1 - number2 er
            System.out.println(" Hvad er " + number1 + " -" + number2);
            int answer = input.nextInt();
            // vudere svaret
            if(number1 - number2 == answer){
                System.out.println(" rigtigt ");
                corretCount ++;  // forøg den rigtig count
            } else
                System.out.println( " forkert svar \n" + number1 + " - " + number2 + " skullevære"+
                        (number1 - number2));
            // forøg count
            count++;
            output += "\n " + number1 + " -" + number2 + " = " + answer + ((number1 - number2)  + " =" +
            answer + ((number1 - number2 == answer) ? " correct": " wrong"));
        }
        long endTime = System.currentTimeMillis();
        long testTime = endTime - startTime;

        System.out.println(" Correct count is " + corretCount + " \nTest time is" + testTime /1000 +
                " seconds\n" + output);



    }
}
