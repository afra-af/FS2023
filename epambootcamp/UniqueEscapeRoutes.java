/*

A professional thief entered into a floor in a building,
The floor has M*N inter connected rooms, the thief can enter into any room 
from any other room. And there are few rooms closed from inside, so the thief 
cannot enter into them. Initially the thief is at room[0][0] and has to exit 
from room[m-1][n-1].

You will be given the array room[][], filled with either 0 or 1.
Here, 1-indiactes a closed room, 0-indiactes a open room.
Your task is to find and print the number of unique escape routes 
from room[0][0] and room[m-1][n-1]. And the thief can move only in 
two directions one is forward direction and other is downward direction.


Input Format:
-------------
Line-1: Two space separated integers, M and N.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 4
0 0 0 0
0 1 0 0
0 0 1 0

Sample Output-1:
----------------
2


Sample Input-2:
---------------
4 4
0 0 0 0
0 0 1 0
1 0 0 0
0 0 1 0

Sample Output-2:
----------------
3

Hint- USE DP

*/
import java.util.*;
class Test{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int [][]arr=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(numOfUniqueRooms(arr,m,n));
    }
    public static int numOfUniqueRooms(int[][]a,int m,int n){
        
        int[][]temp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                temp[i][j]=0;
            }
        }
        if(a[0][0]==0){
            temp[0][0]=1;
        }
        for(int i=1;i<m;i++){
            if(a[i][0]==0){
                temp[i][0]=temp[i-1][0];
            }
        }
        for(int j=1;j<n;j++){
            if(a[0][j]==0){
                temp[0][j]=temp[0][j-1];
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(a[i][j]==0){
                    temp[i][j]=temp[i-1][j]+temp[i][j-1];
                }
            }
        }
        
        return temp[m-1][n-1];
    }
}
