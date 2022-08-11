package tests;

import org.testng.annotations.DataProvider;

public class DataForDataDrivenExamples {
	
	// Object data type is used as it can contain different types of data types
	@DataProvider(name = "DataForPost")
	public Object[][] DataForPost() {
		
		Object [][] data = new Object [2][3];
		
		data [0][0] = "Folashayo";
		data [0][1] = "Adakomola";
		data [0][2] = 1;
		
		data [1][0] = "Abisoye";
		data [1][1] = "Adakomola";
		data [1][2] = 2;
		
		return data;
		
		
	}
	
	
	@DataProvider(name = "DataForPost2")
	public Object[][] DataForPost2() {
		return new Object[][] {
			{"Sewanu", "Toyon", 1},
			{"Oyinkansola", "Akintimehin", 1}
		};
		
	}
	
	
	
	@DataProvider(name = "DataToDelete")
	public Object[] DataForDelete() {
		return new Object[] {4,5,6,7};
	}
	
}
