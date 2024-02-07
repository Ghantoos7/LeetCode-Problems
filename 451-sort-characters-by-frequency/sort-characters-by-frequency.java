public class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> chars = new HashMap<>();
        for (char c : s.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }
        
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(chars.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }
        
        return result.toString();
    }
}
