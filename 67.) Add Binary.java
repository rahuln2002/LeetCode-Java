class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        int check = 0;
        char charA = '0';
        char charB = '0';
        int len_a = a.length() - 1;
        int len_b = b.length() - 1;
        while (len_a >= 0 || len_b >= 0) {
            if(len_a >= 0){
                charA = a.charAt(len_a);
            }else{
                charA = '0';
            }
            if(len_b >= 0){
                charB = b.charAt(len_b);
            }else{
                charB = '0';
            }
            check = (charA - '0') + (charB - '0') + carry;
            if (check == 2) {
                sum = sum.append("0");
                carry = 1;
            } else if (check == 3) {
                sum = sum.append("1");
                carry = 1;
            } else if (check == 1) {
                sum = sum.append("1");
                carry = 0;
            } else {
                sum = sum.append("0");
                carry = 0;
            }
            len_a--;
            len_b--;
        }
        if (carry == 1) {
            sum = sum.append("1");
        }
        return sum.reverse().toString();

    }
}
