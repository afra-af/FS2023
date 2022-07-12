/*
Somu is working on Machine Learning domain. He wants train the machine 
in such a way that, if he provided an image printed with a string on it,
the machine has to extract the text as a string and verify that, after shuffling 
the letters in the string, 'the shuffled string should be like no two adjacent 
letters should be same' 
You will be given extracted string, and
Can you help Somu to train the machine with the given constraint 
The machine has to print "true", if the constarint is met, 
Otherwise, print "false".
Input Format:
-------------
A String S
Output Format:
--------------
Print a boolean value.
Sample Input-1:
---------------
aaabd
Sample Output-1:
----------------
true
Sample Input-2:
---------------
aaab
Sample Output-2:
----------------
false
*/

import java.util.*;
class program{
    public static boolean yesorno(char[] str){
        Map<Character,Integer> freq=new HashMap<>();
        int max=0;
        for(int i=0;i<str.length;i++){
            if(freq.containsKey(str[i])){
                freq.put(str[i],freq.get(str[i])+1);
                if(freq.get(str[i])>max)
                    max=freq.get(str[i]);
            }
            else{
                freq.put(str[i],1);
                if(freq.get(str[i])>max){
                    max=freq.get(str[i]);
                }
            }
        }
        if(max<=(str.length-max+1))
            return true;
        return false;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        char []str=s.toCharArray();
        System.out.print(yesorno(str)?true:false);
    }
}
