import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, R;
    private static int[][] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(str[j]);
            }
        }

        while(R-- > 0) {
            int x1 = 0;
            int x2 = M - 1;
            int y1 = 0;
            int y2 = N - 1;

            int[][] temp = new int[N][M];
            while(true) {
                if(x1 > x2 || y1 > y2) break;

                // 아래쪽
                for(int i = x1 + 1; i <= x2; i++) {
                    temp[y2][i] = array[y2][i - 1];
                }

                // 위쪽
                for(int i = x2 - 1; i >= x1; i--) {
                    temp[y1][i] = array[y1][i + 1];
                }

                // 오른쪽
                for(int i = y2 - 1; i >= y1; i--) {
                    temp[i][x2] = array[i + 1][x2];
                }

                // 왼쪽
                for(int i = y1 + 1; i <= y2; i++) {
                    temp[i][x1] = array[i - 1][x1];
                }

                x1++;
                x2--;
                y1++;
                y2--;
            }
            array = temp;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(array[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

}