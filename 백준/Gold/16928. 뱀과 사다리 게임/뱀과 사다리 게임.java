import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M;
    static int[] board;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new int[101];
        
        for(int i = 1; i <= 100; i++) board[i] = i;
        
        for(int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            board[from] = to;
        }
        
        System.out.println(bfs(1));
    }
    
    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int[] count = new int[101];
        
        q.add(start);
        count[start] = 0;
        
        while(true) {
            int x = q.poll();
            
            for(int i = 1; i <= 6; i++) {
                int next = x + i;
                
                if(next > 100) continue;
                if(count[board[next]] != 0) continue;
                
                q.add(board[next]);
                count[board[next]] = count[x] + 1;
                
                if(board[next] == 100) {
                    return count[100];
                }
            }
        }
    }
}