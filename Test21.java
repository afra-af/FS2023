/*Rakesh is playing a game with two arrays called  array1 and array2 of single digit numbers of range 1 to 6.
In each step rakesh can change any value of any array in range of 1 to 6. 
return the minimum number of steps to make the sum of values in array1 equal to sum of values in array2
otherwise print -1, if it is not possible to make the sum of two arrays equal

Note:  array1 and array2 possibly of different lengths.

input =6
1 2 3 4 5 6
6
1 1 2 2 2 2
output =3


Rakesh can make  the sums of array1 and array2 equal with 3 operations.
- Change array2[0] to 6. array1 = [1,2,3,4,5,6], array2 = [6,1,2,2,2,2].
- Change array1[5] to 1. array1 = [1,2,3,4,5,1], array2 = [6,1,2,2,2,2].
- Change array1[2] to 2. array1 = [1,2,2,4,5,1], array2 = [6,1,2,2,2,2].


input =7
1 1 1 1 1 1 1
1
6
output =-1
Explanation: There is no way to decrease the sum of array1 or to increase the sum of array2 to make them equal.so return -1.


input =2
6 6
1
1
output =3
Explanation: You can make the sums of array1 and array2 equal with 3 operations. All indices are 0-indexed. 
- Change array1[0] to 2. array1 = [2,6], array2 = [1].
- Change array1[1] to 2. array1 = [2,2], array2 = [1].
- Change array2[0] to 4. array1 = [2,2], array2 = [4].
*/

class Test21
{
    public static int ans(int[] nums1,int[] nums2,int s1,int s2)
    {
        int ans = 0;
        int left=0, right=nums2.length-1;
        int curr_left=0, curr_right=0;
        while(left<nums1.length || right>=0){
            if(s1==s2)
                return ans;
            if(left<nums1.length)
                curr_left = nums1[left];
            else 
                curr_left = 7;
            if(right>=0)
                curr_right = nums2[right];
            else 
                curr_right = 0;
            if(6-curr_left>=curr_right-1)
            {
                s1=s1+ Math.min(6-curr_left, s2-s1);
                left++;
            }
            else{
                s2=s2- Math.min(curr_right-1, s2-s1);
                right--;
            }
            ans++;
        }
        if(s1!=s2)
            return -1;
        else 
            return ans;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int arr1[] = new int[m];
        int sum1=0,sum2=0;
        for(int i=0;i<m;i++)
        {
            arr1[i] = sc.nextInt();
            sum1=sum1+arr1[i];
        }
        int n = sc.nextInt();
        int arr2[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr2[i] = sc.nextInt();
            sum2=sum2+arr2[i];
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(sum1>sum2)
            System.out.println(ans(arr2,arr1,sum2,sum1));
        else
            System.out.println(ans(arr1,arr2,sum1,sum2));
    }
}
