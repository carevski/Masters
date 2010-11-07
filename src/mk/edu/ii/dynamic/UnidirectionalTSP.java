package mk.edu.ii.dynamic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import mk.edu.ii.sorting.FlipjackSort;


public class UnidirectionalTSP {

	public static final UnidirectionalTSP INSTANCE = new UnidirectionalTSP();
	
	private void findRoute(String unordered){

	}
		
	
	public static void main(String [] args){
		try {
			BufferedReader cin = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
			PrintWriter cout = new PrintWriter(new FileOutputStream(new File("output.txt")));
			String line = "";
			while( (line = cin.readLine()) != null){
				if(line.trim().charAt(0) == '#') continue;
				cout.println(UnidirectionalTSP.INSTANCE.findRoute(line));
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
