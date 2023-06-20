class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char task : tasks) {
            frequencyMap.put(task, frequencyMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(frequencyMap.values());

        int cycles = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    int count = maxHeap.poll();
                    if (count > 1) {
                        temp.add(count - 1);
                    }
                }
                cycles++;
                if (maxHeap.isEmpty() && temp.isEmpty()) {
                    break;
                }
            }

            maxHeap.addAll(temp);
        }

        return cycles;
    }
}
/* Time Complexity: O(n log n)
* Space Complexity: O(n)
*/
