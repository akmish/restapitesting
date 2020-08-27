package com.apitesting.testcases;
import org.testng.annotations.DataProvider;

public class DataProviderForAPITest {

	@DataProvider(name="SamplePostData")
	public Object[][] dataForPost(){

		//First way of doing via Data provider

		//		Object[][] data = new Object[3][5];
		//		data[0][0] = "Jim";
		//		data[0][1] = "Carry";
		//		data[0][2] = "05/07/2011";
		//		data[0][3] = 12;
		//		data[0][4] = 3;
		//		
		//		data[1][0] = "Alice";
		//		data[1][1] = "Stew";
		//		data[1][2] = "18/07/2020";
		//		data[1][3] = 16;
		//		data[1][4] = 1;
		//		
		//		data[2][0] = "Meghan";
		//		data[2][1] = "Fox";
		//		data[2][2] = "20/11/2017";
		//		data[2][3] = 14;
		//		data[2][4] = 2;
		//			
		//		return data;

		// Second way of doing
		return new Object[][] {
			{"Tom", "Langford", "05/09/2014", 12, 4}
		};
	}

	@DataProvider(name="SampleGetData")
	public Object[] dataForGet(){

		return new Object[] {
				1001, 772, 7258, 4587, 1258, 7259, 7260, 7261
		};
	}

	@DataProvider(name="SampleDeleteData")
	public Object[] dataForDelete(){

		return new Object[] {
				7262
		};
	}

}
