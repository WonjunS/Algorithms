import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, T, x1, y1, x2, y2, count;
    static String dir;
    static int[][] board;
    static String[][] result;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        result = new String[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = "S";
            }
        }
    }

    static void pro() throws IOException {
        for(int i = 0; i < T; i++) {
            // Offence
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            dir = st.nextToken();
            attack();

            // Defence
            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            defence();
        }
        sb.append(count).append('\n');
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void attack() {
        if(result[x1 - 1][y1 - 1].equals("F")) return;
        if(dir.equals("E")) {
            int prev = result[x1 - 1][y1 - 1].equals("R") ? board[x1 - 1][y1 - 1] - 1 : 0;
            for(int i = y1 - 1; i < M; i++) {
                if(result[x1 - 1][i].equals("F")) {
                    if(prev - 1 > 0) {
                        prev -= 1;
                    }
                    else break;
                }
                else {
                    result[x1 - 1][i] = "F";
                    prev = Math.max(prev - 1, board[x1 - 1][i] - 1);
                    count++;
                    if(prev <= 0) break;
                }
            }
            return;
        }
        if(dir.equals("W")) {
            int prev = result[x1 - 1][y1 - 1].equals("R") ? board[x1 - 1][y1 - 1] - 1 : 0;
            for(int i = y1 - 1; i >= 0; i--) {
                if(result[x1 - 1][i].equals("F")) {
                    if(prev - 1 > 0) {
                        prev -= 1;
                    }
                    else break;
                }
                else {
                    result[x1 - 1][i] = "F";
                    prev = Math.max(prev - 1, board[x1 - 1][i] - 1);
                    count++;
                    if(prev <= 0) break;
                }
            }
            return;
        }
        if(dir.equals("N")) {
            int prev = result[x1 - 1][y1 - 1].equals("R") ? board[x1 - 1][y1 - 1] - 1 : 0;
            for(int i = x1 - 1; i >= 0; i--) {
                if(result[i][y1 - 1].equals("F")) {
                    if(prev - 1 > 0) {
                        prev -= 1;
                    }
                    else break;
                }
                else {
                    result[i][y1 - 1] = "F";
                    prev = Math.max(prev - 1, board[i][y1 - 1] - 1);
                    count++;
                    if(prev <= 0) break;
                }
            }
            return;
        }
        if(dir.equals("S")) {
            int prev = result[x1 - 1][y1 - 1].equals("R") ? board[x1 - 1][y1 - 1] - 1 : 0;
            for(int i = x1 - 1; i < N; i++) {
                if(result[i][y1 - 1].equals("F")) {
                    if(prev - 1 > 0) {
                        prev -= 1;
                    }
                    else break;
                }
                else {
                    result[i][y1 - 1] = "F";
                    prev = Math.max(prev - 1, board[i][y1 - 1] - 1);
                    count++;
                    if(prev <= 0) break;
                }
            }
            return;
        }
    }

    static void defence() {
        if(result[x2 - 1][y2 - 1].equals("S")) return;
        result[x2 - 1][y2 - 1] = "S";
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}