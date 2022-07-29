
import java.util.Arrays;

public class InsertionSort{
    
    
    public static void insertionSort(int array[]) {
    for (int j = 1; j < array.length; j++) {
        int current = array[j];
        int i = j-1;
        while ((i > -1) && (array[i] > current)) {
            array[i+1] = array[i];
            i--;
        }
        array[i+1] = current;
    }
}
    
    public static void main(String [] args){
    int[] array = new int[]{1, 7, 5, 6, 9, 4, 2, 3};
    insertionSort(array);
    System.out.println(Arrays.toString(array));
    
    }
} 
    
    
    
