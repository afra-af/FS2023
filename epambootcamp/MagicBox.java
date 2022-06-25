/*
A magic box with p rows and r columns is initially filled with silver.
If we invoke a method 'addMagicOperation' which turns the silver at index (r, c)
into gold. 
Given N set of indices to work up on, find the number of gold-blocks which 
are formed after each addMagicOperation. 
A gold-block is a block of gold cells connected horizontally and vertically and 
surrounded by silver. Consider all four edges of the magic box are surrounded by
silver.
Input Format:
--------------
Line-1: Three space separated integers p, r , and n (number of add Magic Operations)
Next N lines: Two space separated integers, cell to perform addMagicOperation 
Output Format:
--------------
Print a list of numbers, number of gold-blocks formed after each addMagicOperation
Sample Input-1:
-----------------
3 3 5
0 0
0 1
1 2
2 1
1 1
Sample Output-1:
-----------------
[1, 1, 2, 3, 1]
Explanation:
-----------
Initially, the magic box is filled with silver. 
(Assume 0 represents silver and 1 represents gold).
0 0 0
0 0 0
0 0 0
Operation #1: addMagicOperation(0, 0) turns the silver at cell[0][0] into gold.
1 0 0
0 0 0   Number of Gold-blocks = 1
0 0 0
Operation #2: addMagicOperation(0, 1) turns the silver at cell[0][1] into gold.
1 1 0
0 0 0   Number of Gold-blocks = 1
0 0 0
Operation #3: addMagicOperation(1, 2) turns the silver at cell[1][2] into gold.
1 1 0
0 0 1   Number of Gold-blocks = 2
0 0 0
Operation #4: addMagicOperation(2, 1) turns the silver at cell[2][1] into gold.
1 1 0
0 0 1   Number of Gold-blocks = 3
0 1 0
Operation #5: addMagicOperation(1, 1) turns the silver at cell[1][1] into gold.
1 1 0
0 1 1   Number of Gold-blocks = 1
0 1 0
*/

import java.util.*;
class program{
    public static void check(int grid[][],int i,int j){
        if(i<0||j>=grid[0].length||i>=grid.length||j<0||grid[i][j]!=1){
            return;
        }
        grid[i][j]=0;
        check(grid,i+1,j);
        check(grid,i-1,j);
        check(grid,i,j+1);
        check(grid,i,j-1);
    }
    public static int is_gold_block(int [][]box,int row,int col){
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(box[i][j]==1){
                    check(box,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static List<Integer> make_gold(int box[][],int ind[][],int row,int col,int op){
        List<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<op;i++){
            int j=0;
            while(j<=i){
             box[ind[j][0]][ind[j][1]]=1;
             j++;
            }
             res.add(is_gold_block(box,row,col));
        }
        return res;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
        int op=sc.nextInt();
        int[][] box=new int[row][col];
        int[][] ind=new int[op][2];
        for(int i=0;i<op;i++){
            for(int j=0;j<2;j++){
                ind[i][j]=sc.nextInt();
            }
        }
        System.out.print(make_gold(box,ind,row,col,op));
    }
}
