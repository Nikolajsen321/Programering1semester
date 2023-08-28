import java.util.Scanner;

public class KeyVarUdenNote {
    public static void main(String[] args){
        //Create a Scanner
        Scanner input = new Scanner (System.in);

        //(read double)
        double radius = input.nextDouble();

        // (Compute = udregning) af areal A = r^2 * pi
        double area = radius * radius * 3.14159;
        //Display result
        System.out.println("The area for the cirle of radius " +
                radius + " is "+ area);
    }
}
