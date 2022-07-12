/*
Given a set of weights of n items weights[], and another item wieght w.
Your task is to check if the sum of weights of continuous subset is equal to 
one of the multiple of w, where subset size should be minimum 2.
For example: Mulitple of w means, w=3 then multiple of w are
3, 6, 9, 12, .... so on.
Print true, if such subset sum is possible.
Otherwise, print false.
Input Format:
-------------
Line-1 : Two integers n and w, number of weights and weight to match.
Line-2 : n space separated integers, weights of n items.
Output Format:
--------------
Print a boolean value.
Sample Input-1:
---------------
5 4
1 2 3 5 6
Sample Output-1:
----------------
false
Sample Input-2:
---------------
5 4
1 2 3 6 5
Sample Output-2:
----------------
true
Explanation: 
------------
sum of  continuous subset of weights [1,2,3,6]  equals to 12, multiple of 4.
*/

import java.util.*;
class program{
    public static boolean ismultipleexist(int nums[],int n,int k){
       Map<Integer,Integer> map =new HashMap<>();
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            sum=sum%k;
            if(!map.containsKey(sum))
                map.put(sum,i);
            else if(i-map.get(sum)>1)
                 return true;
        }
        return false;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.print(ismultipleexist(nums,n,k));
    }
}
