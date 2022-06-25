/*
Tarun is working with Strings.
He will be given two words, in which he has to break each word into two parts
First Word- W1+W2
Second Word - W3+W4 
After breaking each word into two parts, check if the new word can formed in such a way that,
W1+W4 or W2+W3 should be same from left to right (or) right to left. 
if it can be done print 'yes' else print 'no' 
Note - Breaking the words should be done at same index position
When you break a string 's' into s1 and s2 , either s1 or s2 is allowed to be empty. 
For example, if s ="abc" , then "" + "abc" , "a" + "bc" , "ab" + "c" , and "abc" + "" are valid breaks.
input =mortal carrom
output = yes
Break First word ="mortal" and Second word ="carrom" at index 3 as follows:
    First word -> "mor" + "tal", W1 = "mor" and W2 = "tal"
    Second word -> "car" + "rom", W3 = "car" and W4 = "rom"
W1 + W4 = "morrom" is a same from left to right and right to left,so print yes
input =romans carrom
output = no 
*/
import java.util.*;
class Test{
    public static String word_break(String s1,String s2){
        int flag=0;
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        if(s1.length()!=s2.length()){
            return "no";
        }
        for(int i=0;i<s1.length();i++){
           sb1=new StringBuilder(s1.substring(0,i)+s2.substring(i)); 
           sb2=new StringBuilder(s1.substring(i)+s2.substring(0,i));
           if(isrev(sb1)||isrev(sb2)){
               flag=1;
           }
        }
        if(flag==1){
            return "yes";
        }
        return "no";
    }
    public static boolean isrev(StringBuilder s1){
        StringBuilder sbt=new StringBuilder(s1.toString());
        StringBuilder sbt2=new StringBuilder(sbt);
        if(sbt.toString().equals(sbt2.reverse().toString())){
            return true;
        }
        return false;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        System.out.print(word_break(s1,s2));
    }
}
