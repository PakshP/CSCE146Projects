
public class Tester {
	public static void main(String[] args) {
		
		GenLL<Integer> iLL = new GenLL<Integer>();
		//GenLL<int> ill2 = new GenLL<int>(); //Not correct
		GenLL<Double> dLL = new GenLL<Double>();
		GenLL<String> strLL = new GenLL<String>();
		
		/*
		Integer.parseInt("42");
		Double.parseDouble("42.0");*/
		
		for(int i=0;i<5;i++) {
			
			iLL.add(i);
			dLL.add(i*1.0);
			strLL.add("Number "+i);
			
		}
		
		iLL.print();
		dLL.print();
		strLL.print();

		for(int i=0;i<2;i++) {
			
			iLL.gotoNext();
			dLL.gotoNext();
			strLL.gotoNext();
			
		}
		
		iLL.print();
		dLL.print();
		strLL.print();
		
	}
	
	
}
