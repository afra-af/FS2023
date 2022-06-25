/*
Given an array, return the length of the longest subarray, which is a mountain.
return 0 if there is no mountain.
finding mountain array:
array is mountain array if and only if :
 1) array length should be greater than 3
 2) there exists some index i(0-indexed) with 0<i<arr.length-1 
      2(i). arr[0] < arr[1] < ..... < arr[i-1] < arr[i]
      2(ii) arr[i] > arr[i+1] > .... > arr[arr.legth-1]
example:
input =7
2 1 4 7 3 2 5
output =5
The largest mountain is 1 4 7 3 2 which has length 5
input =3
2 2 2 
output =0
there is no mountain
input =9
1 2 3 2 1 0 2 3 
output =6
*/
import java.util.*;
class program{
    public static int work(int arr[],int n){
        int max=0;
        for(int i=1;i<n-1;i++){
            if(arr[i-1]<arr[i]&&arr[i+1]<arr[i]){
                int left=i,right=i;
                while(left>0&&arr[left-1]<arr[left])left--;
                while(right<n-1&&arr[right]>arr[right+1])right++;
                
                max=Math.max(max,right-left+1);
            }
        }
        return max;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println(work(arr,n));
    }
}
