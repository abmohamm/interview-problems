package com.app.samples;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	Logger logger = LoggerFactory.getLogger(App.class);
	public static void main( String[] args )
	{
		moveZeroes(new int[] {12, 0, 7, 0, 8, 0, 3});
		//reverseEachWord("Java Concept Of The Day");
//		String[] s1 = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "FOUR"};		 
//		String[] s2 = {"THREE", "FOUR", "FIVE", "SIX", "SEVEN", "FOUR"};
//		Set<String> common =  getCommonElementsFromArray(s1, s2);

		//System.out.println("Common Elements are : ");
//		for(String str : common) {
//			System.out.println(str+",");
//		}
		//List<String> common = checkCommonElementsOfArray(s1, s2);
		//stringRotationCheck("JavaJ2eeStrutsHibernate","StrutsHibernateJavaJ2ee");
		//reverseString("Ab,c,de!$");
		//findPair(new int[]{4, 5, 7, 11, 9, 13, 8, 12}, 20);
		//countCharacterOccurence("Java J2EE Java JSP J2EE");
		//findSum(7456);
		//findDuplicateChars("Better Butter");//Fresh Fish		
		//printFizzBuzz(100);
		//		int[] numbers = new int[] {9,7,10,9,1,2,3,1,2,3,4};
		//	pattern1(5);
		//int[] uniqueArr = removeDuplicatesFromArray(numbers);
		//System.out.print(uniqueArr[0]);
		//9 for Blue,1 for Green,2 for violet,3 for Red
		//int[] balls = new int[] {9,1,2,3,9,1,2,3};
		//returnSameKind(balls,9);
		//removeDuplicatesFromArray(numbers);
		//		    	int[] result = reverseArrayWithoutOther(numbers, 0, numbers.length-1);//reverseArray(numbers);
		//		    	System.out.print("Array Numbers : "+result[0]);
		//    	int target = 7;
		//    	checkTwoSum(numbers,target);
		//String reversed = reverseManually("reversewithstringbuilder");
		//String unique = removeDuplicates("reversewithstringbuilder");
		//System.out.println("unique char sequece : "+unique);
		//		boolean isPrime = isPrime(10);
		//		System.out.print("Is Prime? : "+isPrime);
		//		int first = 10;
		//		int second = 20;
		//		swapTwoNumbers(first, second);

				String first = "reverse with string builder";
				duplicateRemoval(first);
		//		String second = "reverse with string builder";
		//		boolean result = checkAnagramWithList(first, second);
		//		System.out.print("Is Anagram ? "+result);
		//		String input = "It describes how different objects and classes send messages to each other to make things "
		//				+ "happen and how the steps of a task are divided among different objects";
		//		withoutSpaces(input);
		//		countEachWord(input);
	}
	
	//write a method to remove duplicates of a string
	public static String duplicateRemoval(String str) {
		StringBuilder builder = new StringBuilder();
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(builder.toString().indexOf(ch) == -1) {
				builder.append(ch);				
			}
		}
		
		String unique =  builder.toString();		
		return unique;
	}
	
	public static int[] moveZeroes(int arr[]) {
		int[] newArray = new int[arr.length];
		int countNonZeroes = 0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] != 0) {
				newArray[countNonZeroes] = arr[i];
				countNonZeroes++;
			}
		}
		
		while(countNonZeroes < arr.length) {
			newArray[countNonZeroes] = 0;
			countNonZeroes++;
		}	
		
		return newArray;		
	}
	
	//reverse each word in a string manually and then return the string
	public static String reverseEachWord(String input) {
		String[] arr = input.split(" ");
		StringBuilder builder = new StringBuilder();
	
		for(String str : arr) {
			builder.append(reverseManually(str)+" ");
		}	
		String result = builder.toString();
		return result;
		
	}

	//find common elements in an array
	public static Set<String> getCommonElementsFromArray(String[] arr1,String[] arr2){
		Set<String> common = new HashSet<String>();
		if(arr1.length == 0 && arr2.length == 0) {
			common.add("given strings are empty");
		}
		else {
			for(int i=0;i<arr1.length;i++) {
				for(int j=0;j<arr2.length;j++) {
					if(arr1[i].equals(arr2[j])) {
						common.add(arr1[i]);
					}
				}
			}
		}
		return common;
	}

	//	public static List<String> checkCommonElementsOfArray(String[] arr1,String[] arr2) {
	//		List<String> commonElements = new ArrayList<String>();
	//		if(arr1.length == 0 && arr2.length == 0) {
	//			return null;
	//		}
	//		else {
	//			for(String str : arr1) {
	//				commonElements.add(str);
	//			}
	//			
	//			//if any element of arr2 is not present in commonElements then 
	//			for(String str1 : arr2) {
	//				if(commonElements.contains(str1)) {
	//					System.out.println(str1+",");
	//				}
	//			}
	//		}		
	//		return commonElements;
	//	}

	//check string rotation
	public static boolean stringRotationCheck(String str1,String str2) {
		boolean isIt = false;
		String res = null;

		if(str1.length() != str2.length()) {
			return isIt;
		}
		else {
			res = str1+str1;
			if(res.contains(str2)) {
				isIt = true;
			}
		}
		return isIt;
	}

	//find pair of elements in an array which adds to given number
	public static void findPair(int[] arr,int number) {		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j] == number) {
					System.out.println(arr[i]+" and "+arr[j]+" adds to "+number);
				}
			}
		}
	}


	//find largest number less than given number without the given digit
	public static int findNumLessThanGivenNumberWithoutDigit(int num,int digit) {
		int lesser = 0;
		//convert digit to char
		char ch = Integer.toString(digit).charAt(0);

		for(int i=num;i>=0;i--) {
			if(Integer.toString(i).indexOf(ch) == -1) {
				lesser = i;
				return lesser;
			}
		}
		return -1;
	}

	//count occurences of each character in a String
	public static void countCharacterOccurence(String input) {
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		int one=1;
		int count=0;
		char ch=' ';
		if(input != null) {
			for(int i=0;i<input.length();i++) {
				ch = input.charAt(i);
				if(!map.containsKey(ch)) {
					map.put(ch, one);					
				}
				else {
					count = map.get(ch);
					map.put(ch, count+1);					
				}
			}			
			for(Map.Entry<Character, Integer> entry : map.entrySet()) {
				System.out.print(entry.getKey()+" is present "+entry.getValue()+" times ");
			}
		}
		else {
			System.out.println("given string is emnpty");
		}
	}

	//print second largest number
	private static void printSecHighestElement(int arr[]) {
		int largest = arr[0];
		int secLargest = arr[0];

		for(int i=0;i<arr.length;i++) {
			if(arr[i]>largest) {
				secLargest = largest;
				largest = arr[i];				
			}
			else if(arr[i] > secLargest && arr[i] != largest) {
				secLargest = arr[i];
			}
		}
	}	

	//find sum of digits of a numer
	public static void findSum(int number) {
		int sum = 0;
		int reminder = 0;

		while(number > 0) {
			reminder = number % 10;
			sum = sum+reminder;
			number = number/10;			
		}

		System.out.print("Sum is : "+sum);
	}

	//check Armstrong number
	public static void checkArmstrong(int num) {
		int result = 0;
		int reminder = 0;

		//get the number of digits in a number
		int noOfDigits = String.valueOf(num).length();

		while(num > 0) {
			reminder = num % 10;	
			int lastDigit = 1;
			for(int i=0;i<noOfDigits;i++) {
				lastDigit = lastDigit*reminder;
			}
			result = result+lastDigit;			
		}
	}

	//find duplicate characters in a given string
	public static void findDuplicateChars(String input) {
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		int one = 1;	
		int count = 0;
		for(char ch : input.toCharArray()) {
			if(!map.containsKey(ch)) {
				map.put(ch, one);				
			}
			else {
				count = map.get(ch);
				map.put(ch, count+1);
			}
		}

		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() != 1) {
				System.out.println(entry.getKey()+" is present "+entry.getValue()+" times ");
			}
		}		
	}

	//check for equality of two arrays
	public static void compareTwoArrays(int[] first, int[] second) {
		boolean isEqual = false;
		//first sort the two arrays
		first = sortArray(first);
		second = sortArray(second);

		if(first.length == second.length) {
			for(int i=0;i<first.length;i++) {
				if(first[i] == second[i]) {
					isEqual = true;					
				}
			}
		}
		else {
			isEqual = false;
		}

		if(isEqual) {
			System.out.println("Arrays are equal");
		}
		else {
			System.out.println("Arrays are not equal");
		}
	}

	//find the longest string in a given string array
	public static void findLargestString(String[] arr) {
		int maxLength = 0;
		int length = 0;
		String longestString = null;
		for(String str : arr) {
			length = str.length();
			if(length >= maxLength) {
				maxLength = length;
				longestString = str;				
			}
		}
		System.out.println("Longest String is : "+longestString);
	}

	public  static int[] sortArray(int[] arr) {
		int temp = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;					
				}
			}
		}
		return arr;
	}


	//         1
	//        2 2
	//       3 3 3
	//      4 4 4 4
	private static void pattern1(int noOfRows) {
		int row = 1;		
		for(int i=noOfRows;i>0;i--) {
//			for(int j=1;j<=row;j++) {
//				System.out.print(row+" ");
//			}
			for(int j=1;j<=i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=row;j++) {
				System.out.print(row+" ");
				//System.out.print(j+" ");
			}
			row++;
			System.out.println();			
		}
	}

	public static String withoutSpaces(String str) {
		StringTokenizer tokenizer = new StringTokenizer(str," ");
		StringBuilder builder = new StringBuilder();
		while(tokenizer.hasMoreTokens()) {
			builder.append(tokenizer.nextToken());
		}
		String result = builder.toString();
		return result;
	}

	public static int[] removeDuplicatesFromArray(int[] arr) {
		int[] unique = {};
		int temp = 0;
		int uniqueLength = 0;

		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;					
				}
			}
		}

		//arr is sorted arr
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == arr[i+1]) {
				uniqueLength = uniqueLength+1;
			}
		}

		unique = new int[arr.length-uniqueLength];

		for(int i=0;i<arr.length;i++) {
			if(arr[i] != 0) {
				unique[i] = arr[i];
			}
		}		
		return unique;
	}

	public static void countEachWord(String input) {
		String[] arr = null;
		int count = 0;
		int num = 1;
		Map<String,Integer> map = new HashMap<String, Integer>();
		if(input != null) {
			arr = input.toLowerCase().split(" ");
		}
		for(String s : arr) {
			if(!map.containsKey(s)) {
				map.put(s, num);
			}
			else {
				count = map.get(s);
				map.put(s, count+1);
			}
		}
		for(Map.Entry<String, Integer> mapEntry : map.entrySet()) {
			System.out.println(mapEntry.getKey()+" is present "+mapEntry.getValue()+" times ");
		} 		
	}

	public static Object[] returnSameKind(int[] arr,int kind) {
		List<Integer> same = new ArrayList<Integer>();
		Object[] sameKind = null;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == kind) {
				same.add(arr[i]);
			}
		}
		sameKind = same.toArray();
		return sameKind;
	}

	private static boolean checkAnagram(String first,String second) {
		boolean isAnagram;
		first = first.replaceAll("\\s", "");
		second = second.replaceAll("\\s", "");
		if(first.length() != second.length()){
			isAnagram = false;
		}
		else {
			char[] firstArr = first.toLowerCase().toCharArray();
			char[] secArr = second.toLowerCase().toCharArray();
			Arrays.sort(firstArr);
			Arrays.sort(secArr);
			isAnagram = Arrays.equals(firstArr, secArr);			
		}		
		return isAnagram;
	}

	private static boolean checkAnagramWithList(String first,String second) {
		boolean isAnagram = false;
		List<Character> characters = new ArrayList<Character>();
		first = first.toLowerCase();
		second = second.toLowerCase();
		if(first.length() != second.length()) {
			isAnagram = false;			
		}
		else {
			for(int i=0;i<first.length();i++) {
				characters.add(first.charAt(i));
			}			
			for(int i=0;i<second.length();i++) {
				if(second.contains(Character.toString(second.charAt(i)))) {
					isAnagram = false;
				}
				else {
					isAnagram = true;
				}
			}
		}
		return isAnagram;
	}

	//	public static int[] removeDuplicatesFromArray(int[] arr) {
	//		Map<Object,Object> map = new HashMap<Object,Object>();
	//		int num=1;	
	//		int counter = 0;
	//		for(int i=0;i<arr.length;i++) {
	//			if(!map.containsKey(arr[i])) {
	//				map.put(arr[i],num);
	//				counter++;
	//			}
	//			else {
	//				int count = (Integer) map.get(arr[i]);
	//				map.put(arr[i], count+1);
	//			}
	//		}
	//		int[] newArray = new int[counter];
	//		int i = 0;
	//		for(Map.Entry<Object, Object> mapEntry : map.entrySet()) {
	//			newArray[i] = (Integer) mapEntry.getKey();
	//			i++;
	//		}	
	//		return newArray;
	//	}

	public static int[] reverseArray(int[] arr) {
		int[] input = new int[arr.length];
		int length = arr.length;

		for(int i=length-1;i>=0;i--) {
			input[length-i-1] = arr[i];
		}
		return input;		
	}

	private static int[] reverseArrayWithoutOther(int[] input) {
		int temp = 0;	
		int start = 0;
		int end = input.length;
		System.out.print("Input Array elements are : ");
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+",");
		}
		while(start < end) {
			temp = input[start];
			input[start] = input[end];
			input[end] = temp;
			start++;
			end--;
		}	
		System.out.println();
		System.out.print("Output Array elements are : ");
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+",");
		}
		return input;
	}

	public static boolean isPrime(int n) {
		boolean isPrime = false;
		int counter = 0;
		for(int i=1;i<=n;i++) {
			if(n%i == 0) {
				counter++;
			}
		}
		if(counter == 2) {
			isPrime = true;
		}
		return isPrime;
	}

	public static void printFizzBuzz(int n) {

		for(int i=1;i<=n;i++) {
			if((i%3 == 0) && (i%5 == 0)) {
				System.out.println("FizzBuzz");
			}
			else if(i%3 == 0) {
				System.out.println("Fizz");
			}
			else if(i%5 == 0) {
				System.out.println("Buzz");
			}
			else {
				System.out.println(" "+i);
			}
		}
	}

	public static int[] checkTwoSum(int[] arr,int target) {
		Map<Integer,Integer> visited = new HashMap<Integer, Integer>();    	
		for(int i=0;i<arr.length;i++) {
			int delta = target-arr[i];
			if(visited.containsKey(delta)) {
				return new int[] {i,visited.get(delta)};
			}
			visited.put(arr[i],i);    		
		}    	
		return new int[] {-1,-1};
	}

	@SuppressWarnings("unused")
	private static String reverseManually(String str) {
		StringBuilder builder = new StringBuilder();
		if(str != null) {
			for(int i=str.length()-1;i>=0;i--) {
				builder.append(str.charAt(i));
			}    		
		}
		return builder.toString();
	}

	private static String removeDuplicates(String input) {
		StringBuilder builder = new StringBuilder();

		if(input != null) {
			for(int i=0;i<input.length();i++) {
				String ch = String.valueOf(input.charAt(i));
				if(!builder.toString().contains(ch)) {
					builder.append(ch);
				}
			}
		}
		return builder.toString();
	}

	public static void swapTwoNumbers(int first,int second) {
		first = first+second; 
		second = first-second;
		first = first-second;		
	}

	// code goes here

	@SuppressWarnings("unused")
	public static String reverseString(String input){ //"Ab,c,de!$"
		char[] arr = new char[input.length()];
		StringBuilder builder = new StringBuilder();
		if(input == null){
			System.out.println("string is empty");
		}
		else{
			arr = reverseCharArray(input.toCharArray());
		}

		for(char ch1: arr){
			builder.append(ch1);
		}    
		return builder.toString();    
	}

	public static char[] reverseCharArray(char[] str){
		int arrLength = str.length-1;
		int length = 0;
		char temp = ' '; 

		while(length<arrLength){
			if(!Character.isAlphabetic(str[length])){
				length++;
			}
			else if(!Character.isAlphabetic(str[arrLength])){
				arrLength--;
			}
			else{
				temp = str[length];
				str[length] = str[arrLength];
				str[arrLength] = temp;
				length++;
				arrLength--;
			}
		}
		return str;
	}

}

class Stack{
	private int[] arr;
	private int top;
	private int capacity;

	Stack(int capacity){
		this.arr = new int[capacity];
		this.capacity = capacity;
		this.top = -1;
	}

	public void push(int item) {
		if(!isFull()) {
			arr[++top] = item;
		}
		else {
			throw new ArrayIndexOutOfBoundsException("stack is full");
		}		
	}

	public int pop() {
		int item = 0;
		if(!isEmpty()) {
			item =  arr[top--];
		}		
		else {
			throw new ArrayIndexOutOfBoundsException("stack is empty");
		}
		return item;
	}

	public int peek() {
		int item = 0;
		if(isEmpty()) {
			item = arr[top];
		}
		else {
			throw new ArrayIndexOutOfBoundsException("stack is empty");
		}
		return item;		
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == capacity-1;
	}
}