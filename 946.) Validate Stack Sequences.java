class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int m = pushed.length;
        int n = popped.length;
        Stack<Integer> stack=new Stack<Integer>();
        int j=0;
        for(int i=0; i<n; i++) {
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
/* Time Complexity: O(N)
* Space Complexity: O(N)
*/
