import java.util.*;

public class Main {

    static int N, K;
    static long[][] Dy;
    static final int mod = 1000000000;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
    }

    static void pro() {
        Dy = new long[N + 1][K + 1];

        for(int i = 0; i <= N; i++) {
            Dy[i][1] = 1;
        }

        for(int i = 2; i <= K; i++) {
            for(int j = 0; j <= N; j++) {
                long sum = 0;
                for(int k = 0; k <= j; k++) {
                    sum += Dy[k][i - 1] % mod;
                }
                Dy[j][i] = sum % mod;
            }
        }
        
        System.out.println(Dy[N][K]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}