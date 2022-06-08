
/*
Given two numbers n1 and n2, convert all numbers in binary format and return the count of numbers in the inclusive range n1, n2 having a prime number of set bits . 


Note : Don't use bitCount() function


input =6 10
output =4
for 6 in binary format 110 (2 set bits , and 2 is prime)
for 7 in binary format 111 (3 set bits , and 3 is prime)
for 8 is in binary format 1000 (1 set bit , and 1 is not prime)
for 9 is in binary format 1001 (2 set bits , and 2 is prime)
for 10 is in binary format 1010 (2 set bits , and 2 is prime)
so output is 4

input =10 15
output =5
for 10 in binary format 1010 (2 set bits , and 2 is prime)
for 11 in binary format 1011 (3 set bits , and 3 is prime)
for 12 in binary format 1100 (2 set bits , and 2 is prime)
for 13 in binary format 1101 (3 set bits , and 3 is prime)
for 14 in binary format 1110 (3 set bits , and 3 is prime)
for 15 in binary format 1111 (4 set bits , and 4 is not prime)
so output is 5.


*/
import java.util.*;

public class Test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println(check(n1,n2));
    }
    public static int check(int n1,int n2){
        int fcount = 0;
       
        for(int j=n1;j<=n2;j++){
            String t = Integer.toBinaryString(j);
             int count = 0;
            
            for(int i = 0;i<t.length();i++){
            int temp = Character.getNumericValue(t.charAt(i));
            if(temp == 1){
                count++;
            }
        }
        
         
            boolean flag = false;
            for(int l2 = 2;l2<=count/2;l2++){
                if(count%l2==0){
                    flag = true;
                    break;
                }
            }  
            if((!flag) && ( count != 1)){
                //  System.out.print(n_temp + " ");
                fcount++;
            }
        
    }
        // System.out.println(li);
       
        return fcount;
    }
}
