import java.util.*;

public class Main {

    static long[][] Dy;

    static void preprocess() {
        for(int i = 0; i < 10; i++) {
            Dy[1][i] = 1;
        }
        for(int i = 2; i <= 64; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k <= j; k++) {
                    Dy[i][j] += Dy[i - 1][k];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Dy = new long[65][10];
        preprocess();

        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();

            long ans = 0;
            for(int i = 0; i < 10; i++) {
                ans += Dy[n][i];
            }
            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }
}