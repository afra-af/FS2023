/*
A set of computers connected with each other and formed a network with the 
following rule, one computer can directly connected with atmost two computers only.
Each computer is assigned with an ID, the computer ID's may be repeated.
You are given the entire network as a tree.
Your task is to form the network IDs as a single string with
preorder traversal technique. The network ID should be enclosed in brackets [ ],
Empty connection or No connection represented with [].
You need to omit all the empty bracket pairs that don't affect the one-to-one 
mapping relationship between the string and the original network.
Implement the class Solution:
   1. public String networkToString(BinaryTreeNode t) : returns a String.
NOTE: in the input tree, consider -1 as 'No Connection'.
Input Format:
-------------
Single line of space separated integers, network ID's in the form the tree.
Output Format:
--------------
Print a string, as described in sample.
Sample Input-1:
---------------
6
2 5 2 3 4 2
    2
   / \
  5   2
 / \  / 
3  4  2
Sample Output-1:
----------------
2[5[3][4]][2[2]]
Sample Input-2:
---------------
7
2 5 2 -1 -1 -1 3
    
    2
   /  \
  5    2
        \
	     3
Sample Output-2:
----------------
2[5][2[][3]]
    1
   / \
  2   3
 /
4
input =4
1 2 3 4
root = [1,2,3,4]
output = 1[2[4]][3]
Explanation: Originally, it needs to be "1[2[4][]][3[][]]", 
but you need to omit all the unnecessary empty parenthesis pairs. And it will be "1[2[4]][3]"
Example 2:
input =5
1 2 3 null 4
output =1[2[][4]][3]
root = 1 2 3 null 4
Output: "1[2[][4]][3]"
Explanation: Almost the same as the first example, except we cannot omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
*/
import java.util.*;

class BinaryTreeNode{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data){
		this.data = data; 
		left = null; 
		right = null; 
	}
}

class Solution {
 public String networkToString(BinaryTreeNode t) {
      // write your code here
      if(t==null){
          return "";
      }
      String res=t.data!=-1?String.valueOf(t.data):"";
      String left=networkToString(t.left);
      String right=networkToString(t.right);
      if(!right.equals("")){
          res+="["+left+"]["+right+"]";
      }
      else if(!left.equals("")){
          res+="["+left+"]";
      }
     return  res;
 }
}
public class ConstructString{
	static BinaryTreeNode root;
	static BinaryTreeNode temp = root;
	void insert(BinaryTreeNode temp, int key)
    {
 
        if (temp == null) {
            root = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(temp);
 
        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
 
            if (temp.left == null) {
                temp.left = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String str[]=sc.nextLine().split(" ");
		ConstructString cs=new ConstructString();
		root=new BinaryTreeNode(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			cs.insert(root,Integer.parseInt(str[i]));
		Solution sol= new Solution();
		System.out.println(sol.networkToString(root));
	}
}
