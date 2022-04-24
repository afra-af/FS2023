/*
Somesh is working on Number Strings.
He got an idea to find the smallest possible number by 
deleting some digits from the number without changing 
the relative order of digits in it.

You will be given a integer String 'num', and an integer n.
Find the smallest number possible after deleting n digits from 'num'.

Note: If the number string 'num' turns to empty, print 0.

Input Format:
-------------
Line-1 : A string num, consist of digits only.
Line-2 : An integer n, number of digits to delete.

Output Format:
--------------
Print the smallest possible number.


Sample Input-1:
---------------
1432219
3

Sample Output-1:
----------------
1219

Explanation: 
------------
Delete the three digits 4, 3, and 2 to form the smallest number 1219.


Sample Input-2:
---------------
10200
1

Sample Output-2:
----------------
200

Explanation:
------------
Delete the leading 1 and the smallest number is 200. 
Note that the output must not contain leading zeroes.

*/
import java.util.*;
class Solution {
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       String n=sc.nextLine();
       int q=sc.nextInt();
    System.out.println(removeKdigits(n,q));
    }
     static String removeKdigits(String num, int k) {
        int n = num.length();
        StringBuilder res = new StringBuilder();
        
        for(int i = 0 ; i < n ; i++){
            while(k > 0 && res.length() > 0 && res.charAt(res.length()-1) > num.charAt(i)){
                k--;
                res.deleteCharAt(res.length()-1);
            }
            res.append(num.charAt(i));
        }
       
        while(k > 0 && res.length() > 0){
            res.deleteCharAt(res.length()-1);
            k--;                
        }      
        
        int idx = 0;
        while(idx < res.length() && res.charAt(idx) == '0') idx++;
        if(idx == res.length()) return "0";
        return res.toString().substring(idx);
      
    }

}
