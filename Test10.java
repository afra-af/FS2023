/*UBER driver has a vehicle, daily he used go in only one direction.
Capacity of the vehicle is S (no of seats except driver seat), 

Given a list of N bookings, booking[i]= [ num_customers, pickup, drop ].
booking indicates, number of customers to pick up, and pick up, droping points.

Initially the vehicle is empty.

Return true if and only if it is possible to pick up and drop off all customers of all bookings.

Input Format:
-------------
Line-1 -> Two integers N and S, number of bookings and number of seats in the vehicle.
Next N Lines -> three space separated integers, num_customers, pickup point, dropping point

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 5
2 1 5
3 3 7

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 4
2 1 5
3 3 7

Sample Output-2:
----------------
false


Sample Input-3:
---------------
3 11
3 2 7
3 7 9
8 3 9

Sample Output-3:
----------------
true
*/
import java.util.*;
class Test
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int queries=sc.nextInt();
        int seats=sc.nextInt();
        int i=0,j=0;
        int arr[][]=new int[queries][3];
        for(i=0;i<queries;i++)
        {
         arr[i][j++]=sc.nextInt();
         arr[i][j++]=sc.nextInt();
         arr[i][j++]=sc.nextInt();
            j=0;
        }
        Arrays.sort(arr,(a,b)->
        {
            return a[1]-b[1];
        }
        );
        
        for(i=0;i<arr.length;i++)
        {
            if(i==arr.length-1)
            {
                if(arr[i][0]>seats)
                {
                    System.out.println("false");
                    return;
                }
                continue;
            }
            
            if(arr[i][2]>arr[i+1][1])
            {
                int sum=arr[i][0]+arr[i+1][0];
                if(sum>seats)
                {
                System.out.println("false");
                return;
                }
                i=i+1;
            }
            else
            {
                if(arr[i][0]>seats)
                {
                System.out.println("false");
                return;
                }
            }
        }
        System.out.println("true");
        
    }
}
