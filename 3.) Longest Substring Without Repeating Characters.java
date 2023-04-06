class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result=0;
        ArrayList < Character > dup = new ArrayList();
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(dup.contains(s.charAt(j))) {
                    dup.clear();
                    break;
                }
                else {
                    dup.add(s.charAt(j));
                    if (result < j - i + 1) {
                        result = j - i + 1;
                    }
                }
            }
        }
        return result;
    }
}
