/*
BCCI wants to select the group of bowlers for an upcoming test-series, you want
to choose the group with highest number of wickets, which is the sum of wickets
taken by all the bowlers in that group.
However, the bowler group is not allowed to have any disputes. 
A dispute exists if a younger bowler has strictly highest wickets than an 
older bowler. A dispute does not occur between bowlers of the same age.
You are given information of N bowlers as two lists, wickets and ages, 
where each wickets[i] and ages[i] represents the wickets and age of the i-th bowler, 
respectively, return the highest number of wickets of all possible bowler groups.
Input Format:
-------------
Line-1: An integer N, number of bowlers.
Line-2: N space separated integers, wickets[].
Line-3: N space separated integers, ages[].
Output Format:
--------------
An integer, highest number of wickets of all possible bowler groups.
Sample Input-1:
---------------
4
5 3 5 6
3 5 4 2
Sample Output-1:
----------------
10
Explanation:
------------
It is best to choose 2 bowlers of age 3 and 4. 
Sample Input-2:
---------------
5
5 3 5 6 3
2 5 4 2 1
Sample Output-2:
----------------
14
Explanation:
------------
It is best to choose 3 bowlers of age 1 and 2. 
Notice that you are allowed to choose multiple bowlers of the same age.
Sample Input-3:
---------------
5
1 3 5 10 15
1 2 3 4 5
Sample Output-3:
----------------
34
Explanation:
------------
You can choose all the bowlers.
*/


import java.util.*;
class program{
     public static int work(int [][]bow,int n){
         Arrays.sort(bow,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
         //System.out.print(Arrays.deepToString(bow));
        int dp[]=new int[n];
        int max=0;
        dp[0]=bow[0][1];
        for(int i=1;i<n;i++){
            dp[i]=bow[i][1];
            for(int j=0;j<i;j++){
                if(bow[j][1]<=bow[i][1]){
                    dp[i]=Math.max(dp[i],bow[i][1]+dp[j]);
                }
            }
            max=Math.max(dp[i],max);
        }
         return max;
     }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ages[]=new int[n];
        int wickets[]=new int[n];
        for(int i=0;i<n;i++){
            wickets[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            ages[i]=sc.nextInt();
        }
        int bow[][]=new int[n][2];
        for(int i=0;i<n;i++){
            bow[i][0]=ages[i];
            bow[i][1]=wickets[i];        }
        System.out.print(work(bow,n));
}
}
