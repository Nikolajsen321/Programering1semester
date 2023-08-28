import java.util.Scanner;
public class LoopCondition {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println(" vælg en integer og systemet stopper hvis den er 0");

        int data = input.nextInt();


        int sum = 0;
        while(data != 0) {
            sum += data;

            System.out.println(" vælg en integer og systemet stopper hvis den er 0");
            data = input.nextInt();
        }
        System.out.println(" summen er " + sum);



    }
}
