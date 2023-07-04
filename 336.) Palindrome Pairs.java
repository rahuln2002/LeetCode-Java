class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) {
            return result;
        }
        
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            if (isPalindrome(word) && wordMap.containsKey("")) {
                int emptyIndex = wordMap.get("");
                if (emptyIndex != i) {
                    result.add(List.of(i, emptyIndex));
                    result.add(List.of(emptyIndex, i));
                }
            }
            
            String reversed = new StringBuilder(word).reverse().toString();
            if (wordMap.containsKey(reversed)) {
                int reverseIndex = wordMap.get(reversed);
                if (reverseIndex != i) {
                    result.add(List.of(i, reverseIndex));
                }
            }
            
            for (int j = 1; j < word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                
                if (isPalindrome(left)) {
                    String reversedRight = new StringBuilder(right).reverse().toString();
                    if (wordMap.containsKey(reversedRight)) {
                        int reverseRightIndex = wordMap.get(reversedRight);
                        if (reverseRightIndex != i) {
                            result.add(List.of(reverseRightIndex, i));
                        }
                    }
                }
                
                if (isPalindrome(right)) {
                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if (wordMap.containsKey(reversedLeft)) {
                        int reverseLeftIndex = wordMap.get(reversedLeft);
                        if (reverseLeftIndex != i) {
                            result.add(List.of(i, reverseLeftIndex));
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;
        
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
}
/* Time Complexity: O(n*k)
* Space Complexity: O(n*k^2)
*/
