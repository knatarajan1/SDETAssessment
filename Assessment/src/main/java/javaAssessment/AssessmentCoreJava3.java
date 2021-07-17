package javaAssessment;

import java.nio.file.NoSuchFileException;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class AssessmentCoreJava3 {

	public static void main(String[] args) {
	
		//Problem 1
		String name= "DevLabs Alliance Training";
		TreeMap<Character, Integer> occuranceOfeachCharachteInWord = Assessment.occuranceOfeachCharachteInWord(name);
		Set<Entry<Character, Integer>> entrySet = occuranceOfeachCharachteInWord.entrySet();
		System.out.println("OCCOURANCE OF EACH LETTER IN WORD "+name);
		for (Entry<Character, Integer> entry : entrySet) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		//Problem 2
		name = "trurt";
		if(Assessment.checkPalindrome(name))
			System.out.println("Given word "+name+" is Palindrome");
		else
			System.out.println("Given word "+name+" is not palindrome");
		//Problem 3
		String word = "brown";
		String text = "A brown fox";
		if(Assessment.checkWordPresentInText(text, word))
				System.out.println("Given word "+word+" is present in "+text);
		else
				System.out.println("Given word "+word+" is not present in "+text);
		text = "ran away fast";
		if(Assessment.checkWordPresentInText(text, word))
			System.out.println("Given word "+word+" is present in "+text);
		else
			System.out.println("Given word "+word+" is not present in "+text);	
		//Problem 4
		char[] convertStringToCharArray = Assessment.convertStringToCharArray(name);
		String convertCharArrayToString = Assessment.convertCharArrayToString(convertStringToCharArray);
		if(name.equals(convertCharArrayToString))
			System.out.println("String to Char Array Conversion and Char Array to String Conversion is Correct");
		else
			System.err.println("String to Char Array Conversion and Char Array to String Conversion is in Correct");
		//Problem 5
		System.out.println("Number Format Exception Method: "+Assessment.numberFormatExceptionMethod(name));
		//Problem 6
		System.out.println("Arithematic Exception Method :"+Assessment.arithematicExceptionMethod(name));
		//Problem 7 & 8
		/**
		 * No Such file present in the project directory, added just to validate the 
		 * problem statement
		 */
		try {
			Assessment.nestedTryCatchBlocks(".data/nestedData.xlsx");
		} catch (NoSuchFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
