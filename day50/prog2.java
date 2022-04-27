/*
Motu Patlu are good friends, Motu loves to eat Samosas, 
Patlu is given N Boxes of samosas[] to Motu, where box-'a' has samosas[a].
Motu can choose two boxes having highest number of samosas each time, 
box-i and box-j, where  samosas[i] <= samosas[j].
	- If samosas[i] == samosas[j] , then eat all the samosas from both boxes;
	- If samosas[i] != samosas[j] , then eat all samosas from box-i, 
	- and from box-j eat only samosas[i] samosas, and left with 
	(samosas[j]-samosas[i]), 
	- If the box becomes empty, remove the box.
	
At the end, there is at most 1 box left. Return the number of samosas left in 
that box (or 0 if there are no boxes left.)


Input Format:
-------------
N space separated integers, number of samosas[i] in box[i]

Output Format:
--------------
Print number of the samosas left at the end.


Sample Input-1:
---------------
2 7 4 1 8 1

Sample Output-1:
----------------
1

Explanation:
------------
Boxes are numbered from 0,1,2,...,N-1.

- Motu selects, box-1 has 7 samosas and box-4 has 8 samosas eat 14 samosas, 
  boxes becomes [2,4,1,1,1]
- Motu selects, box-0 has 2 samosas and box-1 has 4 samosas eat 4 samosas, 
  boxes becomes [2,1,1,1]
- Motu selects, box-1 has 1 samosa and box-0 has 2 samosas eat 2 samosas, 
  boxes becomes [1,1,1]
- Motu selects, box-0 has 1 samosa and box-1 has 1 samosa eat 2 samosas, 
  boxes becomes [1]

Finally left with 1 box, box contains 1 samosa in it.
*/
import java.util.*;

public class Day50Program1{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String[] num = scanner.nextLine().split("\\s+");
        List<Integer> l = new ArrayList<>();
        for(String x: num){
            l.add(Integer.parseInt(x));
        }
        System.out.println(returnRemBox(l));
    }
    
    public static int returnRemBox(List<Integer> l){
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        q.addAll(l);
        while(q.size() > 1){
            int x = q.poll();
            int y = q.poll();
            if(x != y){
                q.add(Math.abs(x - y));
            }
        }
        return (q.size() == 0)? 0: q.poll();
    }
}
