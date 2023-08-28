package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Opgave2 {
    public static void main(String[] args) {
        Customer c1 = new Customer("Hansen","Mikkel",40);
        Customer c2 = new Customer("Hansen","Ditte",90);
        Customer c3 = new Customer("Bang","Mikkel",28);
        Customer c4 = new Customer("Benjamin","Benjamin",24);
        Customer c5 = new Customer("Jonas","Jonas",24);

        String[] customerStringList = {c1.getFirstName(),c2.getFirstName(),c3.getFirstName(),c4.getFirstName(),
        c5.getFirstName()};

        ArrayList<Customer> customerList = new ArrayList<>(List.of(c1,c2,c3,c4,c5));

        selectionSortString(customerStringList);

        System.out.println(Arrays.toString(customerStringList));

        System.out.println();

        selectionCustomer(customerList);

        System.out.println(customerList.toString());

    }


        public static void swap(String[] list,int i, int j){
            String temp = list[i];
            list[i] = list[j];
            list[j] = temp;
        }

        public static void swap(ArrayList<Customer> list, int i, int j){
        Customer temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);

        }



        public static void selectionSortString(String [] list){
        for(int i =0; i <list.length; i++ ){
            int currentMinIndex = i ;
            for(int j = i +1; j < list.length; j++){
                if(list[j].compareTo(list[currentMinIndex]) < 0){
                    currentMinIndex = j;
                }
            }
            swap(list,i,currentMinIndex);
        }


        }


        public static void selectionCustomer(ArrayList<Customer> list){
            for(int i =0; i <list.size(); i++ ){
                int currentMinIndex = i ;
                for(int j = i +1; j < list.size(); j++){

                    if(list.get(j).getFirstName().compareTo(list.get(currentMinIndex).getFirstName()) < 0)
                    {
                        currentMinIndex = j;
                    }
                }
                swap(list,i,currentMinIndex);
            }



        }



}
