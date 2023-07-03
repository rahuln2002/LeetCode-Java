class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, wordDict, new HashMap<>());
    }
    private List<String> wordBreakHelper(String s, List<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            result.add("");
            return result;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subStrings = wordBreakHelper(s.substring(word.length()), wordDict, memo);
                for (String subString : subStrings) {
                    String space = subString.isEmpty() ? "" : " ";
                    result.add(word + space + subString);
                }
            }
        }
        memo.put(s, result);
        return result;
    }
}
/* Time Complexity: O(n*m)
* Space Complexity: O(n^2)
*/
