class Solution {
    public String longestCommonPrefix(String[] strs) {
        int LCP = 0;
        for(int i=0;i<strs[0].length();i++){
            int found = 1;
            for(int j=0;j<strs.length;j++){
                if(LCP>=strs[j].length() || strs[j].charAt(LCP)!=strs[0].charAt(LCP)){
                    found = 0;
                    break;
                }
            }
            if(found==1){
                LCP++;
            }
            else{
                break;
            }
        }
        return strs[0].substring(0,LCP);
    }
}
