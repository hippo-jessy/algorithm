package search;

/**
 * This is a common implementation of binary search.
 */
public class BinarySearch {
    public static int binarySearch(int[] data, int key){
       int left = 0;
        int right = data.length-1;
        int index = 0;
       while(true){
           if(right< left) return -1;
           index = right + (right-left)/2;
           if(data[index] < key){
               left = index + 1;
           }else if (data[index] > key){
               right = index -1;
           }else{
               return index;
           }
       }
    }
}
