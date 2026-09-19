package StringGroupAnagramsWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalSolution {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        OptimalSolution solution = new OptimalSolution();
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                key.append('#');
                key.append(count[i]);
            }
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>())
                    .add(str);
        }
        return new ArrayList<>(map.values());
    }
}
