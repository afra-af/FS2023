/*In a revised game of hopscotch, a child is trying to cross a line of tiles with a binary string 
painted on it. 

Consider the line of tiles to be like a 1D array, where each tile has either a 1 or a 0, 
and a consecutive series of tiles making the whole string. 
The game starts with the child standing in front of the leftmost character of the string

All jumps to reach the end of the string can only be on tiles with 0 or only be on tiles with 1.

The game is won if the child can reach the end of the string, taking jumps with the minimum
required power. 

In 10101, the power of the jump from beginning to the first tile is 1, but from the first to the 
third tile is 2 and so on.

Find the minimum power the child's jump should have in order to win the game for different binary 
strings. 

Note : In one jump, the child can jump to the right, any distance from 1 to the value of the power
of her jump.

For example, for the string 10101, the power of the jump needs to be minimum 2.

Sample Input 
11111

Sample Output 
1

Explanation :
Since all the string elements are 1, the minimum power of the jump needs to be 1 to cross the 
string.

Sample Input 
11101

Sample Output
2

Explanation:
There is one gap of 2 along a path of 1’s/The minimum power of the jump needs to be 2 to cross 
the string.

*/

 import java.util.*;
public class Day53Program3{
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    StringBuilder n = new StringBuilder(sc.next());
    check(n);
}
public static void check(StringBuilder n){
    List<Integer> li = new ArrayList<Integer>();
    int l = n.length();
    int tar = Character.getNumericValue(n.charAt(l-1));
    int count = 1;
    for(int i = 0;i<l;i++){
        
        int temp = Character.getNumericValue(n.charAt(i));
        // System.out.println(temp + "/"+tar);
        
        if(temp == tar){
            li.add(count);
            count = 1;
        }
        else{
            count++;
        }
    }
    System.out.println(Collections.max(li));
}
}
