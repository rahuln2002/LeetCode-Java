class Solution {
    public boolean isPalindrome(int x) {
        int num=x, rev=0, rem;
        if(x<0) {
            return false;
        }
        while (num != 0) {
            rem = num % 10;
            rev = rev * 10 + rem;
            num /= 10;
        }
        return rev == x;
    }
}
