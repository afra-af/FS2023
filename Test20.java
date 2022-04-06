/*Given an integer m and array characters, return the maximum number of consecutive B's in the array if you can
change at most m A's.


input =11
B B B A A A B B B B A
2
output=6

Explanation: B B B A A B B B B B B
5th index and 10th index were flipped from A to B. The longest subarray is 5th index to 10th index are having consecutive B's. so return length 6


input =19
A A B B A A B B B A B B A A A B B B B
3
output =10
Explanation: A A B B B B B B B B B B A A A B B B B
index 4th , 5th and 9th index  were changed from A to B. The longest subarray is from 2nd index to 11th index. so return length 10*/
import java.util.*;

public class Test20{
    public static void main(String arg[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] l = new char[n];
        for(int i = 0; i < n; i++){
            l[i] = scanner.next().toUpperCase().charAt(0);
        }
        int m = scanner.nextInt();
        scanner.close();
        System.out.println(getMax(l, m));
    }
    static int getMax(char[] l, int m){
        int n = l.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            int count = 0;
            int temp = m;
            for(int j = i; j < n; j++){
                if(temp == 0 && l[j] == 'A'){
                    break;
                }
                if(l[j] == 'B'){
                    count++;
                }else{
                    temp--;
                    count++;
                }
                max = (count > max)? count: max;
            }
        }
        return max;
    }
}
