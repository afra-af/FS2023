/*Given an array nums with n objects three chocolates, cadbury , nestle, amul, sort them in-place so that objects of the same kind of chocolates are adjacent, with the type in the order cadbury , nestle , amul

you must solve the problem without using library's sort funtion.

ex:
input = 6
amul cadbury amul nestle nestle cadbury
output =cadbury cadbury nestle nestle amul amul

input =3
amul cadbury nestle
output =cadbury nestle amul */
import java.util.*;
class test
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for(int i=0;i<s.length;i++)
        {
            s[i]=sc.next();
        }
        String[] fs = {"cadbury","nestle","amul"};
        //ArrayList<String> a=new ArrayList<>(Arrays.asList(s));
        int[] f = count(s);
        for(int i=0;i<3;i++)
        {   int j=f[i];
            while(j>0)
            {   j=j-1;
                System.out.print(fs[i]+" ");
            }
        }
    }
    public static int[] count(String[] s)
    {   
        int[] f = new int[3];
        Arrays.fill(f,0);
        for(int i=0;i<s.length;i++)
        { if(s[i].equals("cadbury"))
         {  
            f[0]=f[0]+1;
         }
         else if(s[i].equals("nestle"))
         {
            f[1]=f[1]+1;
         }
         else if(s[i].equals("amul"))
         {
             f[2]=f[2]+1;
         }
        }
        return f;
    }
}

