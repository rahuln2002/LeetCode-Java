class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        maxHeap.addAll(frequencyMap.keySet());

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int frequency = frequencyMap.get(c);
            for (int i = 0; i < frequency; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
/* Time Complexity: O(n log k)
* Space Complexity: O(k)
*/
