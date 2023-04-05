class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        char[] s_new = s.toCharArray();
        if(length==0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<length;i++){
            if(s_new[i]=='(' || s_new[i]=='[' || s_new[i]=='{'){
                stack.push(s1[i]);
            }
            else if(!stack.empty() && s_new[i]==')' && stack.peek()=='('){
                stack.pop();
            }
            else if(!stack.empty() && s_new[i]==']' && stack.peek()=='['){
                stack.pop();
            }
            else if(!stack.empty() && s_new[i]=='}' && stack.peek()=='{'){
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.empty();
    }
}
