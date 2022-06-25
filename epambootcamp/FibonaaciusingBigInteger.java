/*write a program to display the nth term in a fibonacci series
Use BigInteger
Fibonacci Series - 0 1 1 2 3 5 and so on. 
input = 5
output = 3
*/
import java.util.*;
import java.math.*;

class program
{
	public static BigInteger fib(int n)
	{
		BigInteger a = BigInteger.valueOf(0);
		BigInteger b = BigInteger.valueOf(1);
		BigInteger c = BigInteger.valueOf(1);
		for (int j=2 ; j<=n ; j++)
		{
			c = a.add(b);
			a = b;
			b = c;
		}

		return b;
	}

    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print(fib(n-1));
    }
}
