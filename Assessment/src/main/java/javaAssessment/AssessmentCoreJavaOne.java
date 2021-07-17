package javaAssessment;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import javaAssessment.utilities.SortOrder;
import javaAssessment.utilities.Triangle;

public class AssessmentCoreJavaOne {
	
	public static void main(String[] args) {
		
		int number = 50;
		//Problem 1
		long forLoop= Assessment.calculateFactorialUsingForLoop(number);
		long whileLoop = Assessment.calculateFactorialUsingWhileLoop(number);
		if(forLoop==whileLoop) {
			System.out.println("Calculation is correct");
			System.out.println("Factorial of "+number+" is "+whileLoop);
		}
		else {
			System.err.println("Calculation is incorrect");
			System.out.println("Factorial of "+number+" while Loop is "+whileLoop);
			System.out.println("Factorial of "+number+" for Loop is "+forLoop);
		}
		//Problem 2
		System.out.println(Assessment.fibonaciNumber(number));
		//Problem 3
		String [] inputStringArray = {"Zim","Jack","Aby","Santhosh"};
		Object[] sortArrayAscending = Assessment.sortArray(inputStringArray, SortOrder.Ascending);
		String[] sortArrayOfStringInAscending = Assessment.sortArrayOfStringInAscending(inputStringArray);
		
		if (Assessment.compareTwoStringArrays(sortArrayOfStringInAscending, sortArrayAscending)) {
			System.out.println();
			for (String string : sortArrayOfStringInAscending) {
				System.out.print(string+" ");
			}
		}
		else
			System.err.println("Arrays are not sorted Properly");
		
		
		Object[] sortArrayDescending = Assessment.sortArray(inputStringArray, SortOrder.Descending);
		String[] sortArrayOfStringInDescending = Assessment.sortArrayOfStringInDescending(sortArrayOfStringInAscending);
		if (Assessment.compareTwoStringArrays(sortArrayOfStringInDescending, sortArrayDescending)) {
			System.out.println();
			for (String string : sortArrayOfStringInDescending) {
				System.out.print(string+" ");
			}
		}
		else
			System.err.println("Arrays are not sorted Properly");
		
		Integer[] inputIntArray = {9,13,25,1,65,24,55,0,37};
		
		sortArrayAscending = Assessment.sortArray(inputIntArray, SortOrder.Ascending);
		int[] sortArrayOfIntInAscending = Assessment.sortArrayOfIntInAscending(Assessment.convertIntegerArrayToIntArray(inputIntArray));
		
		if (Assessment.compareTwoStringArrays(Assessment.convertIntArrayToIntegerArray(sortArrayOfIntInAscending), sortArrayAscending)) {
			System.out.println();
			for (int string : sortArrayOfIntInAscending) {
				System.out.print(string+" ");
			}
		}
		else
			System.err.println("Arrays are not sorted Properly");
	
		sortArrayDescending = Assessment.sortArray(inputIntArray, SortOrder.Descending);
		int[] sortArrayOfIntInDescending = Assessment.sortArrayOfIntInDescending(Assessment.convertIntegerArrayToIntArray(inputIntArray));
		if (Assessment.compareTwoStringArrays(Assessment.convertIntArrayToIntegerArray(sortArrayOfIntInDescending), sortArrayDescending)) {
			System.out.println();
			for (int string : sortArrayOfIntInDescending) {
				System.out.print(string+" ");
			}
		}
		else
			System.err.println("Arrays are not sorted Properly");

		System.out.println();
		//Problem 4
		int year= 2004;
		String leapYear= "Non Leap Year";
		if(Assessment.checkLeapYear(year))
			leapYear = "Leap Year";
		System.out.println("Given Year "+year+" is "+leapYear);
		
		year= 2005;
		leapYear= "Non Leap Year";
		if(Assessment.checkLeapYear(year))
			leapYear = "Leap Year";
		System.out.println("Given Year "+year+" is "+leapYear);
		
		year= 2010;
		leapYear= "Non Leap Year";
		if(Assessment.checkLeapYear(year))
			leapYear = "Leap Year";
		System.out.println("Given Year "+year+" is "+leapYear);
		
		year= 2100;
		leapYear= "Non Leap Year";
		if(Assessment.checkLeapYear(year))
			leapYear = "Leap Year";
		System.out.println("Given Year "+year+" is "+leapYear);
		
		year= 1992;
		leapYear= "Non Leap Year";
		if(Assessment.checkLeapYear(year))
			leapYear = "Leap Year";
		System.out.println("Given Year "+year+" is "+leapYear);
		
		year= 2020;
		leapYear= "Non Leap Year";
		if(Assessment.checkLeapYear(year))
			leapYear = "Leap Year";
		System.out.println("Given Year "+year+" is "+leapYear);
		
		//Problem 5
		System.out.println(Assessment.nPrimeNumbers(number));
		
		//Problem 6
		Scanner scan = new Scanner(System.in);
		System.out.println(Assessment.areaOfTriangle(scan.nextDouble(), scan.nextDouble()));
		
		//Problem 7
		long calcualteSumOfNNumbersUsingForLoop = Assessment.calcualteSumOfNNumbersUsingForLoop(number);
		long calcualteSumOfNNumbersUsingFormula = Assessment.calcualteSumOfNNumbersUsingFormula(number);
		if(calcualteSumOfNNumbersUsingForLoop == calcualteSumOfNNumbersUsingFormula)
			System.out.println("Sum of first "+number+" is "+calcualteSumOfNNumbersUsingFormula);
		else
			System.err.println("Error in calculation");
		//Problem 8
		int arraySize = scan.nextInt();
		Object[] arrayToBeReversed =  new Object[arraySize];
		for (int i = 0; i < arrayToBeReversed.length; i++) {
			arrayToBeReversed[i] =  scan.next();
		}
		Arrays.sort(arrayToBeReversed,Collections.reverseOrder());
		for (Object object : arrayToBeReversed) {
			System.out.print(object.toString()+" ");
		}
		System.out.println();
		//Problem 9
		System.out.println("Odd numbers till "+number+" : "+Assessment.generateOddNumberTill(number));
		System.out.println("Even numbers till "+number+" : "+Assessment.generateEvenNumberTill(number));
		System.out.println();
		//Problem 10
		Assessment.printTriangle("1", 10, Triangle.LeftSidedRightAngle);
		Assessment.printTriangle("*", 10, Triangle.RightSidedRightAngle);
		Assessment.printTriangle("#", 10, Triangle.Equilateral);

	}
}
