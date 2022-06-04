/*ajith is playing a game to find a words ,if he found the word return true othere wise return false.

for example:

input =
3 3
a b c
d e a
l m t
cat
output =true

Note: 
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells 
are horizontally or vertically neighboring. The same letter cell may not be used more than once.


example:2
input =3 4
a b c e
s f c s
a d e f
abcced
output =true


input =3 4
a b c e
s f c s
a d e e
see
output =true

input =4 4
a b c d
e f g h
i j k l
m n o p
abcdhlkjfm
output =false
*/
 import java.util.*;
class Test{
    public static boolean checkWord(char[][] board,String s){
        int r = board.length;
        int c = board[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(s.charAt(0)==board[i][j]&&helper(i,j,0,s,board)) return true;
            }
        }
        return false;
    }
    public static boolean helper(int i,int j,int idx,String s,char[][] board){
        if(idx==s.length()){
            return true;
        }
        if(i<0 || j<0 || i>= board.length || j>=board[0].length || s.charAt(idx)!=board[i][j] || board[i][j]=='*'){
            return false;
        }
        char temp = board[i][j];
        board[i][j]='*';
        if(helper(i+1,j,idx+1,s,board)||helper(i-1,j,idx+1,s,board)||helper(i,j+1,idx+1,s,board)||helper(i,j-1,idx+1,s,board)){
            return true;
        }
        board[i][j]=temp;
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        char[][] board = new char[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                board[i][j]=sc.next().charAt(0);
            }
        }
        String s = sc.next();
        System.out.println(checkWord(board,s));
    }
}
