/*
EPAM is planning to conduct the technical interview for 2n students
EPAM has given the cost of flying a technical person to city A,city B. 
EPAM HR wants to find the minimum cost to fly every technical panel member to a city 
such that n technical panel members arrive in each city. 
Example 1:
The first line of input contains the numbers of pairs of such cities.
input =4
10 20 30 200 400 50 30 20
output = 110
Explanation:
[10 20] [30 200] [400 50] [30 20]
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.
The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in
each city.
Example 2:
input = 4
costs = 20 60 10 50 40 200 30 300
output = 180
Explanation:
costs[i] = [ACost, BCost]
costs = [[20,60],[10,50],[40,200],[30,300]]
If you go by the minimum cost you might get the cost as below
TotalMinimumCost= 10 + 20 + 300 + 200 = 530
but actualMinimumCost=30 + 40 + 50 + 60 =180
Constraints:
2 * n == costs.length
2 <= costs.length <= 100
costs.length is even.
1 <= aCost , bCost <= 1000
*/
import java.util.*;
class Test{
    public static int minimum_cost(int[][] arr,int n){
        int count=0,min=0,index=0;
        int []res=new int[(n/2)*2];
        for(int []cost:arr){
            res[index++]=cost[1]-cost[0];
            min+=cost[0];
        }
        Arrays.sort(res);
        for(int i=0;i<n/2;i++){
            min+=res[i];
        }
        return min;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        System.out.print(minimum_cost(arr,n));
    }
}
