/*Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n. If there are no two adjacent 1's, return 0.

Two 1's are adjacent if there are only 0's separating them (possibly no 0's).
The distance between two 1's is the absolute difference between their bit positions.

For example, the two 1's in "1001" have a distance of 3.

 
input = 22
output = 2

Explanation: 22 in binary is "10110".
The first adjacent pair of 1's is "10110" with a distance of 2.
The second adjacent pair of 1's is "10110" with a distance of 1.
The answer is the largest of these two distances, which is 2.
Note that "10110" first 1 and third 1 is not a valid pair since there is a 1 separating the two 1's.


input == 8
output = 0
Explanation: 8 in binary is "1000".
There are not any adjacent pairs of 1's in the binary representation of 8, so we return 0.


Example 3:
input = 5
output = 2

Explanation: 5 in binary is "101".
*/
                                                            
import java.util.*;

public class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        bin(Integer.toBinaryString(n));
    }
    public static void bin(String b){
        int count = 0;
        
        List<Integer> li = new ArrayList<>();
        for(int i = 0;i<b.length();i++){
            
            if(b.charAt(i) == '0' && count>0){
                count++;
            }
            if(b.charAt(i) == '1' && count>0){
                li.add(count);
                count = 1;
            }
            if(b.charAt(i) == '1'&&count==0){
                 count = 1;
            }
            
        }
        if(li.size()>0){
            System.out.println(Collections.max(li));
        }
        else{
            System.out.println("0");
        }
        
    }
}
