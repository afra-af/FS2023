/*
Ramesh is travelling countries either by air transport or sea transport (air represents 1 and sea  represents 0). if he visited any country through sea(ie 0) then he will travel all of it's left side ,right side ,upside and downside countries will visit by sea transport.

ex:
input =3 3
1 1 1
1 0 1
1 1 1
output =
1 0 1
0 0 0
1 0 1

Ramesh will travel all of its left right, down and up by sea transport so change values of 1's to zero of same row and same column

  0
 000
  0
so final output would be 
1 0 1
0 0 0
1 0 1



ex: 2
input =3 4
0 1 2 0
3 4 5 2
1 3 1 5
output =
0 0 0 0
0 4 5 0
0 3 1 0
*/
import java.util.*;
public class Test{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] arr=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            arr[i][j]=sc.nextInt();
        }
        int[][] arr1=function(arr,m,n);
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
    public static int[][] function(int[][] arr,int m,int n){
        int[][] lookup=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            lookup[i][j]=arr[i][j];
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(lookup[i][j]==0)
                {
                    for(int k1=0;k1<n;k1++)
                    {
                        arr[i][k1]=0;
                    }
                    for(int k2=0;k2<m;k2++)
                    {
                        arr[k2][j]=0;
                    }
                }
            }
        }
        return arr;
    }
}



#method 2

import java.util.*;
class zero{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int m=sc.nextInt();
int[][] arr=new int[n][m];
for(int i=0;i<n;i++){
for(int j=0;j<m;j++)
arr[i][j]=sc.nextInt();

}
int[][] arr2=one(arr,n,m);
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
System.out.print(arr[i][j]+"");
}
System.out.println();
}
}
static int[][] one(int[][] arr,int n,int m){
int[][] lookup=new int[n][m];
for(int i=0;i<n;i++){
for(int j=0;j<m;j++)
lookup[i][j]=arr[i][j];
}
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
if(lookup[i][j]==0){
arr[i][0]=arr[0][j]=0;
arr[i][j+1]=arr[i+1][j]=0;
}
}
}
return arr;
}
}





