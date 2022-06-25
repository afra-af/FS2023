/*
Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10power of n.
input = 0
output =1
input =1
output =10
input =2
output =91
the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99
so 100-9 is 91
*/
import java.util.*;
class Test{
    public static int unique_digits(int n){
        int count=10;
        if(n==0){
            return 1;
        }
        else if(n==1){
            return 10;
        }
        else{
            int product=9;
            for(int i=2;i<=n;i++){
                product=product*(11-i);
                count+=product;
            }
        }
        return count;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print(unique_digits(n));
    }
}
