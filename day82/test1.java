/*
Aziz is given a set of integers SOI[], consists of both +ve and -ve integers.
Aziz wants to find the maximum sum of contiguous subset of the SOI, with a twist.
You have to perform the following operation before finding the maximum sum:
	- You are allowed to replace exactly one integer X, with its square value ( X * X).
Can you please help Aziz to find out the maximum sum of contiguous subset.
Input Format:
-------------
Single line of space separated integers, values of the array.
Output Format:
--------------
Print an integer value as result.
Sample Input-1:
---------------
-5 -3 1 2 -3 4 -4 3
Sample Output-1:
----------------
26
Explanation:
------------
max sum is: (-5)^2 + (-3) + 1 + 2 + (-3) + 4 = 26
Sample Input-2:
---------------
2 -2 2 2 -2 -2 2
Sample Output-2:
----------------
10
Explanation:
------------
max sum is: 2 +(-2)^2 + 2 + 2 = 10
*/



import java.util.*;
class program{
    public static int max_cont_sum(int[] arr,int n){
     int prevsquare=0,prevnotsquare=0;
     int res=0;
     for(int num:arr){
         int notsquare=Math.max(num,num+prevnotsquare);
         int square=Math.max(Math.max(num*num,num*num+prevnotsquare),prevsquare+num);
         res=Math.max(res,square);
         prevsquare=square;
         prevnotsquare=notsquare;
     }
     return res;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int n=s.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        System.out.print(max_cont_sum(arr,n));
    }
}
