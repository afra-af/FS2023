/*
You have n buckets each containing some gallons of water in it, represented by a 0-indexed integer array buckets , 
where the ith  bucket contains buckets[i] gallons of water. You are also given an integer loss .
You want to make the amount of water in each bucket equal. You can pour any amount of water from one bucket to another
bucket (not necessarily an integer). However, every time you pour k gallons of water, you spill loss percent of k .
Return the maximum amount of water in each bucket after making the amount of water equal. 


Example 1:
input =3
1 2 7
80
output =2.00000

buckets = [1,2,7], loss = 80
output: 2.00000

Explanation: Pour 5 gallons of water from buckets[2] to buckets[0].
             5 * 80% = 4 gallons are spilled and buckets[0] only receives 5 - 4 = 1 gallon of water.
	     All buckets have 2 gallons of water in them so return 2.


Example 2:
input =3
2 4 6
50
output =3.50000

buckets = [2,4,6], loss = 50
Output: 3.50000

Explanation: Pour 0.5 gallons of water from buckets[1] to buckets[0].
	     0.5 * 50% = 0.25 gallons are spilled and buckets[0] only receives 0.5 - 0.25 = 0.25 gallons of water.
	     Now, buckets = [2.25, 3.5, 6].
	    
	    Pour 2.5 gallons of water from buckets[2] to buckets[0].
	    2.5 * 50% = 1.25 gallons are spilled and buckets[0] only receives 2.5 - 1.25 = 1.25 gallons of water.
            
	    All buckets have 3.5 gallons of water in them so return 3.5.


Example 3:
input =4
3 3 3 3
40
output =3.00000

buckets = [3,3,3,3], loss = 40
output: 3.00000
Explanation: All buckets already have the same amount of water in them.
*/
import java.util.*;
class test{
    public static double WaterEqualLevel(int[] buckets, int loss){
        double lo = 0, hi = 100_000, retainPercent = (100.0 - loss) / 100;
        while(hi - lo > 0.00001)
    	{
            double mid = (lo + hi) / 2, need = 0, have = 0;
            for(int b : buckets)
                if(b >= mid)
                    have += b - mid;
                else need += mid - b;
            if(have * retainPercent >= need)
                lo = mid;
            else hi = mid;
        }
        return lo;
    }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextInt();
        }
        int loss=in.nextInt();
        System.out.print(WaterEqualLevel(arr,loss));
    }
}
