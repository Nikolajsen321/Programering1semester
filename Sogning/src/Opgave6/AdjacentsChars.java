package Opgave6;

public class AdjacentsChars {
    public static void main(String[] args) {
        String listOfChars = "aaaxxbb";

        System.out.println(repeatedChars(listOfChars, 3));
    }

    private static boolean repeatedChars(String listOfChars, int k) {
        int count = 1;
        boolean state = false;

        for (int i = 1; i < listOfChars.length(); i++) {
            if (listOfChars.charAt(i) == listOfChars.charAt(i - 1) ) {
                count++;
            }else{
                count = 1;
            }

            if (count == k) {
                state = true;
            }
        }
        return state;
    }

}



