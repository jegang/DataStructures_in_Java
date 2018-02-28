/************************************************
*	FileName :  IsUnique.java
*	Author	 :  Jegan Gopalakrishnan
*   Date	 :  Feb 17, 2018
*************************************************/
// Check if a string has all unique characters or not
// Donot use any addition data structure
// This question is taken from CTCI 1.1


class ArraysAndStrings
{
	// Assuming the char array is ASCII 0-127 
	// Create and boolean array and initialize it
	// Make the bool  - true when first time it is hit, 
	// if any character is hit second time return false
	boolean isUnique(String str)
	{
		boolean[] ascii = new boolean[128];
		
		for(int i=0; i < 128; i++)
		{
			ascii[i] = false;
		}
		
		char[] ch = str.toCharArray();
		for(int i=0; i<ch.length; i++)
		{
			if(ascii[ch[i]] == true) 
				return false;
			
			ascii[ch[i]] = true;
		}
		
		return true;
	}
	
	
	// Function execution begins here
	public static void main(String[] args)
	{
		ArraysAndStrings as = new ArraysAndStrings();
		
		String s1 = "JeganGopalakrishnan";
		String s2 = "qwer124387/;'l";
		
		System.out.println(s1 + " String is " + (as.isUnique(s1)?"Unique":"Not Unique"));
		System.out.println(s2 + " String is " + (as.isUnique(s2)?"Unique":"Not Unique"));
		
	}
	
}



