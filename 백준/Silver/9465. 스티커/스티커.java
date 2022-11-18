import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);

    static int T, N;
    static int[][] A;
    static int[][] Dy;

    static void input() {
        N = sc.nextInt();
        A = new int[2][N + 1];
        Dy = new int[2][N + 1];

        for(int i = 0; i < 2; i++) {
            for(int j = 1; j <= N; j++) {
                A[i][j] = sc.nextInt();
            }
        }
    }

    static void pro() {
        Dy[0][1] = A[0][1];
        Dy[1][1] = A[1][1];

        for(int i = 2; i <= N; i++) {
            Dy[0][i] = Math.max(Dy[0][i - 2], Dy[1][i - 2]) + A[0][i];
            Dy[0][i] = Math.max(Dy[0][i], Dy[1][i - 1] + A[0][i]);
            Dy[0][i] = Math.max(Dy[0][i], Dy[0][i - 1]);

            Dy[1][i] = Math.max(Dy[0][i - 2], Dy[1][i - 2]) + A[1][i];
            Dy[1][i] = Math.max(Dy[1][i], Dy[0][i - 1] + A[1][i]);
            Dy[1][i] = Math.max(Dy[1][i], Dy[1][i - 1]);
        }

        int ans = Math.max(
                Math.max(Dy[0][N], Dy[1][N]),
                Math.max(Dy[0][N - 1], Dy[1][N - 1])
        );

        sb.append(ans).append('\n');
    }

    public static void main(String[] args) {
        T = sc.nextInt();
        while(T-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }
}