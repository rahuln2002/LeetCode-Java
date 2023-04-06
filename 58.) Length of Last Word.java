class Solution {
    public int lengthOfLastWord(String s) {
        s = s.strip();
        String last_word=s.substring(s.lastIndexOf(" ")+1);
        return last_word.length();
    }
}
