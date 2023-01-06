import java.util.*;

public class Main {

    static int N;
    static int[][] A, Dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        A = new int[N + 1][2];
        Dy = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            A[i][0] = r;
            A[i][1] = c;
        }

        for(int i = 1; i < N; i++) {
            Dy[i][i + 1] = A[i][0] * A[i][1] * A[i + 1][1];
        }

        for(int len = 2; len <= N; len++) {
            for(int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                Dy[i][j] = Integer.MAX_VALUE;

                for(int k = i; k < j; k++) {
                    Dy[i][j] = Math.min(Dy[i][j],
                            Dy[i][k] + Dy[k + 1][j] + (A[i][0] * A[k][1] * A[j][1]));
                }
            }
        }
        
        System.out.println(Dy[1][N]);
    }
}