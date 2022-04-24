/*
Given a matrix with path with cost , find out the maximum total cost to reach.

initially person at first column but can be at any row.
he can move to right or right-up  or right-down from that current place.

example:
intput =3 3
1 3 3
2 1 4
0 6 4
output =12

person will start from (1,0) position cost is 2, and goes to (2,1) cost is 6 and goes to (1,2) or (2,2) cost is 4
so total cost will be 2+6+4 is 12

example:
input =4 4
1 3 1 5
2 2 4 1
5 0 2 3
0 6 1 2
output = 16

sol1:
person will start from (2,0) cost will be 5, then goes to (3,1) cost will be 6, then move to (2,2) cost will be 2 and (2,3) cost wil be 3 , so final output would be 5+6+2+3=16

sol2:
person will start from (2,0) cost will be 5,(1,1) cost will be 2, then move to (1,2) cost will be 4 and move to (0,3) cost will be 5, so final output would be 5+2+4+5=16
*/
import java.util.*;
class test
{
    public static int path_Cost(int arr[][],int r,int c,int m,int n)
    {
        if((r<0) || (r==m) || (c==n))
        return 0;
        int right=path_Cost(arr,r,c+1,m,n);
        int rightUpDiagonal=path_Cost(arr,r-1,c+1,m,n);
        int rightLowDiagonal=path_Cost(arr,r+1,c+1,m,n);
        return arr[r][c] + Math.max(Math.max(rightUpDiagonal,rightLowDiagonal),right);
    }
    public static int maxSum(int arr[][],int m,int n)
    {
        int maxCost=0;
        for(int i=0;i<m;i++)
        {
            int pathCost=path_Cost(arr,i,0,m,n);
            maxCost=Math.max(maxCost,pathCost);
        }
        return maxCost;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int arr[][]=new int[m][n];
        int i,j;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.print(maxSum(arr,m,n));
    }
}
