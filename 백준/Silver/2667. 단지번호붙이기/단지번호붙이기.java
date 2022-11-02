import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, group_cnt;
    static String[] a;
    static boolean[][] visit;
    static ArrayList<Integer> group;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N][N];
        a = new String[N];
        for(int i = 0; i < N; i++) {
            a[i] = br.readLine();
        }
    }

    static void bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        group_cnt = 0;

        while(!q.isEmpty()) {
            x = q.poll();
            y = q.poll();

            for(int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(a[nx].charAt(ny) == '0') continue;
                if(visit[nx][ny]) continue;
                visit[nx][ny] = true;
                q.add(nx);
                q.add(ny);
                group_cnt++;
            }
        }
    }
    
    static void dfs(int x, int y) {
        group_cnt++;
        
        visit[x][y] = true;
        
        for(int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(a[nx].charAt(ny) == '0') continue;
            if(visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void pro() {
        group = new ArrayList<Integer>();
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visit[i][j] && a[i].charAt(j) == '1') {
                    group_cnt = 0;
                    dfs(i, j);
                    group.add(group_cnt);
                }
            }
        }
        sb.append(group.size()).append('\n');
        Collections.sort(group);
        for(int n : group) sb.append(n).append('\n');
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}