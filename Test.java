/* 
Door Numbering


Shyam is building an application where he wants to write the numbers of the doors in a special way . 
He will use the 7 different symbols (I,V,X,L,C,D,M)
Each symbol will have the value 
(I-1,V-5,X-10,L-50,C-100,D-500,M-1000)

For example, 2 is written as II , just two one's added together. 
12 is written as XII , which is simply X + II .
The number 27 is written as XXVII , which is XX + V + II .

Rules followed
The numbers  are usually written largest to smallest from left to right. 
However, the numeral for four is not IIII . Instead, the number four is written as IV . 
Because the one is before the five we subtract it making four. 
The same principle applies to the number nine, which is written as IX . 

There are six instances where subtraction is used:
• I can be placed before V (5) and X (10) to make 4 and 9.
• X can be placed before L (50) and C (100) to make 40 and 90.
• C can be placed before D (500) and M (1000) to make 400 and 900.

input=3
output=III


input=45
output=XLV


input=88
output=LXXXVIII
*/
import java.util.*;
class Test{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(Numeric_to_Roman(n));
    }
    static String Numeric_to_Roman(int n){
        int[] num_values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] corresp_roman={"M","CM","D","CD","C","XC","L","XL","X","IX","V","VI","I"};
        StringBuilder roman_no=new StringBuilder();
        for(int i=0;i<num_values.length;i++){
            while(n>=num_values[i]){
                n-=num_values[i];
                roman_no.append(corresp_roman[i]);
            }
        }
        return roman_no.toString();
    }
