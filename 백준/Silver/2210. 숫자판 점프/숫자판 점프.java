import java.util.*;
import java.io.*;

public class Main {

    private static int N = 5, M = 5;
    private static List<String> list;
    private static String[][] map;
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        list = new ArrayList<>();

        map = new String[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < M; j++) {
                map[i][j] = st.nextToken();
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                new Main().dfs(map[i][j], i, j);
            }
        }
        
        System.out.println(list.size());
    }

    private void dfs(String number, int x, int y) {
        if(number.length() == 6) {
            if(!list.contains(number)) {
                list.add(number);
            }
            return;
        }

        for(int k = 0; k < 4; k++) {
            int nx = x + dirs[k][0];
            int ny = y + dirs[k][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            dfs(number + map[nx][ny], nx, ny);
        }
    }
    
}