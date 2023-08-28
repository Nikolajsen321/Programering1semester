package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Opgave3 {
    public static void main(String[] args) {
        Customer c1 = new Customer("D","Lars",40);
        Customer c2 = new Customer("Andersen","Ditte",90);
        Customer c3 = new Customer("Carstensen","Mikkel",28);
        Customer c4 = new Customer("Magnusen","Benjamin",24);
        Customer c5 = new Customer("Jonasen","Jonas",24);

        //String - Array
        String[] customerStringList = {c1.getFirstName(),c2.getFirstName(),c3.getFirstName(),c4.getFirstName(),
                c5.getFirstName()};
        System.out.println("String Array");
        System.out.println(Arrays.toString(customerStringList));
        insertionSort(customerStringList);
        System.out.println( Arrays.toString(customerStringList));
        System.out.println();
        //Customer - ArrayList
        System.out.println("ArrayList for Customer");
        ArrayList<Customer> customerArrayList = new ArrayList<>(List.of(c1,c2,c3,c4,c5));
        System.out.println(customerArrayList.toString());
        insertionSort(customerArrayList);
        System.out.println(customerArrayList.toString());



    }

    public static void insertionSort(String[] list){
        for(int i = 1 ; i < list.length; i++){
            String currentElement = list[i];
            int j = i;
            boolean found = false;

            while (!found && j > 0){
                if(currentElement.compareTo(list[j-1]) >= 0){
                    found = true;
                }else {
                    list[j] = list[j-1];
                    j--;
                }

            }
            list[j] = currentElement;

        }
    }

    public static void insertionSort(ArrayList<Customer> list){
        for(int i = 1; i < list.size()-1; i++){
            Customer currentElement = list.get(i);
            String navn = currentElement.getFirstName();
            int j = i;
            boolean found = false;
            while (!found && j > 0){
                if(navn.compareTo(list.get(j-1).getFirstName()) >= 0){
                    found = true;
                }else {
                    list.set(j,list.get(j-1));
                    j--;
                }
            }
            list.set(j,currentElement);

        }
    }
}
