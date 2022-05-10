/*
Given a list of strings words and a string pattern, return a list of words[i] that match pattern. 
You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing 
every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps
to another letter, and 
no two letters map to the same letter.

Note: print output in ascending order of words

input =abc deq mee aqq dkd ccc
abb
ouput =aqq mee

words= abc deq mee aqq dkd ccc
pattern =abb
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
             "aqq" matches the pattern because there is a permutation {a -> a, b-> q}
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, 
since a and b map to the same letter.



Example 2:
input =a b c
a
ouput =a b c
*/
import java.util.*;
class test
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> res=new ArrayList<>();
        Map<Character,Integer> hm=new LinkedHashMap<>();
        String words[]=sc.nextLine().split(" ");
        String patt=sc.next();
        
        for(char c:patt.toCharArray())
        hm.put(c,hm.getOrDefault(c,0)+1);
        
        for(int i=0;i<words.length;i++)
        {
            ArrayList<Integer> al=new ArrayList<>(hm.values());
            if(check(words[i],patt,al))
            res.add(words[i]);
        }
        Collections.sort(res);
        for(String s:res)
        System.out.println(s);
    }
    public static boolean check(String s,String patt,ArrayList<Integer> al)
    {
        if(s.length()!=patt.length()) return false;
        
        Map<Character,Integer> hm=new LinkedHashMap<>();
            for(char c:s.toCharArray())
                hm.put(c,hm.getOrDefault(c,0)+1);
        
        for(char c:hm.keySet())
        {
            if(al.contains(hm.get(c)))
            al.remove(0);
        }
        if(al.size()==0)
        return true;
        else
        return false;
    }
}
