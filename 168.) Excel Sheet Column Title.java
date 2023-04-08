class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            int mod = columnNumber % 26;
            columnNumber /= 26;
            result.append((char)(65+mod));
        }
        return result.reverse().toString();
    }
}
/* Time Complexity: O(logN)
* Space Complexity: O(1)
*/
