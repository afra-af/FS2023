/*
Rakesh is playing with array of numbers, he is finding subarrays and printing sum of all subarray difference of largest and smallest number from the subarrays.
input =3
1 2 3
output =
for 1 sub array is [1] , so find diff largest (1)- smallest(1)=0
for 2 sub array is [2] , so find diff largest (2)- smallest(2)=0
for 3 sub array is [3] , so find diff largest (3)- smallest(3)=0
for [1,2]  find diff largest (2)- smallest(1)= 1
for [2,3]  find diff largest (3)- smallest(2)= 1
for [1,2,3]  find diff largest (3)- smallest(1)= 2
sum 0 + 0 + 0 + 1 + 1 + 2 = 4.
input =3
1 3 3
output =4
[1] 1 - 1 = 0
[3]  3 - 3 = 0
[3] 3 - 3 = 0
[1,3] 3 - 1 = 2
[3,3] 3 - 3 = 0
[1,3,3] 3 - 1 = 2
sum 0 + 0 + 0 + 2 + 0 + 2 = 4.
input =5
4 -2 -3 4 1
output: 59
*/
import java.util.*;
class program{
    public static long work(int []arr,int n){
        long sum=0;
        for(int i=0;i<n;i++){
           int  max=arr[i],min=arr[i];
            for(int j=i;j<n;j++){
                max=Math.max(max,arr[j]);
                min=Math.min(min,arr[j]);
                sum+=max-min;
            }
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print(work(arr,n));
    }
}
