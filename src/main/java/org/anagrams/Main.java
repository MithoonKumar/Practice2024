package org.anagrams;

import java.util.*;

public class Main {

    // Helper function to sort the characters in a word
    private static String sortString(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // Function to count anagrams for each query
    public static List<Integer> countAnagrams(String[] words, String[] queries) {
        // Map to store the count of each sorted word (anagram group)
        Map<String, Integer> anagramMap = new HashMap<>();

        // Populate the map with the words
        for (String word : words) {
            String sortedWord = sortString(word);
            anagramMap.put(sortedWord, anagramMap.getOrDefault(sortedWord, 0) + 1);
        }

        // List to store results for each query
        List<Integer> results = new ArrayList<>();

        // For each query, find how many words match the sorted version
        for (String query : queries) {
            String sortedQuery = sortString(query);
            results.add(anagramMap.getOrDefault(sortedQuery, 0));
        }

        return results;
    }

    public static void main(String[] args) {
        // Example usage
        String[] words = {"listen", "silent", "enlist", "inlets", "google", "googgle"};
        String[] queries = {"listen", "google", "netsli", "cat"};

        List<Integer> anagramCounts = countAnagrams(words, queries);

        // Print the results
        for (int count : anagramCounts) {
            System.out.println(count);
        }
    }
}
