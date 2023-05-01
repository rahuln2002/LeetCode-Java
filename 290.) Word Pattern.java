class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");
        if(pattern.length() != words.length) {
            return false;
        }
        Map<Character, Integer> charIndex = new HashMap<>();
        Map<String, Integer> stringIndex = new HashMap<>();

        for (Integer i = 0; i < pattern.length(); i++) {
            if (charIndex.put(pattern.charAt(i), i) != stringIndex.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(n)
*/
