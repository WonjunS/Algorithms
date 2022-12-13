import java.util.*;

public class Main {

    static int N;
    static int[][] A, Dy;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Dy = new int[N + 2][N + 2];
        A = new int[N + 2][N + 2];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++) {
                A[i][j] = sc.nextInt();
            }
        }
    }

    static void pro() {
        Dy[1][1] = A[1][1];

        for(int i = 2; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                Dy[i][j] = Math.max(Dy[i - 1][j - 1], Dy[i - 1][j]) + A[i][j];
            }
        }

        int ans = 0;
        for(int i = 1; i <= N; i++) {
            ans = Math.max(Dy[N][i], ans);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}