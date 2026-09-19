package StringGroupAnagramsWords;

// Question:- Given an array of strings strs, group the anagrams together. You can return the answer in any order.

//  Example 1:
// ------------
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

//  Explanation:
// --------------
//There is no string in strs that can be rearranged to form "bat".
//The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
//The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

//  Example 2:
// ------------
//Input: strs = [""]
//Output: [[""]]
//  Example 3:
//  ------------
//Input: strs = ["a"]
//Output: [["a"]]
//Constraints:
//1 <= strs.length <= 104
//0 <= strs[i].length <= 100
//strs[i] consists of lowercase English letters.

// Brute force approach:-
// ------------------------------
// 1. Brute Force — Compare Every Pair
// Idea
// For every string, compare it with other strings and check whether they are anagrams.
// To check two strings:
// Convert to char[]
// Sort both arrays
// Compare them

//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteForceSolution {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        BruteForceSolution solution = new BruteForceSolution();
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (used[i]) {
                continue;
            }
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            used[i] = true;
            for (int j = i + 1; j < strs.length; j++) {

                if (!used[j] && isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    used[j] = true;
                }
            }
            result.add(group);
        }
        return result;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
}

