import java.util.*;
import java.io.*;

public class Main {
    
    private static int N;
    private static char[][] map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        
        map = new char[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = '*';
            }
        }
        
        draw(N / 3, N / 3, N / 3);
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
    private static void draw(int x, int y, int L) {
        if(L == 0) {
            return;
        }
        
        for(int i = x; i < x + L; i++) {
            for(int j = y; j < y + L; j++) {
                map[i][j] = ' ';
            }
        }
        
        int len1 = L / 3;
        int len2 = (L / 3) * 2;
        draw(x - len2, y - len2, L / 3);
        draw(x - len2, y + len1, L / 3);
        draw(x - len2, y + L + len1, L / 3);
        
        draw(x + len1, y - len2, L / 3);
        draw(x + len1, y + L + len1, L / 3);
        
        draw(x + L + len1, y - len2, L / 3);
        draw(x + L + len1, y + len1, L / 3);
        draw(x + L + len1, y + L + len1, L / 3);
    }
    
}