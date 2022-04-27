/*
Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up. 

Examples: 

Input  : n = 3
Output : 4
Explanation:
{1}, {2}, {3} : all single
{1}, {2, 3} : 2 and 3 paired but 1 is single.
{1, 2}, {3} : 1 and 2 are paired but 3 is single.
{1, 3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1, 2} and {2, 1} are considered same.

Mathematical Explanation:
The problem is simplified version of how many ways we can divide n elements into multiple groups.
(here group size will be max of 2 elements).
In case of n = 3, we have only 2 ways to make a group: 
    1) all elements are individual(1,1,1)
    2) a pair and individual (2,1)
In case of n = 4, we have 3 ways to form a group:
    1) all elements are individual (1,1,1,1)
    2) 2 individuals and one pair (2,1,1)
    3) 2 separate pairs (2,2)
*/
import java.io.*;

class GFG {

	// Returns count of ways n people
	// can remain single or paired up.
	static int countFriendsPairings(int n)
	{
		int dp[] = new int[n + 1];

		// Filling dp[] in bottom-up manner using
		// recursive formula explained above.
		for (int i = 0; i <= n; i++) {
			if (i <= 2)
				dp[i] = i;
			else
				dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
		}

		return dp[n];
	}

	// Driver code
	public static void main(String[] args)
	{
		int n = 4;
		System.out.println(countFriendsPairings(n));
	}
}

// This code is contributed by vt_m
