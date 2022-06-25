/*
Ravi is playing with strings,help him to find sum of the difference in frequencies between the most frequent and least frequent characters in all it's substrings.
input =aabcb
output =5
Explanation:
for aabcb 
the substrings are 
with length 1 => a a b c b  =>  in each substring max and min is 1 so 1-1 =0
with length 2 => aa ab bc cb => in each substring max and min is 1-1 =0
with length 3 => aab abc bcb => 
	for aab=> 2-1 =1
	for abc=> 1-1 =0
	for bcb=> 2-1 =1
with length 4 => aabc abcb
	for aabc => 2-1 =1
	for abcb => 2-1 =1
with length 5 => aabcb
	for aabcb => 2-1 =1
so total sum of difference of most frequent to least frequent is 
1+1+1+1+1=5
input =aabcbaa
output =17
*/
import java.util.*;
class Test{
    public static int count_frequencies(String s,int n){
        int count=0;
        for(int i=0;i<n;i++){
        int freq[]=new int[26];
           for(int j=i;j<n;j++){
           char temp=s.charAt(j);
           freq[temp-'a']++;
           int min=Integer.MAX_VALUE;
           int max=Integer.MIN_VALUE;
           
               for(int val:freq){
                   if(val!=0){
                       min=Math.min(min,val);
                       max=Math.max(max,val);
                   }
               }
               if(max-min!=0){
                   count+=(max-min);
               }
           }
        }
        return count;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        System.out.print(count_frequencies(s,n));
    }
}
