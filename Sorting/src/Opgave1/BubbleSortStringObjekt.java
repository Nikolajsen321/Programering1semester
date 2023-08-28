package Opgave1;

import java.util.ArrayList;
import java.util.Arrays;

public class  BubbleSortStringObjekt {
    public static void main(String[] args) {
        String[] s = {"Erna","Elly","Laurits","Bertha",
                "Christian","August","Marius","John","Tove", "Poul","Torkild"};

        System.out.println(Arrays.toString(s));

        System.out.println();

        sortedStringObjekter(s);

        System.out.println(Arrays.toString(s));

    }

    private static void sortedStringObjekter(String[] s) {
        for(int i = s.length - 1; i >= 0; i --){
        for(int j = 0; j <= i-1; j++){
            if(s[j].compareTo(s[j+1]) > 0){
                swap(s,j,j+1);
            }
            }
        }
    }
    private static void swap(String[] s,int i, int j){
        String temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
