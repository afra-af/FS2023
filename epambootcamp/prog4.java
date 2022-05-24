/*
Ramesh is playing a game with two numbers,that he had to change one to another. 
but then he has given a set of other numbers, using these numbers he can allowed
to changed step by step by changing one digit in the number each time in the number.

You have to predict how many turns he will take to change first number to 
second number. 

If it is impossible to change there, print -1.

Input Format:
Two strings in first two lines as numbers
N represents the  number of other set of numbers and followed by other numbers.

Output Format:
Single line denoting the minimum number of steps

input =
101 123 
5
111
132
122
131
145
output =4
Explanation:
101 -> 131 -> 132 -> 122 -> 123
4 changes needed.


input = 100 105
5
101
102
103
104
105
output =2
Explanation:
101 ->105
*/import java.util.*;
class test
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int n = sc.nextInt();
        String arr[] = new String[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.next();
        Queue<String> q = new LinkedList<>();
        Map<String,Boolean> m = new HashMap<>();
        for(int i=0;i<n;i++)
            m.put(arr[i],false);
        q.add(s1);
        int c=0;
        while(!q.isEmpty())
        {
            String s = q.remove();
            int qsize = q.size();
            if(check(s,s2))
            {
                System.out.print(c+1);
                return;
            }
            for(int i=0;i<n;i++)
            {
                if(!m.get(arr[i]))
                {
                    if(check(s,arr[i]))
                    {
                        q.add(arr[i]);
                        m.put(arr[i],true);
                    }
                }       
            }
            if(qsize<q.size())
                c++;
        }
    }
    public static boolean check(String a1,String a2)
    {
        int m = a1.length();
        int count=0;
        for(int i=0;i<m;i++)
        {
            if(a1.charAt(i)!=a2.charAt(i))
                count++;
        }
        if(count==1)
            return true;
        return false;
    }
}
