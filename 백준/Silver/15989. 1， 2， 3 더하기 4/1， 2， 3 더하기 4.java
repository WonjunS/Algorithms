import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] Dy;
    
    static void preprocess() {
        Dy = new int[10001][4];
        Dy[1][1] = 1;
        Dy[1][2] = 0;
        Dy[1][3] = 0;
        Dy[2][1] = 1;
        Dy[2][2] = 1;
        Dy[2][3] = 0;
        Dy[3][1] = 1;
        Dy[3][2] = 1;
        Dy[3][3] = 1;
        
        for(int i = 4; i <= 10000; i++) {
            Dy[i][1] = Dy[i - 1][1];
            Dy[i][2] = Dy[i - 2][1] + Dy[i - 2][2];
            Dy[i][3] = Dy[i - 3][1] + Dy[i - 3][2] + Dy[i - 3][3];
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        preprocess();
        
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int total = Dy[N][1] + Dy[N][2] + Dy[N][3];
            sb.append(total).append('\n');
        }
        
        System.out.println(sb);
    }
}