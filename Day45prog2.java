/*
Amazon Fire TV Stick Remote

Tinku a Small Kid is playing with the Amazon Fire TV Stick Remote
Tinku is not familar with the alphabets. 
He father gives him few alphabets and asks Tinku to type it. 
Tinku uses only one finger. 
At the Beginining, he will put his finger at the the 1st key, k[0];
To type the Next Alphabet he has to move his finger from that key(m) 
to that particular alphabet(n) he takes |m-n| seconds. 

Help Tinkus Father to see how much seconds does Tinku take to type the given alphabets.


input=poiuytrewqasdfghjklmnbvcxz
kmit
output=39


input=abcdefghijklmnopqrstuvwxyz
code
output=26
*/
import java.util.*;
public class Day45prog2
{
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		String s = sc.next();
		String st = sc.next();int sum=s.indexOf(st.charAt(0));
	    for(int i=0;i<st.length()-1;i++)
	    {
	        sum+=Math.abs((s.indexOf(st.charAt(i)))-(s.indexOf(st.charAt(i+1))));
	    }
	    System.out.println(sum);
	    
	}
}
