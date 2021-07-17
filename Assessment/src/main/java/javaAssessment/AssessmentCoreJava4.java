package javaAssessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class AssessmentCoreJava4 {

	public static void main(String[] args) {
		//Problem 1 & 3 duplicateCharachtersInWord method is having a step validate whethere the 
		//Hash Map is having the particualr Key
		String name = "DevLabs Alliance Training";
		List<Character> duplicateCharachtersInWord = Assessment.duplicateCharachtersInWord(name);
		System.out.println("Duplicate Charachters in "+name);
		for (Character character : duplicateCharachtersInWord) {
			System.out.print(character+" ");
		}
		System.out.println();
		//Problem 2
		Collections.reverse(duplicateCharachtersInWord);
		System.out.println("Reversal of Array List:");
		for (Character character : duplicateCharachtersInWord)
			System.out.print(character+" ");
		System.out.println();
		//Problem 4
		List<Character> list = new ArrayList<Character>();
		TreeMap<Character, Integer> occuranceOfeachCharachteInWord = Assessment.occuranceOfeachCharachteInWord(name);
		list.addAll(occuranceOfeachCharachteInWord.keySet());
		System.out.println("Keys of Map");
		for (Character character : list) 
			System.out.print(character+" ");
		System.out.println();
		//Problem 5
		HashSet<Character> hashSet = new HashSet<>();
		hashSet.addAll(occuranceOfeachCharachteInWord.keySet());
		Object[] convertHashSetToObjArray = Assessment.convertHashSetToObjArray(hashSet);
		System.out.println("Hash Set Elements in Object Array");
		for (Object object : convertHashSetToObjArray) 
			System.out.print(object.toString()+" ");
		System.out.println();
		//Problem 6
		TreeMap<String, Integer> studentMarks = new TreeMap<>();
		studentMarks.put("Tamizh", 90);
		studentMarks.put("English", 90);
		studentMarks.put("Mathematics", 100);
		studentMarks.put("Science", 75);
		studentMarks.put("Social", 95);
		System.out.println("Maximum Marks: "+Assessment.findMaxInTreeMap(studentMarks));
		System.out.println("Minimum Marks: "+Assessment.findMinInTreeMap(studentMarks));
		//Problem 7
		List<String> stringList = new ArrayList<>();
		stringList.add("India");
		stringList.add("Zimbawe");
		stringList.add("America");
		stringList.add("NewZeland");
		stringList.add("Cannada");
		System.out.println("Array list Before Sorting: ");
		for (String string : stringList) {
			System.out.print(string +" ");
		}
		System.out.println();
		Collections.sort(stringList);
		System.out.println("Array list After Sorting: ");
		for (String string : stringList) {
			System.out.print(string +" ");
		}
		System.out.println();
		//Problem 8
		Hashtable<String, Integer> studentMarkList = new Hashtable<>();
		studentMarkList.put("Tamizh", 90);
		studentMarkList.put("English", 90);
		studentMarkList.put("Mathematics", 100);
		studentMarkList.put("Science", 75);
		studentMarkList.put("Social", 95);
		Set<String> keySet = studentMarkList.keySet();
		Iterator<String> iterator = keySet.iterator();
		System.out.println("Key Set using Iterator:");
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
		System.out.println("Key Set using Enumerator:");
		Enumeration<String> enumeration = studentMarkList.keys();
		while (enumeration.hasMoreElements()) {
			System.out.print(enumeration.nextElement()+" ");
		}
	}
}
