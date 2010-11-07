package mk.edu.ii.sorting;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FlipjackSort {

	public static final FlipjackSort INSTANCE = new FlipjackSort();
	
	private String flipjackSort(String unordered){
		String result = "";
		String[] splits = unordered.split(" ");
		int size = splits.length - 1;
		int endPosition = size;
		while(endPosition > 0){
			
			int maxPosition = findMaxElemPosition(splits, endPosition);
			
			if(maxPosition == endPosition){
				endPosition--;
				continue;
			}else{
		        
	            if(maxPosition != 0)
	            {
	                result += String.format("%d ", size - maxPosition + 1);
	                reverse(splits, maxPosition);
	            }
	            result += String.format("%d ", size - endPosition + 1);
	            reverse(splits, endPosition);
			}
		}
		result += "0";
		return result;
	}
		
	private void reverse(String[] array, int pos){
		int before = 0;
		while(before < pos-before){
			String t = array[before];
			array[before] = array[pos-before];
			array[pos-before] = t;
			before++;
		}
	}
	
	private int findMaxElemPosition(String[] arr, int endPoss){
		int maxPosition = 0;
		for(int i=1; i<=endPoss; i++){
			if( arr[i].compareTo(arr[maxPosition]) > 0 ){
				maxPosition = i;
			}
		}
		return maxPosition;
	}
	
	public static void main(String [] args){
		try {
			BufferedReader cin = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
			PrintWriter cout = new PrintWriter(new FileOutputStream(new File("output.txt")));
			String line = "";
			while( (line = cin.readLine()) != null){
				if(line.trim().charAt(0) == '#') continue;
				cout.println(line);
				cout.println(FlipjackSort.INSTANCE.flipjackSort(line));
			}
			cin.close();
			cout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}