/*
Write a program to print the following pattern 
input = 3
output =
AAAAAA
BAAAAB
BBAABB
BBAABB
BAAAAB
AAAAAA
input = 6
output = 
AAAAAAAAAAAA
BAAAAAAAAAAB
BBAAAAAAAABB
BBBAAAAAABBB
BBBBAAAABBBB
BBBBBAABBBBB
BBBBBAABBBBB
BBBBAAAABBBB
BBBAAAAAABBB
BBAAAAAAAABB
BAAAAAAAAAAB
AAAAAAAAAAAA
*/

import java.util.*;
class program{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            if(i==1){
            for(int j=1;j<=n*2;j++) 
                System.out.print("A");
            }
            else{
                for(int j=2;j<=i;j++)
                   System.out.print("B");
                for(int x=1;x<=2*(n-(i-1));x++)
                    System.out.print("A");
                for(int k=2;k<=i;k++)
                    System.out.print("B");
                    
            }
            System.out.println();
        } 
        for(int i=n;i>=1;i--){
            if(i==1){
                for(int j=1;j<=n*2;j++){
                    System.out.print("A");
                }
            }
            else{
                for(int j=2;j<=i;j++){
                    System.out.print("B");
                }
                for(int x=1;x<=2*(n-(i-1));x++){
                    System.out.print("A");
                }
                for(int k=2;k<=i;k++){
                    System.out.print("B");
                }
            }
            System.out.println();
        }
    }
}
