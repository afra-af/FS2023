/*
Given a class name Candidate which implements Comparable interface. 
In Candidate class there fields present.
private String name;'
private String marks;
and you have given a list of Object type Candidate which is unsorted.
You need to initialise the constructor and overwrite the compareTo method so that after using collections.sort(list)
should be sorted in ascending order based on marks.


use template and uncomplete code snipped:

class Candidate implements Comparable<Candidate>
{
  private String name;
  private int marks;

   public Candidate(String name, int marks){
     // write your code here

   }
}
*/




import java.util.*;

class Candidate implements Comparable<Candidate>{
    private String name;
    private int marks;

    public Candidate(String name, int marks){
        this.setName(name);
        this.setMarks(marks);
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setMarks(int marks){
        this.marks = marks;
    }
    
    public int getMarks(){
        return marks;
    }
    
    @Override
    public int compareTo(Candidate candidate){
        return this.marks - candidate.marks;
    }
}

public class Day53Program2{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        List<Candidate> l = new LinkedList<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < n; i++){
            String name = scanner.next();
            int marks = scanner.nextInt();
            l.add(new Candidate(name, marks));
        }
        Collections.sort(l);
        for(Candidate c: l){
            System.out.println(c.getName() + " " + c.getMarks());
        }
    }
}
