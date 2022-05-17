/*
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:
Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.

input format:
input =
6
0 1 2 4 5 7
output =
0->2
4->5
7
first read the size of the array , followed by elements

Example 2:
Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.

input = 
7
0 2 3 4 6 8 9
output =
0
2->4
6
8->9
*/
import java.util.*;

public class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sot(arr,n);
        sc.close();
    }
    public static void sot(int[] arr,int n){
        Map<Integer,Integer> mp = new HashMap<>();
        int first = arr[0];
        List<Integer> li = new ArrayList<>();
        List<Integer> fli = new ArrayList<>();
        li.add(arr[0]);
        fli.add(arr[0]);
        for(int i = 0;i<n;i++){
            if(i>0){ 
                
                int temp = arr[i-1]+1;
                if(temp == arr[i])
                {
                    li.add(arr[i]);
                }
                if(temp != arr[i] && i == n-1){
                      fli.add(arr[i]);
                }
                
                if(temp != arr[i] || i == n-1){
                    if(li.size() > 0){
                        mp.put(first,li.get(li.size()-1));
                        
                        first = arr[i];
                        li.clear();
                        if(i != n-1){
                            fli.add(arr[i]);
                        }
                        
                        li.add(arr[i]);
                    }
                //     if(temp != arr[i] && i == n-1){
                //     li.add(arr[i]);
                // }
                    
                }
            }
            
        }
        // System.out.println(fli);
        for(int j = 0;j<fli.size();j++){
            // System.out.println(fli.get(j) + "/" + mp.get(fli.get(j)));
            
            if(fli.get(j) == mp.get(fli.get(j))){
                System.out.println(mp.get(fli.get(j)));
            }
            else if( mp.get(fli.get(j))==null){
                System.out.println(fli.get(j));
            }
            else{
                System.out.println(fli.get(j) + "->" + mp.get(fli.get(j)));
            }
        }
        
        // System.out.println(mp);
    }
}
