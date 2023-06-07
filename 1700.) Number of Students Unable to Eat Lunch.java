class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        Queue<Integer> sandwichQueue = new LinkedList<>();

        for (int student : students) {
            studentQueue.offer(student);
        }
        for (int sandwich : sandwiches) {
            sandwichQueue.offer(sandwich);
        }

        int consecutiveFails = 0;

        while (!studentQueue.isEmpty()) {
            if (studentQueue.peek().equals(sandwichQueue.peek())) {
                studentQueue.poll();
                sandwichQueue.poll();
                consecutiveFails = 0;
            }
            else {
                studentQueue.offer(studentQueue.poll());
                consecutiveFails++;
            }
            if (consecutiveFails == studentQueue.size()) {
                break;
            }
        }
        return studentQueue.size();
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(n)
*/
