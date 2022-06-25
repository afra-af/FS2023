/*Write a program to read a value 'n' from the user and create two threads 
where one thread should print ODD if it not divisible by 2 and 
other thread should print EVEN if it is divisble by 2
Assume - 2,4,6,8 are EVEN 
	      1,3,5,7,9,11,13 and so on as ODD 
Implement a multithreaded version of EVEN ODD with two threads. 
The same instance of EvenOdd will be passed to two different threads:
1. Thread A(T1) will call printEven() to check for divisibility of 2 and outputs EVEN
2. Thread B(T2) will call printOdd() to check for not divisibility of 2 and outputs ODD .
input = 15  
output = ODD EVEN ODD EVEN ODD EVEN ODD EVEN ODD EVEN ODD EVEN ODD EVEN ODD
input = 5
output = ODD EVEN ODD EVEN ODD
Some Portion of code is given here. Write the remaining logic 
The Thread -T1 should have an Reference variable of EvenOdd class and 
that should be initialized with the help of a Parametrized Constructor and
also implement the code for run() method 
Similarly Implement Thread (T2);
Here the EvenOdd class has two methods printEven() and printOdd() they both are synchronized 
implement this method 
*/



import java.util.*; 
 
  class EvenOdd
 {
         int i,n;
	 EvenOdd(int n)
	 {
	 i=1;
	 this.n = n;
	 }
    public synchronized void printOdd()
     {
// write your code here
     try{
         while(i<=n){
             if(i%2!=0){
                 System.out.print("ODD ");
                 i=i+1;
                 notifyAll();
             }
             else
                wait();
         }
     }
     catch(Exception e){
         System.out.println(e.getMessage());
     }
    }
   public  synchronized void printEven()
     {
     // write your code here
     try{
         while(i<=n){
             if(i%2==0){
                 System.out.print("EVEN ");
                 i=i+1;
                 notifyAll();
             }
             else{
                 wait();
             }
         }
     }
     catch(Exception e){
         System.out.println(e.getMessage());
     }
     
     }
 }
 
 class T1 implements Runnable
 {
  EvenOdd eo;
  T1(EvenOdd eo){
      this.eo=eo;
  }
  public void run(){
      eo.printEven();
  }
 }
 
 class T2 implements Runnable
 {
 
  EvenOdd eo;
  T2(EvenOdd eo){
      this.eo=eo;
  }
 public void run(){
     eo.printOdd();
 }
 }

 class Test
 {
     public static void main(String args[])
     {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	EvenOdd obj1 = new EvenOdd(n);
	 T1 t1=new T1(obj1);
     T2 t2=new T2(obj1);
     Thread th1=new Thread(t1);
     th1.start();
     Thread th2=new Thread(t2);
     th2.start();
     
         
     }
 }
