import java.io.*;
import java.util.*;

public class Main {
    static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    static class Point {
        Point(int r, int c, int d) {
            row = r;
            col = c;
            dist = d;
        }
        int row, col, dist;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] Board = new int[n + 1][m + 1];
        
        for(int i = 1; i <= n; i++) {
        	String num = br.readLine();
            for(int j = 1; j <= m; j++) {
                Board[i][j] = Character.getNumericValue(num.charAt(j - 1));
            }
        }
        
        System.out.println(bfs(Board, n, m));
    }
    
    static int bfs(int[][] Board, int n, int m) {
        boolean[][] visited = new boolean[n + 1][m + 1];
        Queue<Point> myqueue = new LinkedList<>();
        visited[1][1] = true;
        myqueue.add(new Point(1, 1, 1));
        
        while(!myqueue.isEmpty()) {
            Point curr = myqueue.remove();
            if(curr.row == n && curr.col == m) {
                return curr.dist;
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = curr.row + D[i][0], nc = curr.col + D[i][1];
                if(nr < 1 || nr > n || nc < 1 || nc > m) continue;
                if(visited[nr][nc]) continue;
                if(Board[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                myqueue.add(new Point(nr, nc, curr.dist + 1));
            }
        }
        return -1;
    }
}