package Opgave3;

public class Interval {
    public static void main(String[] args) {
        int[] arrayInt = {7,56,34,3,7,14,13,4};

        System.out.println(findIntervalLinear(arrayInt));
//
    }

    private static int findIntervalLinear(int[] arrayInt) {
        int index = -1;
        int i = 0;

        while(index == -1 && i < arrayInt.length){
            if(arrayInt[i] < 16  && arrayInt[i] >= 10){
                index = arrayInt[i];
            }else{
                i++;
            }
        }
        return arrayInt[i];
    }
}
