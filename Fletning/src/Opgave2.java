import java.util.ArrayList;
import java.util.Arrays;

public class Opgave2 {
    public static void main(String[] args) {
        //Lav to Int arrays og lav en generalfletning af dem
       int[] a1 = {2,4,6,8,10,12,14};
       int[] a2 = {1,2,4,5,6,9,12,17};

        System.out.println(Arrays.toString(generelFletning(a1,a2)));




    }


    public  static Integer[] generelFletning(int[] a1, int[] a2){
        int i1 = 0;
        int i2 = 0;
        int count = 0;

        ArrayList<Integer> result = new ArrayList<>();

        while (i1 < a1.length && i2 < a2.length ){
            if(a1[i1] < a2[i2]){
                i1++;
            }else if(a1[i1] > a2[i2]){
                i2++;
            }else {
                result.add(a1[i1]);
                i1++;
                i2++;
            }
        }

//        int[] arrayResult = new int[result.size()];
//
//        for(int i = 0; i < result.size(); i++){
//            arrayResult[i] = result.get(i);
//        }

        return result.toArray(new Integer[0]);

    }
}
