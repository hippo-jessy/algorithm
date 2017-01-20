package sorting;

public class CountingSort {

	
	public static void countingSort(int[] data, int range){
		int[] countingArray = new int[range+1];
		int[] outputArray = new int[data.length];
		for(int i =0;i<data.length;i++){
			countingArray[data[i]]++;
		}
		
		for(int j=1;j<=countingArray.length-1;j++){
			countingArray[j]+=countingArray[j-1];
		}
		for(int k = data.length-1;k>=0;k--){
			//Attention!!!!
			//The index is "countingArray[data[k]]-1" rather than "countingArray[data[k]]"
			outputArray[countingArray[data[k]]-1]=data[k];
			countingArray[data[k]]--;
		}
		
		System.arraycopy(outputArray, 0, data, 0, data.length);
	}
}
