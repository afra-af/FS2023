/*
given a mxn matrix and given source cell and destination cell.
find the shortest path between a given source cell to destination celll. 

ex:
input =3 3 
1 1 1
1 1 1
1 1 1
0 0
2 2
output=4

input =5 5
1 0 0 1 1
1 0 0 1 1
1 0 0 1 0
1 1 1 1 1
1 1 0 1 1 
4 1
0 4   
output =7


*/
import java.util.*;

public class Test{
    
    public static int m;
    public static int n;
    
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = scanner.nextInt();
            }
        }
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        scanner.close();
        System.out.println(minShortestPathLength(grid, i, j, x, y));
    }
    
    public static int minShortestPath(int[][] grid, boolean[][] visited,int i, int j, int x, int y, int min_dist, int dist){
        if(i == x && j == y) return Math.min(dist, min_dist); 
        visited[i][j] = true;
        if(isValidMove(grid, visited, i + 1, j)){
            min_dist = minShortestPath(grid, visited, i + 1, j, x, y, min_dist, dist + 1);
        }
        if(isValidMove(grid, visited, i, j + 1)){
            min_dist = minShortestPath(grid, visited, i, j + 1, x, y, min_dist, dist + 1);
        }
        
        if(isValidMove(grid, visited, i - 1, j)){
            min_dist = minShortestPath(grid, visited, i - 1, j, x, y, min_dist, dist + 1);
        }
        
        if(isValidMove(grid, visited, i, j - 1)){
            min_dist = minShortestPath(grid, visited, i, j - 1, x, y, min_dist, dist + 1);
        }
        visited[i][j] = false;
        return min_dist;
    }
    
    public static int minShortestPathLength(int[][] grid, int i, int j, int x, int y){
        if(grid == null || m == 0 || n == 0 || grid[x][y] == 0) return -1;
        int min_dist = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[m][n];
        min_dist = minShortestPath(grid, visited, i, j, x, y, min_dist, 0);
        return (min_dist !=  Integer.MAX_VALUE)? min_dist: -1;
    }
    
    public static boolean isValidMove(int[][] grid, boolean[][] visited, int row, int col){
        return (row >= 0 && row < m  && col >= 0 && col < n && grid[row][col]  == 1 && !visited[row][col]); 
    }
}
