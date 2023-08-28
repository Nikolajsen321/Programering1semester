import java.util.Arrays;

public class Opgave6 {
    public static void main(String[] args) {

        double[] testArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        System.out.println("\n følgende flytter array.length element  til array[0] plads og omvendt ");
        System.out.println(Arrays.toString(skift(testArray)));

        double[] ligeArray = new double[ testArray.length];
        // så jeg beholder min gamle testArray
        for(int i = 0; i < testArray.length; i++){
            ligeArray[i] = testArray[i];
        }

        System.out.println(" \n Skal udskiffte alle lige tal i arrayen med 0 ");
        System.out.println(Arrays.toString(replaceEq(ligeArray)));

        System.out.println(" \n Det andet største i arrayen er ");
        System.out.println( secHigh(testArray));

//        System.out.println(" \n Det er " + arraySorted(testArray, testArray.length) + " at den er stigende " +
//                Arrays.toString(testArray));

//        Arrays.stream(testArray).sorted();
//        Arrays.sort(testArray);

        if(arraySorted(testArray,testArray.length)) {
            System.out.println(" Den er soted i ascending order " + " \n " + Arrays.toString( testArray ));

        }else{
            System.out.println(" Den er ikke sorted i ascending order " +  Arrays.toString( testArray ));
        }


        System.out.println(" \n arrayen skifter mod højre ");
        System.out.println( Arrays.toString(shiftRight( testArray, testArray.length )));

        System.out.println(" \n arrayen skifter mod venstre");
        System.out.println( Arrays.toString(shiftLeftt( testArray, testArray.length )));


        double[] array = {4, 7, 5, 4, 3,};


        int nLength = array.length;

        if( doublets( array, nLength)){
            System.out.println( " \n There is dublets \n " + Arrays.toString( array));
        }else{
            System.out.println("\n There is no doublets \n " + Arrays.toString( array ));
        }


    }

    public static double[] skift(double[] a){
          double temp = a[0];

        a[0] = a[a.length -1];
          a[a.length -1] = temp;




         return a;


    }

    public static double[] replaceEq( double[] a){
        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 == 0){
                a[i] = 0;
            }
        }
        return a;
    }

    public static double secHigh( double[] a){
        double max = a[0];
        double secMax = 0;

        for(int i = 0; i < a.length; i++){
            if( a[i] > max){
                max = a[i];
            }
        }
        for(int j = 0; j < a.length; j++){
            if( max > a[j] && secMax  < a[j]){
                secMax = a[j];

            }
        }
        return secMax;
    }


    public static boolean  arraySorted(double[] a, int n){
        // denne her chekker om arrayen er større end 0 og 1 og så vil den være sorted
        // altså det er bare at arrayen kun har 1 eller 0 elementer
        // eller så er den chekked og sorted
        // da jeg sætter  i = 1 i loopen så vil jeg først chekke
            if(n == 1 || n == 0){
                return  true;
            }
            /* starter loop fra første element i arrayen
            compare 2 elementer adgangen  hvis den er sorted gå videre ellers false
            chekker a[0] a[1] og så a[1] med a[2]
             */
        for(int i = 1; i < n; i++){
            if(a[i] < a[i - 1]){
                return false;
            }
        }
        return true;
    }



    public static double[] shiftRight(double[] a, int n){
        double temp = a[a.length-1];
        for(int i = a.length-1; i > 0; i-- ){
            a[i] = a[ i -1];
        }
        a[0] = temp;

        return a;
    }
    public static double[] shiftLeftt(double[] a, int n){
        int count = 0;
        while(count  < 1) {
            double temp = a[0];
            for (int i = 0; i < a.length - 1; i++) {
                a[i] = a[i + 1];
            }
            count++;
            a[a.length -1] = temp;
        }

        return a;
    }


    public static boolean  doublets(double[] array, int arrayLength ){
       for(int i = 0; i < arrayLength; i++){
         for(int j = i +1; j < arrayLength; j++) {
           if (array[i] == array[j]) {
            return true;
           }
         }
       }
        return false;
    }
}
