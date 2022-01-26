/*You will be given a word 'w' and a group of words 'g'. 

check if 'w' can be broken into a space separated characters of one or more in the given group of words 'g'

Note the same word in the group of words may be re used multiple times in the breaking. 

The first line of input contains the group of words(g) followed by a word(w)

if it can done print true else print false

input=fleet gold
fleetgold
output=true

Explanation: prints true because fleetgold  can be broken as fleet gold

input=apple pen
applepenapple
output=true

Explanation: print true because "applepenapple" can be broken as "apple pen apple".
Note that you are allowed to reuse group of words

input=cats dogs and and cat
catsandog
output=false*/

mport java.util.*;
class Test1{
    static boolean isPresent(String s[],String str){
        int i=0;
        while(i<str.length()){
            int flag=0;
            for(int j=0;j<s.length;j++){
                if(str.charAt(i)==s[j].charAt(0)){
                    flag=1;
                    int n = s[j].length();
                    if(i+n>str.length()) return false;
                    else if(str.substring(i,i+n).equals(s[j])){
                        i = i+n;
                        break;
                    }
                    else return false;
                }
            }
            if(flag==0) return false;
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String str = sc.next();
        System.out.print(isPresent(s,str));
    }
}
