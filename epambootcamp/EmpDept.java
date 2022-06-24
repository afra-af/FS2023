/*
create a Employee Class and Department Class with the following 
instance variables.

Employee-
Eno-int
Ename-string
Esal-int
Dno-int
Comm-int
YOE-int


Department
Dno-int
Dname-string
Dloc-string

create necessary constructor and setters/getters

Write a Main Class to read a set of n Employee records 
and Department records

You are now supposed to do the following 

1) Display the Number of Employees for a particular department
2) Display the Sum of Salaries of given Department No. 
3) Display the Department name who is drawing highest salary.

Read the Department Records size followed by Department Records 
followed by Employee Records size and Employee Records.



input = 4
10 IT Hyd
20 FN Pune
30 AD BLR
40 HR Sec
5
101 abc 5000 10 400 2
102 tyz 6000 20 500 17
103 hyz 8000 30 600 22
104 ryz 16000 40 700 3
105 kyz 9000 10 800 12
10
20
output = 2
6000
HR

*/
import java.util.*;
class Emp{
    int eno;
    String ename;
    int esal;
    int dno;
    int comm;
    int YOE;
    Emp(int eno,String ename,int esal,int dno,int comm,int YOE){
        this.eno = eno;
        this.ename = ename;
        this.esal = esal;
        this.dno = dno;
        this.comm = comm;
        this.YOE = YOE;
    }
}
class Dept{
    int dno;
    String dname;
    String dloc;
    Dept(int dno,String dname,String dloc){
        this.dno = dno;
        this.dname = dname;
        this.dloc = dloc;
    }
}
class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=0;
        ArrayList<Dept> deptal = new ArrayList<>();
        while(i<n){
            Dept dept = new Dept(sc.nextInt(),sc.next(),sc.next());
            deptal.add(dept);
            i++;
        }
        i=0;
        n = sc.nextInt();
        ArrayList<Emp> empal = new ArrayList<>();
        while(i<n){
            Emp emp = new Emp(sc.nextInt(),sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
            empal.add(emp);
            i++;
        }
        int dnum = sc.nextInt();
        int sumsal = sc.nextInt();
        int deptno=0;
        int c=0,sum=0,max=Integer.MIN_VALUE,highsal=0;String hdname="";
        for(Emp emp:empal){
            if(emp.dno == dnum){
                c++;
            }
            if(emp.dno == sumsal){
                sum+=emp.esal;
            }
        }
        for(Emp emp:empal){
            if(emp.esal>max){
                max=emp.esal;
                highsal=emp.dno;
            }
        }
        for(Dept dept:deptal){
            if(dept.dno==highsal){
                hdname = dept.dname;
                break;
            }
        }
        System.out.println(c);
        System.out.println(sum);
        System.out.println(hdname);
    }
}
