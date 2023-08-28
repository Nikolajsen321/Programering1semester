import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Opgave1 {
    public static void main(String[] args) {
        Customer c1 = new Customer("Bentsen","Anders",80);
        Customer c2 = new Customer("Børgsen","Bent",39);
        Customer c3 = new Customer("Mogensen","Chris",90);
        Customer c4 = new Customer("Hansen","Ditte",90);
        Customer c5 = new Customer("Hansen","Mikkel",40);
        Customer c6 = new Customer("Bang","Niels",28);
        Customer c7 = new Customer("Larsen","Ole",40);
        Customer c8 = new Customer("Martinsen","Peter",30);



        ArrayList<Customer> l1 = new ArrayList<>(List.of(c1,c2,c3,c4,c5,c6,c7,c8));
        Collections.sort(l1);

        Customer c9 = new Customer("Benjamin","Benjamin",24);
        Customer c10 = new Customer("Jonas","Jonas",24);
        Customer c11 = new Customer("ADSSA","Mads",20);

        ArrayList<Customer> l2 = new ArrayList<>(List.of(c9,c10,c11));
        Collections.sort(l2);


        System.out.println(fletAlleCustomer(l1,l2));






    }

    public static ArrayList fletAlleCustomer(ArrayList<Customer> l1, ArrayList<Customer> l2){
        int i1 = 0;
        int i2 = 0;

        ArrayList<Customer> result = new ArrayList<>();

        //While looped fleter så længe der er noget i en af de to lister l1 og l2

        while(i1 < l1.size() && i2 < l2.size()){
            if(l1.get(i1).getFirstName().compareTo(l2.get(i2).getFirstName()) <=0){
                result.add(l1.get(i1));
                i1++;
                //Så længe at l1.fornavn compared med l2 forvan er mindre end eller lig = 0
                // så adder den til l1.get(i1) og det man ved begge er soteret vil man hurtig
                // finde ud af hvilken af de to der først bliver tømt
            }else {
                result.add(l2.get(i2));
                i2++;
                //ellers hvis l1.forvan er større end l2.forvan begynder man tag for l2. listen i stedet for
            }
        }
        // while kigger på hvor man er på listen er man kommet ud af den så skal man kigge på den man mangler
        while (i1 < l1.size()){
            result.add(l1.get(i1));
            i1++;
        }

        while (i2 < l2.size()){
            result.add(l2.get(i2));
            i2++;
        }

        return result;


    }
}
