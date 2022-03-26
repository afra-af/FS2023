/*There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

input =7
1 2 3 4 5 6 1
3
output =12

Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. 
The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.


input =3
2 2 2 
2
output =4

Explanation: Regardless of which two cards you take, your score will always be 4.

input =7
9 7 7 9 7 7 9
7
output =55
Explanation: You have to take all the cards. Your score is the sum of points of all cards.
*/
import java.util.*;
class Test12{
    public static int maxScore(int[] arr,int s,int k){
        if(k==arr.length){
            return s;
        }
        int i=0,j=arr.length-1;
        int sum=0;
        while(i<arr.length && j>=0){
            if(k<=0) break;
            if(arr[i]>arr[j]){
                sum+=arr[i];
                k--;
                i++;
            }
            else if(arr[j]==arr[i]){
                if(arr[i+1]>arr[j-1]){
                    sum+=arr[i];
                    i++;
                    k--;
                }
                else{
                    sum+=arr[j];
                    j--;
                    k--;
                }
            }
            else{
                sum+=arr[j];
                j--;
                k--;
            }
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        int k = sc.nextInt();
        System.out.print(maxScore(arr,sum,k));
    }
}
