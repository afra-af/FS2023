/*Shyam a Fifth class boy is working on numbers, Given few numbers 
he has to construct a new number which is greatest number. 

The first line of input contains the size of the numbers followed by the numbers

input = 2
50 7
output = 750

input = 5
3 30 34 5 9
output = 9534330
*/

import java.util.*;
class MyCom implements Comparator<String>{
    public int compare(String i,String j){
        String a = i+j;
        String b = j+i;
        return a.compareTo(b) > 0 ? -1 : 1; 
    }
}
class Test{
    public static String largest(List<String> arr,int n){
        Collections.sort(arr, new MyCom());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(arr.get(i));
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(sc.next());
        }
        System.out.println(largest(arr,n));
    }
}
