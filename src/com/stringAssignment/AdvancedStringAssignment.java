package com.stringAssignment;


	import java.util.*;

	public class AdvancedStringAssignment
	{

	    // Character Frequency
	    public static Map<Character, Integer> charFrequency(String str)
	    {
	        Map<Character, Integer> frequencyMap = new HashMap<>();
	        for (char c : str.toCharArray()) 
	        {
	            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
	        }
	        return frequencyMap;
	    }

	    // Palindrome Check
	    public static boolean isPalindrome(String str) 
	    {
	        String cleanedStr = str.replaceAll("\\s+", "").toLowerCase();
	        int left = 0, right = cleanedStr.length() - 1;
	        while (left < right)
	        {
	            if (cleanedStr.charAt(left) != cleanedStr.charAt(right))
	            {
	                return false;
	            }
	            left++;
	            right--;
	        }
	        return true;
	    }

	    // Anagram Check
	    public static boolean areAnagrams(String str1, String str2) 
	    {
	        String cleanedStr1 = str1.replaceAll("\\s+", "").toLowerCase();
	        String cleanedStr2 = str2.replaceAll("\\s+", "").toLowerCase();
	        if (cleanedStr1.length() != cleanedStr2.length())
	        {
	            return false;
	        }
	        char[] charArray1 = cleanedStr1.toCharArray();
	        char[] charArray2 = cleanedStr2.toCharArray();
	        Arrays.sort(charArray1);
	        Arrays.sort(charArray2);
	        return Arrays.equals(charArray1, charArray2);
	    }

	    // Longest Substring Without Repeating Characters
	    public static String longestUniqueSubstring(String str)
	    {
	        Map<Character, Integer> map = new HashMap<>();
	        int maxLength = 0, start = 0;
	        String longestSubstring = "";
	        for (int end = 0; end < str.length(); end++)
	        {
	            char c = str.charAt(end);
	            if (map.containsKey(c)) 
	            {
	                start = Math.max(start, map.get(c) + 1);
	            }
	            map.put(c, end);
	            if (end - start + 1 > maxLength)
	            {
	                maxLength = end - start + 1;
	                longestSubstring = str.substring(start, end + 1);
	            }
	        }
	        return longestSubstring;
	    }

	    // String Compression
	    public static String compressString(String str)
	    {
	        StringBuilder compressed = new StringBuilder();
	        int countConsecutive = 0;
	        for (int i = 0; i < str.length(); i++) 
	        {
	            countConsecutive++;
	            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) 
	            {
	                compressed.append(str.charAt(i)).append(countConsecutive);
	                countConsecutive = 0;
	            }
	        }
	        return compressed.length() < str.length() ? compressed.toString() : str;
	    }

	    // Find All Permutations of a String
	    public static List<String> findPermutations(String str)
	    {
	        List<String> result = new ArrayList<>();
	        permutations("", str, result);
	        return result;
	    }

	    private static void permutations(String prefix, String str, List<String> result)
	    {
	        int n = str.length();
	        if (n == 0) 
	        {
	            result.add(prefix);
	        } else 
	        {
	            for (int i = 0; i < n; i++)
	            {
	                permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), result);
	            }
	        }
	    }

	    // Remove Duplicates
	    public static String removeDuplicates(String str)
	    {
	        StringBuilder result = new StringBuilder();
	        Set<Character> seen = new HashSet<>();
	        for (char c : str.toCharArray())
	        {
	            if (!seen.contains(c)) 
	            {
	                seen.add(c);
	                result.append(c);
	            }
	        }
	        return result.toString();
	    }

	    // Reverse Words in a String
	    public static String reverseWords(String str)
	    {
	        String[] words = str.split("\\s+");
	        Collections.reverse(Arrays.asList(words));
	        return String.join(" ", words);
	    }

	    public static void main(String[] args) 
	    {
	        String testStr1 = "aabcccccaaa";
	        String testStr2 = "madam";
	        String testStr3 = "nagaram";
	        String testStr4 = "Hello World";
	        String testStr5 = "abcdabc";

	        System.out.println("Character Frequency: " + charFrequency(testStr1));
	        System.out.println("Is Palindrome: " + isPalindrome(testStr2));
	        System.out.println("Are Anagrams: " + areAnagrams(testStr2, testStr3));
	        System.out.println("Longest Unique Substring: " + longestUniqueSubstring(testStr5));
	        System.out.println("Compressed String: " + compressString(testStr1));
	        System.out.println("Find Permutations: " + findPermutations("abc"));
	        System.out.println("Remove Duplicates: " + removeDuplicates(testStr5));
	        System.out.println("Reverse Words: " + reverseWords(testStr4));
	    }
	}



