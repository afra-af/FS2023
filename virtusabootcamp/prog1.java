/*kapoor's have brought a tiny kitten in their house. Everybody is excited to give her a name.
but Mr.kapoor has a condition for the name ie there should be no duplicate adjacent character in the name.
but relatives were not aware of this condition and they have already sent some names.

Now your task is to minimize the given name according to the condition so that it can be accepted by mr.kapoor.

example: 
input =cherreis
output =chis

in cherreis first rr is removed, now the string is cheeis again 2 duplicate e's are coming, so after removing it output is chis, which can't be minimized further.

if final output is empty return -1. */
import java.util.*;

public class Day53Program1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder(sc.next());
        StringBuilder fs = new StringBuilder(check(s));
        
        if(fs.length() == 0){
           System.out.println("-1");
       }
       else{
           System.out.println(fs);
       }
        
    }
    public static StringBuilder check(StringBuilder s){
        for(int i = 0;i<s.length() - 1;i++){
             if(s.charAt(i) == s.charAt(i+1)){
            s=s.replace(i,i+2,"");
            check(s);
             break;
        }
    }
       
       return s;
    
    }
}

