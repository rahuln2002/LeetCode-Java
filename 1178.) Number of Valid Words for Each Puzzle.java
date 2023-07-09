class Solution {
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            int mask = getBitmask(word);
            wordFrequency.put(mask, wordFrequency.getOrDefault(mask, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (String puzzle : puzzles) {
            int mask = getBitmask(puzzle);
            int firstCharMask = getBitmask(Character.toString(puzzle.charAt(0)));

            int numValidWords = 0;
            int subset = mask;
            while (subset > 0) {
                if ((subset & firstCharMask) == firstCharMask) {
                    numValidWords += wordFrequency.getOrDefault(subset, 0);
                }
                subset = (subset - 1) & mask;
            }

            result.add(numValidWords);
        }

        return result;
    }

    private static int getBitmask(String word) {
        int bitmask = 0;
        for (char ch : word.toCharArray()) {
            bitmask |= 1 << (ch - 'a');
        }
        return bitmask;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "pleas", "please"};
        String[] puzzles = {"aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy"};

        List<Integer> validWordsCount = findNumOfValidWords(words, puzzles);
        System.out.println(validWordsCount);
    }
}
/* Time Complexity: O(N * L + M * 2^L)
* Space Complexity: O(N + M)
*/
