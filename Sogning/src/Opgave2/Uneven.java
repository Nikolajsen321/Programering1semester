package Opgave2;

import java.util.ArrayList;

public class Uneven {
    public static void main(String[] args) {
        int number;
        int unevenNumber;
       int[] numberArray = {3,7,9,1,5};




     if( findUnevenLinear(numberArray)){
         System.out.println("Det ulige tal er der ");
     }else{
         System.out.println("Det er der ikke");
     }

        System.out.println(findUnevenLinear(numberArray));





    }

    private static boolean findUnevenLinear(int[] numberList) {
       boolean test = false;
       int i = 0;
        while (test == false && i < numberList.length){
            if(numberList[i] % 2 != 0){
                test = true;
            }else{
                i++;
            }
        }
        return test;
    }
}
