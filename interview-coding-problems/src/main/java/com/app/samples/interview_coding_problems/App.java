package com.app.samples.interview_coding_problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		//printFizzBuzz(100);
		//    	int[] numbers = new int[] {2,3,4,7,8};
		//    	int target = 7;
		//    	checkTwoSum(numbers,target);
		//String reversed = reverseManually("reversewithstringbuilder");
		String unique = removeDuplicates("reversewithstringbuilder");
		System.out.println("unique char sequece : "+unique);

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