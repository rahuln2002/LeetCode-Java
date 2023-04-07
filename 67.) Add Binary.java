class Solution {
    public String addBinary(String a, String b) {
        String sum="";
        int len_a = a.length()-1;
        int len_b = b.length()-1;
        String carry = "0";

        if(len_a < len_b) {
            StringBuilder a1=new StringBuilder(a);
            a1.reverse();
            String a2 = a1.toString();
            for(int i=0;i<len_b-len_a;i++) {
                a2 += "0";
            }
            StringBuilder a3=new StringBuilder(a2);
            len_a = len_b;
            a3.reverse();
            a = a3.toString();
            System.out.println(a);
        }
        else if(len_a > len_b) {
            StringBuilder b1=new StringBuilder(b);
            b1.reverse();
            String b2 = b1.toString();
            for(int i=0;i<len_a-len_b;i++) {
                b2 += "0";
            }
            len_b = len_a;
            StringBuilder b3=new StringBuilder(b2);
            b3.reverse();
            b = b3.toString();
            System.out.println(b);
        }
        while(len_a >= 0 && len_b >= 0) {
            if(a.charAt(len_a) == '1' && b.charAt(len_b) == '1' && carry.equals("0")){
                sum += "0";
                carry = "1";
            }
            else if(a.charAt(len_a) == '1' && b.charAt(len_b) == '1' && carry.equals("1")){
                sum += "1";
                carry = "1";
            }
            else if(a.charAt(len_a) == '0' && b.charAt(len_b) == '0' && carry.equals("0")){
                sum += "0";
                carry = "0";
            }
            else if(a.charAt(len_a) == '0' && b.charAt(len_b) == '0' && carry.equals("1")){
                sum += "1";
                carry = "0";
            }
            else if(((a.charAt(len_a) == '0' && b.charAt(len_b) == '1') || (a.charAt(len_a) == '1' && b.charAt(len_b) == '0')) && carry.equals("0")) {
                sum += "1";
                carry = "0";
            }
            else {
                sum += "0";
                carry = "1";
            }
            len_a--;
            len_b--;
        }
        if(carry.equals("1")) {
            sum += carry;
        }
        StringBuilder sb=new StringBuilder(sum);  
        sb.reverse();  
        return sb.toString();
    }
}
