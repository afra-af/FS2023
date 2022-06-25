/*Rakesh is printing longest increasing subsequence from the group of integers.
Help him to find the length of subsequence.
input =8
10 9 2 5 3 7 101 18
output =4
Explanation: 2 3 7 101 is the longest increasing subsequence is so print length 4.
Example 2:
input =6
0 1 0 3 2 3
output =4
input =7
7 7 7 7 7 7 7
output =1
*/

//recursion
import java.util.*;
class program{
    public static int helper(int ind,int prev_ind,int arr[],int n){
        if(ind==n) return 0;
        int len=0+helper(ind+1,prev_ind,arr,n);
        if(prev_ind==-1||arr[ind]>arr[prev_ind]){
            len=Math.max(len,1+helper(ind+1,ind,arr,n)); 
        }
        return len;
    }
    public static int LIS(int[] arr,int n)
    {
        return helper(0,-1,arr,n);
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print(LIS(arr,n));
    }
}

/*
Dp-solution
import java.util.*;
class program{
    public static int LIS(int[] arr,int n)
    {
        int []dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<=i-1;j++){
                if(arr[i]>arr[j]){
                dp[i]=Math.max(dp[i],1+dp[j]);
            }
            max=Math.max(max,dp[i]);
          }
        }
        return max;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print(LIS(arr,n));
    }
}*/
