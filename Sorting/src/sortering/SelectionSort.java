package sortering;

public class SelectionSort {
    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                //sammenligner og finder mindste samt index
                if (list[j] < list[currentMinIndex]) {
                    currentMinIndex = j;
                }
            }
            swap(list, i, currentMinIndex);
        }
    }
    
}
