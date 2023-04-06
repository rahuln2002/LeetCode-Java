class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length-1;
        while(n>=0 && digits[n]==9) {
            n--;
        }
        if(n==-1) {
            int[] a=new int[digits.length+1];
            a[0] = 1;
            return a;
        }
        int[] a=new int[digits.length];
        
        a[n] = digits[n] + 1;
        for (int m = 0; m < n; m++) {
            a[m] = digits[m];
        }
        
        return a;
    }
}
