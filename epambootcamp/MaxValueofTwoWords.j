/* Rakesh is calculating maximum value of two words len(word[i]) * len(word[j])  where the words do not share common letters.

Note: if no such two words exist , return 0.

ex:
input =abcw baz foo bar xtfn abcdef
output =16
abcw and xtfn two words doesnot share common letters so output is 16

input =a ab abc d cd bcd abcd
output =4
ab cd two words doesnot share common

input =a aa aaa aaaa
output =0
no such pair of words
*/
import java.util.*;

public class test{
    static int  chars=26;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String [] s=str.split(" ");
        System.out.println(getMaxLength(s));
    }
    public static int getMaxLength(String[]words){
        int max=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                String w1=words[i];
                String w2=words[j];
                if(!wordProduct(w1,w2)){
                    int temp_max=(w1.length())*(w2.length());
                    max=Math.max(max,temp_max);
                }
            }
        }
        if(max==0){
            return 0;
        }
        return max;
    }
    public static boolean wordProduct(String s1,String s2){
        boolean [] values=new boolean[chars];
        Arrays.fill(values,false);
        for(int i=0;i<s1.length();i++){
                values[s1.charAt(i)-'a']=true;
        }
        for(int i=0;i<s2.length();i++){
            if(values[s2.charAt(i)-'a']) return true;
        }
        return false;
    }
}
