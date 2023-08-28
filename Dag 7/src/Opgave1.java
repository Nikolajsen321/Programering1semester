import java.util.Arrays;

public class Opgave1 {
    public static void main(String[] args) {

        double[] myList = new double[10];
        System.out.println(Arrays.toString(myList));

//        for(int i = 0; i < myList.length; i++)
//
//        System.out.println( myList[0]);


        // 2. Array
        System.out.println();
        double[] myList2  ={2,44, -23, 99, 8, -5, 7, 10, 20 , 30};
        System.out.println(Arrays.toString(myList2));

        // 3 Array
        System.out.println();

        double[] myArray3 = new double[10];

        for(int i = 0; i < myArray3.length; i++){
            myArray3[i] = i;

        }
        System.out.println(Arrays.toString( myArray3));
// Array 4
        double[] myArray4 = new double[ 10];
        for( int i = 0; i < myArray4.length; i ++){
            myArray4[i] = 2 * (i+1);

        }
        System.out.println();

        System.out.println( Arrays.toString( myArray4));
        System.out.println();

        // Array 5

        double[] myArray5 = new double[10];
        int sum = 0;
        int unEven = 1;
        int count = 1;

        for(int i = 0; i < myArray5.length; i++ ){

//            sum = (sum + unEven);
//            unEven = unEven + 2;
//          myArray5[i] = sum;

            myArray5[i] = count * count;
            count ++;
        }
        System.out.println( Arrays.toString( myArray5));

        double[]myArray6 = new double[10];
        int count1 = 0;

        for( int i = 0 ; i < myArray6.length; i++ ){
            myArray6[i] = count1 % 2;

            count1++;



        }
        System.out.println();
        System.out.println( Arrays.toString( myArray6));
        System.out.println();

        double[] myArray7 = new double[10];
        int count2 = 0;

        for(int i = 0; i < myArray7.length; i++){
            myArray7[i] = count2;
            count2++;
            if(count2 > 4){
                count2 = count2 * 0;
            }


        }
        System.out.println(Arrays.toString( myArray7));
        System.out.println();

        double[] myArray8 = new double [10];
        int count3 = 0;

        for(int i = 0; i < myArray8.length; i++) {
            myArray8[i] = count3;

            if( i > 0 && i % 2 != 0) {
                count3 += 2;
                myArray8[i] = count3;
            }
            count3 ++;

        }

        System.out.println(Arrays.toString( myArray8 ));
        System.out.println();



    }


}
