/*
Given a number in binary format return the number of substrings in binary format with all characters 1's 
input =0110111
output =9
there are 9 substring in total with only 1's characters.
1-> 5 times
11-> 3 times
111 -> 1 time
5 + 3+ 1=9
input =101
output=2
there are 2 substrings 1 is shown 2 times 
input =111111
output =21
each substring contains only 1's characters
*/
import java.util.*;
class program{
    public static int helper(String s){
        int count=0,res=0,mod=1000000007;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count+=1;
            }
            else{
                count=0;
            }
            res=(res+count)%mod;
        }
        return res;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.print(helper(s));
    }
}
