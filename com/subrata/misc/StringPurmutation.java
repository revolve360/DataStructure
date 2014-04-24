package com.subrata.misc;

import java.util.ArrayList;

/**
 * 
 * @author subratas
 *
 */
public class StringPurmutation {

	public static void main(String[] args) {
		String string ="abc";
		ArrayList<String> perm = getPermutaion(string);
		StringBuilder sb = new StringBuilder();
		for(String perString : perm ){
			if(sb.length() > 0){
				sb.append("->");
			}
			sb.append(perString);
		}
		System.out.println("*************** Subrata permutaion of ::"+string+" is :: "+sb.toString());
	}
	
	/**
	 * time O(n!)
	 * @param string
	 * @return
	 */
	public static ArrayList<String> getPermutaion(String string){
		if(string == null){
			return null;
		}
		
		ArrayList<String> permution = new ArrayList<String>();
		if(string.length() == 0){
			permution.add("");
			return permution;
		}
		
		char first = string.charAt(0);
		String remainder = string.substring(1);
		
		ArrayList<String> words = getPermutaion(remainder);
		for(String word : words){
			for(int j=0;j<= word.length();j++){
				String s = insertAtAllPossibleSpot(word,first,j);
				permution.add(s);
			}
		}
		return permution;
	}

	private static String insertAtAllPossibleSpot(String word, char first, int j) {
		String start = word.substring(0,j);
		String end = word.substring(j);
		return start + first + end;
	}
	
	
}
