/*You are given an array of integers representing coin denominations and a total 
amount of money. Write a function to compute the fewest number of coins needed 
to make up that amount. If it is not possible to make that amount, return null.

For example, given an array of [1, 5, 10] and an amount 56, return 7 since we 
can use 5 dimes, 1 nickel, and 1 penny.

Given an array of [5, 8] and an amount 15, return 3 since we can use 5 5-cent
coins.
*/
import java.util.*;
class Test
{
     static int minCoins(int coins[], int m, int V)
    {
        int table[] = new int[V + 1];
 
        table[0] = 0;
 
        for (int i = 1; i <= V; i++)
        table[i] = Integer.MAX_VALUE;
 
        for (int i = 1; i <= V; i++)
        {
            for (int j = 0; j < m; j++)
            if (coins[j] <= i)
            {
                int sub_res = table[i - coins[j]];
                if (sub_res != Integer.MAX_VALUE
                       && sub_res + 1 < table[i])
                       table[i] = sub_res + 1;
                        
                 
            }
             
        }
       
          if(table[V]==Integer.MAX_VALUE)
            return -1;
       
        return table[V];
         
    }
    
   
    public static void main(String args[])
    {
    Scanner sc=new Scanner(System.in);
    String a=sc.nextLine();
    String[] b=a.split(" ");
    int[] arr=new int[b.length];
    for(int i=0;i<b.length;i++)
    {
        arr[i]=Integer.parseInt(b[i]);
    }
    int n=arr.length;
    int V = sc.nextInt();
    System.out.println( minCoins(arr, n, V) );
    
}
}
