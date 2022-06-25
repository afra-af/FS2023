/*
Rahul is playing with diffent length of ropes.these length of ropes are given in an ropes array, where ropes[i] is the length of ith rope. Every time Rahul pick any two ropes  from the ropes array and combine two ropes with the cost of costi +costj.
He must combine all the ropes until there is only he can make one rope with all the other ropes.
input =3
2 4 3
output =14
combine rope 2 with 3 for the cost of 2+3=5 now the ropes remaining are 5 and 4
combine rope 5 with 4 for the cost of 5+4=9 now the ropes remaining is 9
now only one rope left. so final cost will be 5 + 9 = 14.
input =4
1 8 3 5
output =30
combine rope 1 with 3 for the cost of 1+3=4 now the ropes remaining are 4 8 5
combine rope 4 with 5 for the cost of 4+5=9 now the ropes remaining are 9 8
combine rope 9 with 8 for the cost of 9+8=17 now the ropes remaining is 17
now only one rope left. so final cost will 4 + 9 + 17 = 30.
input =1
5
output =0
Explanation: There is only one stick, so you don't need to do anything. The total cost is 0.
*/
import java.util.*;
class Test{
    public static int combine(List<Integer> arr,int n){
        if(n<1){
            return 0;
        }
        int sum=0;
        while(arr.size()>=2){
            Collections.sort(arr);
            int a=arr.get(0);
            arr.remove(0);
            int b=arr.get(0);
            arr.remove(0);
            sum+=a+b;
            arr.add(a+b);
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }
        System.out.print(combine(arr,n));
    }
}
