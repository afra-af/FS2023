/*
Ramesh and Suresh are best friends. 
They decided to play a word game.

The game rules are as follows:
	- The game board shows a word W consist of two characters only A and B.
	- You are allowed to replace a pair of neighbour letters AA with BB in W.
	- Finally, The one who failed to replace the letters will lose the game.

You can assume that Ramesh will start playing the game always.

Your task is to determine if Ramesh can guarantee a win.
Print 'true', if Ramesh guarantee a win, otherwise, print 'false'.

Input Format:
-------------
A string W, word.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
AAABAAAA

Sample Output-1:
----------------
true

Explanation:
------------
Given word is AAABAAAA 
Ramesh -> AAABBBAA 
Now whatever the pair Suresh replaced with BB, 
one more replace is possible for Ramesh
So, there is a guarantee for Ramesh to win.

Sample Input-2:
---------------
AAAAAA

Sample Output-2:
----------------
true


Sample Input-3:
---------------
AAABAAA

Sample Output-3:
----------------
false
*/
import java.util.*;

public class Test{
    static int ramesh = 0;
    static int suresh = 0;
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        StringBuilder s = new StringBuilder(scanner.next());
        scanner.close();
        System.out.println(isWinning(s));
    }
    
    public static boolean isWinning(StringBuilder s){
        boolean flag = true;
        int n = s.length();
        for(int i = 0; i < n - 1; i++){
            if((s.charAt(i) == 'A' && s.charAt(i + 1) == 'A') || 
                (s.charAt(0) == 'A' && s.charAt(n - 1) == 'A')){
                s.setCharAt(i, 'B');
                s.setCharAt(i + 1, 'B');
                if(flag){
                    ramesh++;
                    flag = false;
                }else{
                    suresh++;
                    flag = true;
                }
            }
        }
        return (ramesh > suresh);
    }
}
