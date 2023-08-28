import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Opgave3 {
    public static void main(String[] args) {
        Customer c1 = new Customer("Bentsen","Anders",80);
        Customer c2 = new Customer("Børgsen","Bent",39);
        Customer c3 = new Customer("Mogensen","Chris",90);
        Customer c4 = new Customer("Hansen","Ditte",90);
        Customer c5 = new Customer("Hansen","Mikkel",40);
        Customer c6 = new Customer("Bang","Niels",28);
        Customer c7 = new Customer("Larsen","Ole",40);
        Customer c8 = new Customer("Martinsen","Peter",30);
        //laver arraylist der indeholder kunder til en forretning
        // og et array hvor der indehoder kunder som er dårlige betaler
        ArrayList<Customer> listOfCustomer = new ArrayList<>(List.of(c1,c2,c3,c4,c5,c6,c7,c8));
        Customer[] arrayOfBadPayers = {c2,c3,c4};
//        Collections.sort(listOfCustomer);
//        Arrays.sort(arrayOfBadPayers);

        System.out.println(generelFletning(listOfCustomer,arrayOfBadPayers));

    }


    public static ArrayList generelFletning(ArrayList<Customer> listOfCustomer,Customer[] arrayOfBadPayers){
        int i1 = 0;
        int i2 = 0;
        ArrayList<Customer> result = new ArrayList<>(listOfCustomer);

        while(i1 < listOfCustomer.size() && i2 < arrayOfBadPayers.length) {
            if (listOfCustomer.get(i1).getFirstName().compareTo(arrayOfBadPayers[i2].getFirstName()) != 0) {
                i1++;
            } else {
                result.remove(i1);
                i2++;
                i1++;
            }
        }
        return result;
    }
}
