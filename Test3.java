/*You will be given a area of a matrix. Where the matrix has a
value 1/0. 1 represent the land and 0 represents the water.

The matrix is connected both row and column wise not diagonally. 
the matrix is surronded by water completely and there is exactly 1 island (i.e, 1 or more connected land cells)

The island doesn't have "lakes", meaning the water inside isn't connected to the
water around the island. One cell is a square with side length 1. The matrix is
rectangular,. we have to find  perimeter of the island.


input=4 4
0 1 0 0
1 1 1 0
0 1 0 0
1 1 0 0
output=16

Explanation- The perimeter is the 16 yellow stripes in the image above.*/

import java.util.*;

class Test3{
     public static int islandPerimeter(int[][] mat,int n,int m) {
        int perimeter = 0 , sides = 0;
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < m;  j++) {
                if(mat[i][j] == 1) {
                    sides = 0;
                    if(i == 0)
                        sides++;
                    else if(mat[i - 1][j] == 0)
                        sides++;
                    if(j == 0)
                        sides++;
                    else if(mat[i][j - 1] == 0)
                        sides++;
                    if(i == n - 1)
                        sides++;
                    else if(mat[i + 1][j] == 0)
                        sides++;
                    if(j == m - 1)
                        sides++;
                    else if(mat[i][j + 1] == 0)
                        sides++;
                    perimeter += sides;
                }
            }
        return perimeter;
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] mat=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) mat[i][j]=sc.nextInt();
        }
        System.out.println(islandPerimeter(mat,n,m));
    }
   
}
