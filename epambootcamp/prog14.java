/*
given an array and two integers n1 and n2, find the sum of all the numbers between n1th and n2th smallest elements of that array
Note: don't use sort method 

ex:
input =6
1 3 12 5 15 11
3 
6
output =23
after sorting 1 3 5 11 12 15
n1= 3 ie 3rd smallest number is 5 
n2=6 ie 6th smallest number is 15
The sum of numbers between 5 and 15 is 23 (11+12). 

input =4
3 5 8 7
1
4
output =12
n1=1 ie 1st smallest number is 3
n2=4 ie 4th smallest number is 8
The sum of the numbers between is 12(5+7).


*/

import java.util.*;

public class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        } Arrays.sort(arr);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println(check(n1,n2,arr));
        
    }
    public static int check(int n1,int n2,int[] arr){
        n1 = arr[n1-1];
        n2 = arr[n2-1];
        int count = 0;
     List<Integer> li = new ArrayList<>();
        for(int j = 0;j<arr.length;j++){
            li.add(arr[j]);
        }
     for(int i = n1+1;i<n2;i++){
         if(li.contains(i)){
            //  System.out.print(i + "+");
         count += i;
         }
     }
     return count;
    }
}
