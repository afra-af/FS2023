/*Given an array and k , find largest sum of subsequence of nums of length k from array

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements 
without changing the order of the remaining elements.

 
input =4
2 1 3 3 
2
output =3 3
The subsequence has the largest sum of 3 + 3 = 6.

input =4
-1 -2 3 4
3
output =-1 3 4
The subsequence has the largest sum of -1 + 3 + 4 = 6.

input =4
3 4 3 3
2
output =3 4
The subsequence has the largest sum of 3 + 4 = 7. 
Another possible subsequence is 4 3.

*/
import java.util.*;
public class Test{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        scanner.close();
        System.out.println(Arrays.toString(largestSubsequenceSum(arr, k)));
    }
    
    public static int[] largestSubsequenceSum(int[] nums, int k){
        int[][] arr = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        
        Arrays.sort(arr, (a,b) -> b[0] - a[0]);
        int[][] temp = new int[k][2];
        for(int i = 0; i < k; i++){
            temp[i][0] = arr[i][0];
            temp[i][1] = arr[i][1];
        }
        
        Arrays.sort(temp, (a, b) -> a[1] - b[1]);
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = temp[i][0];
        }
        return res;
    }
}
