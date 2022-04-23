/*Prabhu is playing a game. 
As Part of this game at any given time he can score 3 or 5 or 10 points.
If the Target Score is Given to Prabhu. 
Find the total number of Possibility he can get the Score.

input = 13
output = 2

Explanation - 
3 5 5
3 10

Two Ways to reach the Target.

input = 20
output = 4

Explanation-
10 10
5 5 10
5 5 5 5 
3 3 3 3 3 5*/
import java.util.*;

public class Day45Program3{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(score(target));
    }
    public static int score(int n){
       int table[] = new int[n + 1], i;
        Arrays.fill(table, 0);
        table[0] = 1;
        for (i = 3; i <= n; i++)
            table[i] += table[i - 3];
        for (i = 5; i <= n; i++)
            table[i] += table[i - 5];
        for (i = 10; i <= n; i++)
            table[i] += table[i - 10];
        return table[n];
    }
}
