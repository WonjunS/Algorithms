import java.util.*;
import java.io.*;

public class Main {
    
    private static int[][] map;
    private static int count = 0;
    private static int M = 0, N = 0, K = 0;
    private static final int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static List<Integer> areas = new ArrayList<>();

    private static void bfs(int x, int y) {
        int size = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        
        while(!q.isEmpty()) {
            x = q.poll();
            y = q.poll();
            size++;
            map[x][y] = -1;
            for(int i = 0; i < 4; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(map[nx][ny] != 0) continue;
                
                map[nx][ny] = -1;
                q.add(nx);
                q.add(ny);
                
            }
        }

        areas.add(size);
        
        count++;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[M][N];

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = 0;
            }
        }
        
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for(int j = x1; j < x2; j++) {
                for(int k = y1; k < y2; k++) {
                    map[k][j] = 1;
                }
            }
        }

        // for(int i = 0; i < M; i++) {
        //     for(int j = 0; j < N; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] != 0) {
                    continue;
                }
                bfs(i, j);
            }
        }
        
        System.out.println(count);

        int[] arr = new int[areas.size()];
        for(int i = 0; i < areas.size(); i++) {
            arr[i] = areas.get(i);
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
   
    
}