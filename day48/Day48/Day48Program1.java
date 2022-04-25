/*
DPS school will run school buses from one location to 
differnt locations(ie routes) where 
routes[i]=[locationA, locationB]
Given n routes return the last stop location of the school bus. 

input =3
nagole uppal
uppal habsiguda
habsiguda nacharam

output =nacharam
Explanation: Starting at "nagole" busses will reach "nacharam" 
which is the last stop. bus route consist of "nagole" -> "uppal" -> "habsiguda" -> "nacharam".


input =3
tarnaka narayanaguda
uppal tarnaka
narayanaguda mahenderahills
output =mahenderahills

Explanation: All possible routes are:
uppal-> tarnaka -> narayanaguda->mahenderahills or
tarnaka -> narayanaguda -> mahenderahills
narayanaguda -> mahenderahills


*/

import java.util.*;

class Day48Program1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        List<String> li1 = new ArrayList<>();
        List<String> li2 = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            li1.add(sc.next());
            li2.add(sc.next());
        }sc.close();
        // System.out.println(li1);
        // System.out.println(li2);
        for(int j = 0;j<n;j++){
            String temp = li2.get(j);
            if(!li1.contains(temp)){
                System.out.println(temp);
                break;
            }
        }
    }
    
}
