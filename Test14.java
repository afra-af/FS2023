/*Given a word w, return the number of substrings with out duplicate characters of length 3 in w.

ex: 
input =xyzzaz
output =1
there are 4 substrings of size 3
xyz, yzz,zza,zaz
out of this only xyz has no duplicate characters so print 1.


ex:
input =aababcabc
ouput =4

there are 7 substrings of size 3
aab,aba,bab,abc,bca,cab,abc
from the above abc,bca,cab,abc are having unique characters. */
import java.util.*;
class Test14{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int count=0;
        for(int i=0;i<s.length()-2;i++){
        
            HashSet<Character> hs=new HashSet<>();
            for(int j=i;j<i+3;j++){
                
                hs.add(s.charAt(j));
            }
            if(hs.size()==3){
                count++;
            }
        }
        System.out.println(count);
    }
}
