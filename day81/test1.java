/*
For Siddarth's Birthday his friends planned cake cutting.
On top of the cake there are two lines of candles, 
all the candles with different heights. 
The lines are parallel lines, line-P and line-Q .
Siddarth has to blow all the candles in one go.
So, he can swap one candle at a time, from P and Q and 
the position of the candles in their line should be same.
At the end of the swaps, The candles in set P and set Q, 
should be in ascending order of their heights.
You will be heights of the candles initially in P and Q, after placing in parallel lines.
Your task is to find the minimum number of swaps required
to arrange the candles in P and Q in ascending orer.
Note: It is guaranteed that the answer is always possible.
Input Format:
-------------
Line-1: An integer N, num of candles in P and Q.
Line-2: N space separated integers, heights of the candles in Line-P.
Line-3: N space separated integers, heights of the candles in Line-Q.
Output Format:
--------------
Print an integer, minimum number of swaps required.
Sample Input-1:
---------------
4
1 3 5 4
1 2 3 7
Sample Output-1:
----------------
1
Explanation:
------------
Swap the 4th candle in P and Q. 
Then the heights of the candles in P = [1, 3, 5, 7],  Q = [1, 2, 3, 4]
Both are in ascending order.
*/
import java.util.*;
class program{
    public static int min_swaps(int arr1[],int arr2[],int n){
        int noswap[]=new int[n];
        int swap[]=new int[n];
        noswap[0]=0;
        swap[0]=1;
        for(int i=1;i<n;i++){
            if(arr1[i]>arr1[i-1]&& arr2[i]>arr2[i-1]&&arr1[i]>arr2[i-1]&&arr2[i]>arr1[i-1]){
                noswap[i]=Math.min(noswap[i-1],swap[i-1]);
                swap[i]=Math.min(noswap[i-1],swap[i-1])+1;
            }
            else if(arr1[i]>arr1[i-1] && arr2[i]>arr2[i-1]){
                noswap[i]=noswap[i-1];
                swap[i]=swap[i-1]+1;
            }
            else{
                noswap[i]=swap[i-1];
                swap[i]=noswap[i-1]+1;
            }
        }
        return Math.min(swap[n-1],noswap[n-1]);
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr1[]=new int[n];
        int arr2[]=new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            arr2[i]=sc.nextInt();
        }
        System.out.print(min_swaps(arr1,arr2,n));
    }
}
