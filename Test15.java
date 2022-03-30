/*Given a array of "array of words" and "characters", 
find the sum of length of all nice words using those characters.

nice word: a word is nice, if it can be formed by characters.

example: 

input =cat bt hat tree
atach
output=6

The words that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

input =apple orange bat tree
atbeppol */
import java.util.*;
class Test{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String str=sc.next();
        //int count=0;
        int res=0;
        String[] arr=s.split(" ");
        ArrayList<Character> al=new ArrayList<>();
        for(char c:str.toCharArray()){
            al.add(c);
        }
        for(String a:arr){
            int count=0;
            for(int i=0;i<a.length();i++){
            if(al.contains(a.charAt(i))){
            count++;
        }
        }
        if(count==a.length()){
            res=res+count;
        }
        }
        System.out.println(res);
        
    }
}
output =8 */
import java.util.*;
class Test{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String str=sc.next();
        //int count=0;
        int res=0;
        String[] arr=s.split(" ");
        ArrayList<Character> al=new ArrayList<>();
        for(char c:str.toCharArray()){
            al.add(c);
        }
        for(String a:arr){
            int count=0;
            for(int i=0;i<a.length();i++){
            if(al.contains(a.charAt(i))){
            count++;
        }
        }
        if(count==a.length()){
            res=res+count;
        }
        }
        System.out.println(res);
        
    }
}
