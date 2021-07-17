package javaAssessment;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AssesmentCoreJavaTwo {
	
	public static void main(String[] args) {
	//Problem 1
	int[] inputIntArray = {12, 32, 12, 45, 65, 93, 0, 23, 45, 6};
	System.out.println("Average of Values in Input Array is "+Assessment.calculateAverageOfIntArray(inputIntArray));
	//Problem 2
	int startNumber=79;
	int endNumber=187;
	System.out.println("List of Odd Numbers between "+startNumber+" and "+endNumber+" is : "+Assessment.generateOddNumberTill(startNumber, endNumber));
	System.out.println("List of Even Numbers between "+startNumber+" and "+endNumber+" is : "+Assessment.generateEvenNumberTill(startNumber, endNumber));
	//Problem 3
	int number =1234;
	if(Assessment.checkPrimeNumbers(number))
		System.out.println("Given Number "+number+" is Prime");
	else
		System.out.println("Given Number "+number+" is Non-Prime");
	//Problem 3
	System.out.println("Sum of Digits of given number "+number+" is "+Assessment.sumOfDigits(number));
	//Problem 5
	int reverseNumber = Assessment.reverseNumber(number);
	String reverse = Assessment.reverse(number+"");
	if(reverse.equals(reverseNumber+"")) 
		System.out.println("Reverse of given number "+number+" is "+Assessment.reverseNumber(number));
	else
		System.err.println("Reversal is wrong");
	//Problem 6
	List<String> findDuplicatesInArray = Assessment.findDuplicatesInArray(Assessment.convertIntArrayToIntegerArray(inputIntArray));
	System.out.print("Duplicates: ");
	for (String string : findDuplicatesInArray) {
		System.out.print(string+" ");
		}
	System.out.println();
	String[] inputStringArray = {"Amazon","FlipKart","Amazon","Food Bay","flipkart","OLA","Food Bay"};
	findDuplicatesInArray = Assessment.findDuplicatesInArray(inputStringArray);
	System.out.print("Duplicates: ");
	for (String string : findDuplicatesInArray) {
		System.out.print(string+" ");
		}
	System.out.println();
	}
	
}

