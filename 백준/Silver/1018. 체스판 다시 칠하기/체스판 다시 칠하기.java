import java.util.*;
import java.io.*;

public class Main {

    static int N, M, ans;
    static String[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new String[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = String.valueOf(s.charAt(j));
            }
        }

        ans = Integer.MAX_VALUE;
        for(int i = 0; i <= N - 8; i++) {
            for(int j = 0; j <= M - 8; j++) {
                paint(i, j);
            }
        }

        System.out.println(ans);
    }

    static void paint(int x, int y) {
        int blue = 0, white = 0;
        int rx = x % 2;
        int ry = y % 2;

        for(int i = x; i < x + 8; i++) {
            for(int j = y; j < y + 8; j++) {
                if((i % 2 == rx && j % 2 == ry) || (i % 2 != rx && j % 2 != ry)) {
                    if(!board[i][j].equals("B")) blue++;
                } else {
                    if(board[i][j].equals("B")) blue++;
                }
            }
        }

        for(int i = x; i < x + 8; i++) {
            for(int j = y; j < y + 8; j++) {
                if((i % 2 == rx && j % 2 == ry) || (i % 2 != rx && j % 2 != ry)) {
                    if(!board[i][j].equals("W")) white++;
                } else {
                    if(board[i][j].equals("W")) white++;
                }
            }
        }

        ans = Math.min(ans, Math.min(blue, white));
    }
}