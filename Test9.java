/*Ramu is playing with two strings s1 and s2. he wants to construct the newString in the following way.

   -- if s1 is not empty append the first character in s1 to newString and delete it from s1.
     example: if s1=abc and newString=de, then after choosing this operation, s1=bc and newString =dea
   -- if s2 is not empty append the first character in s2 to newString and delete it from s2.
      example: if s2=abc and newString="" then after choosing this operation, 
      s2=bc and newString= a
  Note: return the lexicographically largest newString ramu need to construct

example 1:
intput =
cabaa
bcaaa
output =cbcabaaaaa

 
Explanation: One way to get the lexicographically largest newString is:
- take from s1: newString = "c", s1 = "abaa", s2 = "bcaaa"
- Take from s2: newString = "cb", s1 = "abaa", s2 = "caaa"
- Take from s2: newString = "cbc", s1 = "abaa", s2 = "aaa"
- Take from s1: newString = "cbca", s1 = "baa", s2 = "aaa"
- Take from s1: newString = "cbcab", s1 = "aa", s2 = "aaa"

- Append the remaining 5 a's from s1 and s2 at the end of newString.

    
input= abcabc
abdcaba
output =abdcabcabcaba */
import java.util.*;
class Test9
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        int x=0,y=0;
        StringBuffer sb=new StringBuffer("");
        while(x<s1.length()&&y<s2.length())
        {
        if(s1.charAt(x)>s2.charAt(y))
        {
        sb.append(s1.charAt(x));
        x++;
        }
        else if(s1.charAt(x)==s2.charAt(y))
        {
            if(findWhoIsLarge(s1,s2,sb,x,y))
            {
                sb.append(s1.charAt(x));  x++;
            }
            else
            {
            sb.append(s2.charAt(y)); y++;
            }   
        }
        else
            {
            sb.append(s2.charAt(y));
        y++;
            }
            
        }  //while close
        
        if(x!=s1.length()-1)
        sb.append(s1.substring(x));
        if(y!=s2.length()-1)
        sb.append(s2.substring(y));
        
        System.out.println(sb);
    }
    public static boolean findWhoIsLarge(String s1,String s2,StringBuffer sb,int x,int y)
    {
        int i=x;
        int j=y;
        int len1=s1.length();
        int len2=s2.length();
        
        while(i<len1&&j<len2&&s1.charAt(i)==s2.charAt(j))
        {
            i++; j++;
        }
        if(i<len1&&j<len2&&s1.charAt(i)>=s2.charAt(j))
            return true;
        return false;
    }
}
