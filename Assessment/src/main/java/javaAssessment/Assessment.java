package javaAssessment;

import java.io.CharArrayReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.hssf.OldExcelFormatException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javaAssessment.utilities.SortOrder;
import javaAssessment.utilities.Triangle;

public class Assessment {

/**
 * Calculating Factorial of N Number using While Loop
 * @param number - Number for which factorial needs to be calculated
 * @return factorial - Factorial Value for the given number N
 */
	public static long calculateFactorialUsingWhileLoop(int number) {
		long factorial=1;
		int counter = 1;
		 if(number==0) {
			 factorial=1;
		 }
		 else {
			 while (counter<=number) {
				factorial*=counter;
				counter++;
			} 
		 } 
		return factorial;
	}
	/**
	 * Calculating Factorial of N Number using For Loop
	 * @param number - Number for which factorial needs to be calculated
	 * @return factorial - Factorial Value for the given number N
	 */
	public static long calculateFactorialUsingForLoop(int number) {
		long factorial=1;
		
		for (int index = 1; index <=number; index++) {
			factorial*=index;
		}

		return factorial;
	}
/**
 * Generating Fibonacci Series 
 * @param number - Number of Fibonacci numbers to be generated
 * @return fibonacciSeries - Fibonacci Series of N Numbers
 */
	
