/*
There are N Trees planted on flat land at various positions along X-Axis.
You are given the X-Axis poistions of the trees in ascending order.
Mr ABC wants to setup a water irrigation system for T trees which are 
near to point-X.

Your task is to find and return the positions of the T nearest trees to point-X.
and answer should be ascending order. To find the nearest positions of trees to 
point-X, the rule is as follows:
	- There are two trees at posistions X1 and X2, if X1 said to be nearest
	  tree to point-X, if, [ |X1 - X| < |X2 - X| ] 
	  OR [ (|X1 - X| == |X2 - X| ) and X1 < X2 ]


Input Format:
-------------
Line-1: 3 space separated integers N, T, X, number of trees, values of T and X.
Line-2: N space separated integers, posistions of the trees.

Output Format:
--------------
Print the list of the posistions of T trees near to point-X.


Sample Input-1:
---------------
6 3 7
1 4 5 7 9 10 

Sample Output-1:
----------------
[5, 7, 9]



Sample Input-2:
---------------
6 4 2
-3 -1 0 1 3 4 

Sample Output-2:
----------------
[0, 1, 3, 4]
*/
import java.util.*;
class Test{
    public static ArrayList<Integer>getList(int[]arr,int t,int x){
        ArrayList<Integer>al=new ArrayList<>();
        int right=arr.length-1;
        int left=0;
        while(right-left>=t){
            if((Math.abs(arr[left]-x)>Math.abs(arr[right]-x))){
                left++;
            }
            else{
                right--;
            }
        }
        for(int i=left;i<=right;i++){
            al.add(arr[i]);
        }
        return al;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int T=sc.nextInt();
        int X=sc.nextInt();
        int []trees=new int[N];
        for(int i=0;i<N;i++){
            trees[i]=sc.nextInt();
        }
        List<Integer>res=getList(trees,T,X);
        System.out.println(res);
    }
}
