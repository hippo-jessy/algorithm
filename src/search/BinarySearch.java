package search;

/**
 * This class demos recursive and iterative implementations of binary search for sorted .
 */
public class BinarySearch {

    public static int binarySearchIterative(int[] data, int beginIndex, int endIndex, int key){
        if(beginIndex > endIndex){
            return -1;
        }
        int index = beginIndex + (endIndex - beginIndex)/2;
        if(data[index] == key){
            return index;
        }else if(data[index] > key){
            return binarySearchIterative(data, beginIndex, index -1, key);
        }else{
            return binarySearchIterative(data, index + 1, endIndex, key);
        }

    }


    public static int binarySearchIterative(int[] data, int key){
       int left = 0;
        int right = data.length-1;
        int index = 0;
       while(true){
           if(right< left) return -1;
           index = left + (right-left)/2;
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
