class Solution {
    public String reverseVowels(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('a',1);
        hm.put('e',1);
        hm.put('i',1);
        hm.put('o',1);
        hm.put('u',1);
        hm.put('A',1);
        hm.put('E',1);
        hm.put('I',1);
        hm.put('O',1);
        hm.put('U',1);
        int f = 0, b = s.length() - 1, count1 = 0, count2 = 0;
        char[] arr = s.toCharArray();
        char temp = 0;
        while (f < b) {
            if (!hm.containsKey(arr[f])) {
                f++;
            } else {
                count1++;
            }
            if (!hm.containsKey(arr[b])) {
                b--;
            } else {
                count2++;
            }
            if ((count1 > 0) && (count2 > 0)) {
                temp = arr[f];
                arr[f] = arr[b];
                arr[b] = temp;
                f++;
                b--;
                count1 = 0;
                count2 = 0;
            }
        }
        return String.valueOf(arr);
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(1)
*/
