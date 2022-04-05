/*Shyam is playing with group of characters, where the group of characters contain only A/B.

He has to return the count of non-empty substrings from this group which will have the same number of
A's and B's and all the A's and all the B's in these substrings are grouped consecutively

Substrings that occur multiple times are counted the number of times they occur.

 
Example 1:

Input = AABBAABB
Output = 6

Explanation: 
There are 6 substrings that have equal number of consecutive B's and A's: 
"AABB", "AB", "BBAA", "BA", "AABB", and "AB".
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, "AABBAABB" is not a valid substring because all the A's (and B's) are not grouped together.

Example 2:

Input = BABAB
Output = 4
Explanation: 
There are 4 substrings: "BA", "AB", "BA", "AB" that have equal number of consecutive B's and A's.*/
import java.util.*;

public class Test18{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String input = new String(scanner.next());
        scanner.close();
        System.out.print(numOfSubstrings(input));
    }
    static int numOfSubstrings(String s){
        int count = 0;
        int j = 0;
        char start = s.charAt(j);
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);            
            if(c == start){
                stack.push(c);
            }else if(c != start && !stack.isEmpty()){
                stack.pop();
            }   
            if(stack.size() == 0){
                count++;
                start = s.charAt(++j);
                i = j;
            }
        }
        return count;
    }
}
