package measure;

public class SortMethods {
    
    public static void bubbleSort(String[] array) {
        // TODO
        for(int i = array.length - 1; i >= 0; i --){
            for(int j = 0; j <= i-1; j++){
                if(array[j].compareTo(array[j+1]) > 0){
                    swap(array,j,j+1);
                }
            }
        }
    }

    private static void swap(String[] s, int i, int j){
        String temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    
    public static void insertionSort(String[] array) {        
        // TODO
        for(int i = 1 ; i < array.length; i++){
            String currentElement = array[i];
            int j = i;
            boolean found = false;

            while (!found && j > 0){
                if(currentElement.compareTo(array[j-1]) >= 0){
                    found = true;
                }else {
                    array[j] = array[j-1];
                    j--;
                }

            }
            array[j] = currentElement;
        }
    }
    
    public static void selectionSort(String[] array) {
        for(int i =0; i <array.length; i++ ){
            int currentMinIndex = i ;
            for(int j = i +1; j < array.length; j++){
                if(array[j].compareTo(array[currentMinIndex]) < 0){
                    currentMinIndex = j;
                }
            }
            swap(array,i,currentMinIndex);
        }
    }
    
}
