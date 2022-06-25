/*
Given a string s, return the number of palindromic substrings in it.
example:
input =abc
output =3
three palindromic strings are a b c
input =aaa
output =6
six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/
import java.util.*;
class Test
{
    static int count = 1;
    public static int Count(String s)
    {
        if(s.length()==0)
            return 0;
        for(int i = 0; i<s.length()-1; i++)
        {
            check(s, i, i);
            check(s, i, i+1);
        }
        return count;
    }
    public static void check(String s, int i, int j)
    {
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j))
        {
            count++;
            i--;
            j++;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(Count(s));
    }
}
