/*Somu a Printing Press Man wants to print few words on a given plain paper. 
He is a selfish man and doesnt want to waste the papers. 
Intially he will be given the height and width size of the paper.
He wants to see how many times the few words can be printed on the plain paper. 

The order of the characters should remain same,and he cannot break the word and print it into two lines 
A white space should separate two words in a line

The first line of input contains the words followed by height and width size of the paper. 

If he is not able to print on the given paper atlease once then print 0

input=hello world
2 8
output=1

Explanation:
hello_ _ _
world_ _ _

He can print only one time on the given plain white paper


input=b efg h 
3 6
output=2

Explanation:
b_efg _
h_b_ _ _ 
efg_h */

import java.util.*;

class test4{
    public static int timesWordsPrinted(String[] words,int height,int weight){
        int count=words.length;
        int space=height*weight;
        for(String s:words){
            count+=s.length();
        }
        if(count>space) return 0;
        return space/count;
        
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String[] words=sc.nextLine().split(" ");
        int height=sc.nextInt();
        int weight=sc.nextInt();
        System.out.print(timesWordsPrinted(words,height,weight));
    }
}
