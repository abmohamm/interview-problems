package com.app.samples;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		//printFizzBuzz(100);
		//int[] numbers = new int[] {9,7,10,9,1,2,3,1,2,3,4};
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
		String second = "reverse with string builder";
		boolean result = checkAnagramWithList(first, second);
		System.out.print("Is Anagram ? "+result);
	}

	private static boolean checkAnagram(String first,String second) {
		boolean isAnagram;
		if(first.length() != second.length()){
			isAnagram = false;
		}
		else {
			first = first.replaceAll("\\s", "");
			second = second.replaceAll("\\s", "");
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
	
	public static int[] removeDuplicatesFromArray(int[] arr) {
		Map<Object,Object> map = new HashMap<Object,Object>();
		int num=1;	
		int counter = 0;
		for(int i=0;i<arr.length;i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i],num);
				counter++;
			}
			else {
				int count = (Integer) map.get(arr[i]);
				map.put(arr[i], count+1);
			}
		}
		int[] newArray = new int[counter];
		int i = 0;
		for(Map.Entry<Object, Object> mapEntry : map.entrySet()) {
			newArray[i] = (Integer) mapEntry.getKey();
			i++;
		}	
		return newArray;
	}

	public static int[] reverseArray(int[] arr) {
		int[] input = new int[arr.length];
		int length = arr.length;

		for(int i=length-1;i>=0;i--) {
			input[length-i-1] = arr[i];
		}
		return input;		
	}

	private static int[] reverseArrayWithoutOther(int[] input,int start,int end) {
		int temp = 0;	
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