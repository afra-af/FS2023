/*Somu is working on Machine Learning domain. He wants train the machine 
in such a way that, if he provided an image printed with a string on it,
the machine has to extract the text as a string and verify that, after shuffling 
the letters in the string, 'the shuffled string should be like no two adjacent 
letters should be same' 

You will be given extracted string, and
Can you help Somu to train the machine with the given constraint 
The machine has to print "true", if the constarint is met, 
Otherwise, print "false".


Input Format:
-------------
A String S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
aaabd

Sample Output-1:
----------------
true


Sample Input-2:
---------------
aaab

Sample Output-2:
----------------
false*

*/
import java.util.*; 
class KeyComparator implements Comparator<Key> { 
      public int compare(Key k1, Key k2) 
      { 
             if (k1.freq < k2.freq) 
                 return 1; 
             else if (k1.freq > k2.freq) 
                 return -1; 
             return 0; 
      } 
} 
  
class Key { 
      int freq; 
      char ch; 
      Key(int val, char c)  
      { 
          freq = val;  
          ch = c; 
      } 
} 
  
class test { 
      static int MAX_CHAR = 26;  
      static boolean rearrangeString(String str) 
      { 
             int n = str.length(); 
             int[] count = new int[MAX_CHAR]; 
               
             for (int i = 0; i < n; i++) 
                  count[str.charAt(i) - 'a']++; 
              PriorityQueue<Key> pq = new PriorityQueue<>(new 
                                                        KeyComparator()); 
              for (char c = 'a'; c <= 'z'; c++) { 
                   int val = c - 'a'; 
                   if (count[val] > 0) 
                       pq.add(new Key(count[val], c)); 
              } 
              str = "" ; 
              Key prev = new Key(-1, '#'); 
              while (pq.size() != 0) { 
                     Key k = pq.peek(); 
                     pq.poll(); 
                     str = str + k.ch;
                      
                     if (prev.freq > 0) 
                         pq.add(prev); 
                     (k.freq)--; 
                      prev = k; 
              }
              if (n != str.length()) 
                 return false;
              else
                  return true;
      }  
      public static void main(String args[]) 
      {  
Scanner sc=new Scanner(System.in);
             String str = sc.next(); 
             System.out.print(rearrangeString(str)); 
      } 
}
