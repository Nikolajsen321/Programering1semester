package Opgave5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class allIndexOfArrayList {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>(List.of("Hej","Hej","dav","Hej","Hej"));

        System.out.println("Metoden giver alle index hvor String/ordet som bliver bedt  listen er lineær da den " +
                "ikke er sorteret " +
                findAllIndices(stringList,"Hej"));
    }

    public static ArrayList<Integer> findAllIndices(ArrayList<String> list, String targets){
        ArrayList<Integer> index = new ArrayList<>();

        for(int i = 0; i < list.size(); i ++){
            String string = list.get(i);
            if(string.equals(targets)){
                index.add(i);
            }
        }

       return index;

    }
}
