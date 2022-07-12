/*
There are a series of bulbs in which some bulbs are turned on(indicated by 1) 
and others are off(indicated by 0).
Return the count of sub-series of bulbs which are turned on.
for example:
1101 -> sub-series are 1,1,1(subseries of length-1),11(sub-series of length-2).
Total=4
Since the answer may be too large, return it modulo 10^9 + 7.
Note: input is given as a string.
 
Input Format:
-------------
Line-1: A string represents the status of series of bulbs.
Output Format:
--------------
return an integer
Sample Input-1:
---------------
11101
Sample Output-1:
----------------
7
Explanation:
------------
subseries are 1,1,1,1,11,11,111.
Sample Input-2:
---------------
101
Sample Output-2:
----------------
2
Explanation:
-------------
sub-series are: 1,1.
*/


import java.util.*;
class program{
    public static int work(String str){
        long count=0,ans=0;
        double mod=1e9+7;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                count++;
                ans+=count;
            }  
            else{
                count=0;
            }
        }
        return (int)(ans%mod);
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.print(work(str));
    }
}
