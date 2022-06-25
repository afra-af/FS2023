/*
Given an array, display the output in ascending order by the number of 1's in binary format of that number.
sort the elements in ascending order of frequency of 1's.
ex:
input =9
0 1 2 3 4 5 6 7 8 
output =0 1 2 4 8 3 5 6 7
explanation: 
0 is the only integer with 0 bits
1 2 4 8 all have 1 bits
3 5 6 all have 2 bits 
7 has 3 bits
so sorted array by bits is 0 1 2 4 8 3 5 6 7
input =11
1024 512 256 128 64 32 16 8 4 2 1
output =1 2 4 8 16 32 64 128 256 512 1024
*/
import java.util.*;
class Test
{
    public static List<Integer> sorted_array(int []arr,int n){
        //Arrays.sort(arr);
        int res[][]=new int[n][2];
        List<Integer> lis=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            int temp=Integer.bitCount(arr[i]);
            res[i][0]=arr[i];
            res[i][1]=temp;
        }
        /*for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                System.out.println(res[i][j]);
            }
        }*/
        Arrays.sort(res,(a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        for(int i=0;i<n;i++){
                lis.add(res[i][0]);
            }
            return lis;
        }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print(sorted_array(arr,n));
    }
    
}
