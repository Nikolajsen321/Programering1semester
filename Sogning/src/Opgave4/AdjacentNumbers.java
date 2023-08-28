package Opgave4;

public class AdjacentNumbers {
    public static void main(String[] args) {
        int[] arrayInt = {3, 1, 13, 13, 13, 4};

        System.out.println(findAdjacentNumbers(arrayInt));
        int[] arrayInt2 = {13, 4, 7, 13, 13, 13};
        System.out.println(findAdjacentNumbers(arrayInt2));


        System.out.println(findNAdjacentNumber(arrayInt, 3));
    }

    private static boolean findNAdjacentNumber(int[] arrayInt, int n) {
        boolean test = false;
        int i = 1;
        int count = 1;

        while (test == false && i < arrayInt.length) {
            if (arrayInt[i] == arrayInt[i-1]) {
                count++;
                i++;
            } else {
                count = 1;
                i++;
            }
            if (count == n) {
                test = true;
            }
        }
        return test;

    }


//    boolean test = false;
//    int i = 1;
//    int count = 1;

//        while ( i < arrayInt.length && count != n) {
//        if (arrayInt[i] == arrayInt[i-1]) {
//            count++;
//            i++;
//        } else {
//            count = 1;
//            i++;
//        }
//        if (count == n) {
//            test = true;
//        }
//    }
//        return count == n;
//
//}




    private static boolean findAdjacentNumbers(int[] arrayInt) {
        boolean test = false;
        int i = 0;
        int secondNumber = 0;

        while (test == false && i < arrayInt.length) {
            if (secondNumber == arrayInt[i]) {
                test = true;
            } else {
                secondNumber = arrayInt[i];
                i++;
            }
        }
        return test;
    }


}
