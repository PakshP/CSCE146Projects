//Written by Paksh Patel

public class WordHelper {
	
	
	public static int numOfVowels(String word)
	{	
		//counting vowels
		int vowCount=0;
		for(int x=0;x<word.length();x++){
			//vowels
			if(word.charAt(x)=='a' || word.charAt(x)=='e' || word.charAt(x)=='i' || word.charAt(x)=='o' || word.charAt(x)=='u' || word.charAt(x)=='y')
			{
				vowCount++;
			}

		}
		return vowCount;
	}
	
	
	public static int numOfCons(String word){
		int consCount=0;
		//counting anything but specified vowels
		for(int x=0;x<word.length();x++){
			//specified vowels
			if(word.charAt(x)!='a' && word.charAt(x)!='e' && word.charAt(x)!='i' && word.charAt(x)!='o' && word.charAt(x)!='u' && word.charAt(x)!='y')
			{
				consCount++;
			}  	
		}
		return consCount;
	}
	
	
	public static String[] sortByVowels(String[] words) {
		String[] sortedVowels = new String[words.length];
		for(int i=0; i<words.length;i++)
		{
			sortedVowels[i]=words[i]; 
		}
		//BubbleSort, repeated for all sortBy<>
		boolean hasSwapped=true;
		while(hasSwapped==true)
		{
			hasSwapped=false;
			for(int i=0; i<sortedVowels.length-1;i++)
			{
				if(numOfVowels(sortedVowels[i]) > numOfVowels(sortedVowels[i+1]))
				{		
					String temp=sortedVowels[i];
					sortedVowels[i]=sortedVowels[i+1];
					sortedVowels[i+1]=temp;
		
					hasSwapped=true;
				}		
			}
		}
		return sortedVowels;
	}
	
	
	public static String[] sortByConsonants(String[] words){
		String[] sortedCons = new String[words.length];
		for(int i=0; i<words.length;i++){
			sortedCons[i]=words[i];
		}
		//BubbleSort
		boolean hasSwapped=true;
		while(hasSwapped==true)
		{
			hasSwapped=false;
			for(int i=0; i<sortedCons.length-1;i++)
			{	
				if(numOfCons(sortedCons[i]) > numOfCons(sortedCons[i+1]))
				{
					String temp=sortedCons[i];
					sortedCons[i]=sortedCons[i+1];
					sortedCons[i+1]=temp;
					
					hasSwapped=true;
				}		
			}
		}	
		return sortedCons;
	}
	
	
	public static String[] sortByLength(String[] words){
		String[] wordsL = new String[words.length];
		for(int i=0; i<words.length;i++){
			wordsL[i]=words[i];  
		}	
		//BubbleSort
		boolean hasSwapped=true;
		while(hasSwapped==true)
		{
			hasSwapped=false;
			for(int i=0; i<wordsL.length-1;i++)
			{
				if(wordsL[i].length()>wordsL[i+1].length())
				{
					String temp=wordsL[i];
					wordsL[i]=wordsL[i+1];
					wordsL[i+1]=temp;
					
					hasSwapped=true;
				}  
			}
		}
		return wordsL;
	}		
}