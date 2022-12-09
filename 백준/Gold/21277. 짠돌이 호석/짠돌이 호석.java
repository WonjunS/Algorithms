import java.util.*;

public class Main {

    static int N1, M1, N2, M2, ans;
    static int[][] A, B, temp;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N1 = sc.nextInt();
        M1 = sc.nextInt();
        A = new int[N1 + 1][M1 + 1];
        for(int i = 1; i <= N1; i++) {
            String s = sc.next();
            for(int j = 1; j <= M1; j++) {
                A[i][j] = Character.getNumericValue(s.charAt(j - 1));
            }
        }

        N2 = sc.nextInt();
        M2 = sc.nextInt();
        B = new int[Math.max(N2, M2) + 1][Math.max(N2, M2) + 1];
        for(int i = 1; i <= N2; i++) {
            String s = sc.next();
            for(int j = 1; j <= M2; j++) {
                B[i][j] = Character.getNumericValue(s.charAt(j - 1));
            }
        }

        temp = new int[Math.max(N2, M2) + 1][Math.max(N2, M2) + 1];
    }

    static void pro() {
        ans = Integer.MAX_VALUE;

        for(int i = 0; i < 4; i++) {
            rotate();
            for(int row = -51; row <= 51; row++) {
                for(int col = -51; col <= 51; col++) {
                    if(possible(row, col)) {
                        int r = Math.max(N2 - 1, row + N1 - 1) - Math.min(0, row) + 1;
                        int c = Math.max(M2 - 1, col + M1 - 1) - Math.min(0, col) + 1;
                        ans = Math.min(ans, r * c);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static boolean possible(int row, int col) {
        for(int ai = 1; ai <= N1; ai++) {
            for(int aj = 1; aj <= M1; aj++) {
                if(A[ai][aj] == 0) continue;
                int bi = ai + row, bj = aj + col;
                if(bi >= 1 && bi <= N2 && bj >= 1 && bj <= M2 && B[bi][bj] == 1)
                    return false;
            }
        }
        return true;
    }

    static void rotate() {
        for(int i = 1; i <= N2; i++) {
            for(int j = 1; j <= M2; j++) {
                temp[j][N2 - i + 1] = B[i][j];
            }
        }
        int t = N2;
        N2 = M2;
        M2 = t;
        for(int i = 1; i <= N2; i++) {
            for(int j = 1; j <= M2; j++) {
                B[i][j] = temp[i][j];
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}