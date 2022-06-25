/*
Ravi is playing with string, return the number of similar substrings of s.
similar substring means if all the characters of the substrings are the same
example:
input = bccdddbb
Explanation: The similar substrings are listed as below:
"b"   appears 3 times.
"bb"  appears 1 time.
"c"   appears 2 times.
"cc"  appears 1 time.
"d"   appears 3 times.
"dd"  appears 2 times.
"ddd" appears 1 time.
3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
output =13
input =ab
output =2
similar substrings are a and b
input =sssss
output =15
Note: answer may be too large, return it modulo 10^9+7
*/
import java.util.*;
class program{
    public static int sum_of_rep_char(String s){
        int res=0,count=0,mod=100000007;
        for(int i=0;i<s.length();i++){
            if(i>0&&s.charAt(i-1)==s.charAt(i)){
                ++count;
            }
            else{
                count=1;
            }
            res=(res+count)%mod;
        }
        return res;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.print(sum_of_rep_char(s));
    }
}