	public static String fibonaciNumber(int number) {
		String fibonacciSeries="";
		
		int previous = 0;
		int current = 1;
		int value = 0;
		int counter=0;
		while(counter<number) {
			
			if(counter==0) {
				value = previous;
				fibonacciSeries =fibonacciSeries+value+" "; 
				counter++;
				continue;
			}
			else if(counter==1) {
				value = current;
				fibonacciSeries =fibonacciSeries+value+" "; 
				counter++;
				continue;
			}
			else {
				value = previous+current;
			}
			 fibonacciSeries =fibonacciSeries+value+" "; 
			 previous = current;
			 current = value;
			 counter++;
		}
		
		return fibonacciSeries;
	}
	/**
	 * Sort the String Array in Ascending 
	 * @param inputArray
	 * @return Input Array Sorted in Ascending Order
	 */
	public static String[] sortArrayOfStringInAscending(String[] inputArray) {
				
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i+1; j < inputArray.length; j++) {
				if (inputArray[i].compareTo(inputArray[j])>0) {		
					String temp = inputArray[i];
					inputArray[i]=inputArray[j];
					inputArray[j] = temp;
				}
			}
		}
		return inputArray;	
	}
	/**
	 * Sort the String Array in Descending 
	 * @param inputArray
	 * @return Input Array Sorted in Descending Order
	 */
	public static String[] sortArrayOfStringInDescending(String[] inputArray) {
		
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i+1; j < inputArray.length; j++) {
				if (inputArray[i].compareTo(inputArray[j])<0) {		
					String temp = inputArray[i];
					inputArray[i]=inputArray[j];
					inputArray[j] = temp;
				}
			}
		}
		return inputArray;	
	}
	/**
	 * Sort the Array  
	 * @param inputArray - The Array which needs to be sorted , 
	 * @param sortOrder - Ascending / Descending
	 * @return Input Array Sorted based in sortOrder Parameter
	 */
	public static Object[] sortArray(Object[] inputArray,SortOrder sortOrder) {
		switch (sortOrder) {
		case Ascending:
			Arrays.sort(inputArray);
			break;
			
		case Descending:
			Arrays.sort(inputArray,Collections.reverseOrder());
			break;

		default:
			break;
		}
		return inputArray;
	}
	/**
	 * Compare Two arrays of any types
	 * @param arrayOne
	 * @param arrayTwo
	 * @return boolean value true if both arrays match else boolean value false
	 */
	public static boolean compareTwoStringArrays(Object[] arrayOne,Object[] arrayTwo) {
		boolean result=false;
		result = Arrays.equals(arrayOne, arrayTwo);
		return result;
		
	}
	/**
	 * Sort Array of Integers in Ascending
	 * @param inputArray
	 * @return Input Array in Ascending Order
	 */
	public static int[] sortArrayOfIntInAscending(int[] inputArray) {
		
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i+1; j < inputArray.length; j++) {
				if (inputArray[i]>inputArray[j]) {		
					int temp = inputArray[i];
					inputArray[i]=inputArray[j];
					inputArray[j] = temp;
				}
			}
		}
		return inputArray;	
	}
	/**
	 * Sort Array of Integers in Descending
	 * @param inputArray
	 * @return Input Array in Descending Order
	 */
	public static int[] sortArrayOfIntInDescending(int[] inputArray) {
		
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i+1; j < inputArray.length; j++) {
				if (inputArray[i]<inputArray[j]) {		
					int temp = inputArray[i];
					inputArray[i]=inputArray[j];
					inputArray[j] = temp;
				}
			}
		}
		return inputArray;	
	}
	/**
	 * Convert Array of Integer to Array of int
	 * @param integerArray 
	 * @return int Array
	 */
	public static int[] convertIntegerArrayToIntArray(Integer[] integerArray) {
		return Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray();
	}
	/**
	 * Convert Array of int to Array of Object
	 * @param int 
	 * @return Array of Object
	 */
	public static Object[] convertIntArrayToIntegerArray(int[] inputArray) {
		Object[] resultArray = new Object[inputArray.length];
		
		for (int i = 0; i < resultArray.length; i++) {
			resultArray[i]  = inputArray[i];
		}
		
		return resultArray;
	}
	/**
	 * To Check given Year is leap or not
	 * @param year to be checked
	 * @return boolean value , whether the given year is Leap or Non-Leap Year
	 */
	public static boolean checkLeapYear(int year) {

		return (year%4==0 && year%100!=0) || (year%400==0);
	}
	/**
	 * Calculate sum of n numbers
	 * @param number 
	 * @return Sum of N Numbers
	 */
	public static long calcualteSumOfNNumbersUsingForLoop(int number) {
		long result=0;
		for (int index =1; index <= number; index++) 
			result = result+index;
		return result;
	}
	/**
	 * Calculate sum of n numbers
	 * @param number 
	 * @return Sum of N Numbers
	 */
	public static long calcualteSumOfNNumbersUsingFormula(int number) {
		return (number*(number+1)/2);
	}
	/**
	 * Check given number is Prime or Not
	 * @param number
	 * @return boolean value , whether the give number is prime or not
	 */
	public static boolean checkPrimeNumbers(int number) {
		boolean result=true;
		if(number==1 || number==2) {
			result = true;
			return result;
		}			
		for (int index = 2; index <=number/2; index++) {	
			if(number%index==0)
				result=false;
		}
		return result;
	}
	/**
	 * Generate N Prime Numbers
	 * @param number
	 * @return String of N Prime Numbers
	 */
	public static String nPrimeNumbers(int number) {
		String result="";
		int counter=1;
		int index=1;
		while(counter<=number) {		
			if(checkPrimeNumbers(index)) {
				counter++;
				result=result+index+" ";
			}
			index++;
		}
		return result;
	}
	
	/**
	 * Calculate Area of the triangle
	 * @param breadth
	 * @param height
	 * @return Area of the th=riangle
	 */
	public static double areaOfTriangle(double breadth, double height) {
		return ((breadth*height)/2);
	}

	/**
	 * Generate Even Number Till N Numbers
	 * @param number
	 * @return String of Even Numbers till N number
	 */
	public static String generateEvenNumberTill(int number) {
		String result="";
		for (int index = 0; index <= number; index++) {
			if(index%2==0)
				result = result+index+" ";
		}
		return result;
	}
	/**
	 * Generate Odd Number Till N Numbers
	 * @param number
	 * @return String of Odd Numbers till N number
	 */
	public static String generateOddNumberTill(int number) {
		String result="";
		for (int index = 1; index <= number; index++) {
			if(index%2!=0)
				result = result+index+" ";
		}
		return result;
	}
	/**
	 * Generate Odd Numbers between Range
	 * @param startNumber
	 * @param endNumber
	 * @return String of Odd Numbers between the startNumber and endNumber
	 */
	public static String generateOddNumberTill(int startNumber, int endNumber) {
		String result="";
		for (int index = startNumber; index <= endNumber; index++) {
			if(index%2!=0)
				result = result+index+" ";
		}
		return result;
	}
	/**
	 * Generate Even Numbers between Range
	 * @param startNumber
	 * @param endNumber
	 * @return String of Even Numbers between the startNumber and endNumber
	 */
	public static String generateEvenNumberTill(int startNumber, int endNumber) {
		String result="";
		for (int index = startNumber; index <= endNumber; index++) {
			if(index%2==0)
				result = result+index+" ";
		}
		return result;
	}
	/**
	 * Print Triangle of Different Formats
	 * @param valueToBePrinted - Value to Be printed
	 * @param numberOfRows - Total Number of Rows
	 * @param triangle - Type of Triangle
	 */
	public static void printTriangle(String valueToBePrinted, int numberOfRows,Triangle triangle) {
		int indexOne,indexTwo =0;      
		switch (triangle) {
		case LeftSidedRightAngle:
			for (indexOne = 0; indexOne < numberOfRows; indexOne++) {
				for ( indexTwo = 0; indexTwo < indexOne; indexTwo++) 
					System.out.print(valueToBePrinted+" ");
				System.out.println();
			}
			break;
		case RightSidedRightAngle:
			for ( indexOne=0; indexOne<numberOfRows; indexOne++)   
			{  
				for ( indexTwo=2*(numberOfRows-indexOne); indexTwo>=0; indexTwo--)         
						System.out.print(" ");   
				for (indexTwo=0; indexTwo<=indexOne; indexTwo++ )     
					System.out.print(valueToBePrinted+" ");   
			System.out.println();   
			} 
			break;
		case Equilateral:
			for (indexOne=0; indexOne<numberOfRows; indexOne++)   
			{  
				for (indexTwo=numberOfRows-indexOne; indexTwo>1; indexTwo--)   
						System.out.print(" ");   
				for (indexTwo=0; indexTwo<=indexOne; indexTwo++ )   
					System.out.print(valueToBePrinted+" ");  
				System.out.println();   
			}   
			break;
		case Isocales:
			break;
		default:
			break;
		}
	}
	/**
	 * Calculate Average of Integers in array
	 * @param inputArray
	 * @return Double value of average of Integer values in input Array
	 */
	public static double calculateAverageOfIntArray(int[] inputArray) {
		double result=0.0;
		try {
			long sum=0;
			for (int index = 0; index < inputArray.length; index++) {
				sum+=inputArray[index];
			}
			result = sum/inputArray.length;
		}
		catch(ArithmeticException ae) {
			System.out.println(ae);
			result=0.0;
		}
		catch(NumberFormatException ne) {
			System.out.println(ne);
			result=0.0;
		}
		catch(ArrayIndexOutOfBoundsException are) {
			System.out.println(are);
			result=0.0;
		}
		catch (Exception e) {
			System.out.println(e);
			result=0.0;
		}
		return result;
	}
	/**
	 * Reverse the givenNumber
	 * @param numberToBeReversed
	 * @return reversed number
	 */
	public static int reverseNumber(int numberToBeReversed) {
		int result =0;
		String reversed="";
		 int temp=numberToBeReversed;
		 while (temp>0) {
			 reversed=reversed+(temp%10);
			temp=temp/10;
		}
		result = Integer.parseInt(reversed);
		return result;
	}
	/**
	 * Reverse the String 
	 * @param stringTobeReversed
	 * @return
	 */
	public static String reverse(String stringToBeReversed) {
		String reversedString="";
		char[] charArray = stringToBeReversed.toCharArray();
		for (int index = charArray.length-1; index >=0; index--) {
			reversedString=reversedString+charArray[index];
		}
		return reversedString;
	}
	/**
	 * Check the given item is palindrome
	 * @param stringOne
	 * @param reversed
	 * @return
	 */
	public static boolean checkPalindrome(String string) {
		return (reverse(string).equals(string));
		
	}
	/**
	 * Sum of the Digits
	 * @param number 
	 * @return Sum of Digits
	 */
	public static int sumOfDigits(int number) {
		int result =0;
		 int temp=number;
		 while (temp>0) {
			 result+=(temp%10);
			temp=temp/10;
		}
		 return result;
	}
	/**
	 * Find Duplicates in the Array
	 * @param inputArray
	 * @return List of Duplicates in the given Array
	 */
	public static List<String> findDuplicatesInArray(Object[] inputArray) {
		List<String> duplicates = new ArrayList<>();
		for (int indexOne = 0; indexOne < inputArray.length; indexOne++) {
			//System.out.println(inputArray[indexOne].toString());
			for(int indexTwo=indexOne+1;indexTwo<inputArray.length;indexTwo++) {
				//System.out.println(inputArray[indexTwo].toString());
				if(inputArray[indexOne].toString().equals(inputArray[indexTwo].toString())) {
					duplicates.add(inputArray[indexOne].toString());
					break;
				}	
			}
		}
		return duplicates;		
	}
	/**
	 * To find the occurrance of each charachter in the given word
	 * @param word
	 * @return Map of charachter in the word to number of occurrance of the same
	 */
	public static TreeMap<Character, Integer> occuranceOfeachCharachteInWord(String word) {
		char[] charArray = word.toCharArray();
		TreeMap<Character, Integer> countTreeMap = new TreeMap<>();
		for (char charachter : charArray) {
			if(countTreeMap.containsKey(charachter)) {
				countTreeMap.put(charachter, countTreeMap.get(charachter)+1);
			}
			else{
				countTreeMap.put(charachter, 1);
			}
		}
		return countTreeMap;
	}
	/**
	 * To Check the word is present in text
	 * @param text
	 * @param word
	 * @return Returns true if word is present in text or else false
	 */
	public static boolean checkWordPresentInText(String text, String word) {
		return (text.contains(word));
	}
	/**
	 * Test Method to throw number format exception intentionally
	 * @param name - String
	 * @return integer value
	 */
	public static int numberFormatExceptionMethod(String name) {
		int result=0;
		try {
			result = Integer.parseInt(name);
		}
		catch(NumberFormatException ne) {
			System.out.println(ne);
			result=0;
		}
		catch (Exception e) {
			System.out.println(e);
			result=0;
		}
		return result;
	}
	/**
	 * Convert Charachter Array to String
	 * @param charArray
	 * @return String formed from charachter array
	 */
	public static String convertCharArrayToString(char[] charArray) {
		String result="";
		for (char charachter : charArray) 
			result=result+charachter;
		return result;
	}
	/**
	 * Convert String to Char Array
	 * @param string
	 * @return Char Array formed from given String
	 */
	public static char[] convertStringToCharArray(String string) {
		char[] charArray= new char[string.length()];
		for (int index = 0; index < string.length(); index++) {
			charArray[index]=string.charAt(index);
		}
		return charArray;
	}
	
	/**
	 * Test Method to throw number format exception intentionally
	 * @param name - String
	 * @return integer value
	 */
	public static int arithematicExceptionMethod(String name) throws ArithmeticException{
		return 100/2;
	}
	/**
	 *Test method for having bested try blocks
	 * @param filePath
	 * @throws NoSuchFileException 
	 */
	public static void nestedTryCatchBlocks(String filePath) throws NoSuchFileException {
		Workbook workBook = null;
		try {
			
			File inputFile = new File(filePath);
			
			FileInputStream inputStream = new FileInputStream(inputFile);
			String fileName = filePath.replace("./", "").trim();
		    String fileExtensionName = fileName.substring(fileName.indexOf("."));
		    try {
			    if(fileExtensionName.equalsIgnoreCase(".xlsx"))
			    	workBook = new XSSFWorkbook(inputStream);
			    else if(fileExtensionName.equalsIgnoreCase(".xlsx"))
			    	workBook = new HSSFWorkbook(inputStream);
		    }
		    catch (OldExcelFormatException ofe) {
		    	System.out.println(ofe);
		    	workBook = null;
		    }
		    catch (Exception e) {
		    	System.out.println(e);
		    	workBook = null;
		    }
		    try {
		    	Sheet sheet = workBook.getSheet("sheet1");
				System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
		    }
		    catch (Exception e) {
		    	System.out.println(e);
		    }
		    
		}
		catch (IOException e) {
			System.out.println(e);
			workBook=null;
		}
		catch (Exception e) {
			System.out.println(e);
			workBook=null;
			throw new NoSuchFileException(filePath);
		}
	}
	/**
	 * Gets the list of duplicate Charachter in the given word
	 * @param word
	 * @return list of duplicate Charachter in the given word
	 */
	public static List<Character> duplicateCharachtersInWord(String word) {
		List<Character> duplicateCharachters = new ArrayList<>();
		char[] charArray = word.toCharArray();
		HashMap<Character, Integer> countHashMap = new HashMap<>();
		for (char charachter : charArray) {
			if(countHashMap.containsKey(charachter)) {
				countHashMap.put(charachter, countHashMap.get(charachter)+1);
			}
			else{
				countHashMap.put(charachter, 1);
			}
		}
		Set<Entry<Character, Integer>> entrySet = countHashMap.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue()>1 && (! (entry.getKey().toString().equals(" "))))
				duplicateCharachters.add(entry.getKey());
		}
		return duplicateCharachters;
	}
	/**
	 * Convert Hash Set to Object Array
	 * @param hashSet
	 * @return Array of Object with contents of Hash Set
	 */
	public static Object[] convertHashSetToObjArray(HashSet<Character> hashSet) {
		Object[] objectArray = new Object[hashSet.size()]; 
		List<Character> list = new ArrayList<>();
		list.addAll(hashSet);
		for (int index = 0; index < hashSet.size(); index++) {
			objectArray[index] = list.get(index);
		}
		return objectArray;
	}
	/**
	 * To get Maximum value stored in Tree Map
	 * @param treeMap
	 * @return Maximum value stored in Tree Map
	 */
	public static int findMaxInTreeMap(TreeMap<String, Integer> treeMap) {
		int result = -1;
		Set<Entry<String, Integer>> entrySet = treeMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			if (entry.getValue()>result)
				result=entry.getValue();
		}
		return result;
	}
	/**
	 * To get Minimum value stored in Tree Map
	 * @param treeMap
	 * @return Minimum value stored in Tree Map
	 */
	public static int findMinInTreeMap(TreeMap<String, Integer> treeMap) {
		int result = 1000000000;
		Set<Entry<String, Integer>> entrySet = treeMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			if (entry.getValue()<result)
				result=entry.getValue();
		}
		return result;
	}
}

