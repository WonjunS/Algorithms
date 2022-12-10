import java.util.*;

public class Main {
    
    static int N, K, P, X, ans;
    static int[][] A;
    static boolean[][] on;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        P = sc.nextInt();
        X = sc.nextInt();

        A = new int[10][10];
        on = new boolean[10][7];
    }

    static void preprocess() {
        on[0][0] = true;
        on[0][1] = true;
        on[0][2] = true;
        on[0][3] = true;
        on[0][4] = true;
        on[0][5] = true;

        on[1][4] = true;
        on[1][5] = true;

        on[2][0] = true;
        on[2][2] = true;
        on[2][3] = true;
        on[2][5] = true;
        on[2][6] = true;

        on[3][0] = true;
        on[3][3] = true;
        on[3][4] = true;
        on[3][5] = true;
        on[3][6] = true;

        on[4][1] = true;
        on[4][4] = true;
        on[4][5] = true;
        on[4][6] = true;

        on[5][0] = true;
        on[5][1] = true;
        on[5][3] = true;
        on[5][4] = true;
        on[5][6] = true;

        on[6][0] = true;
        on[6][1] = true;
        on[6][2] = true;
        on[6][3] = true;
        on[6][4] = true;
        on[6][6] = true;

        on[7][0] = true;
        on[7][4] = true;
        on[7][5] = true;

        on[8][0] = true;
        on[8][1] = true;
        on[8][2] = true;
        on[8][3] = true;
        on[8][4] = true;
        on[8][5] = true;
        on[8][6] = true;

        on[9][0] = true;
        on[9][1] = true;
        on[9][3] = true;
        on[9][4] = true;
        on[9][5] = true;
        on[9][6] = true;
    }

    static void pro() {
        preprocess();

        for(int i = 0; i < 9; i++) {
            for(int j = i + 1; j <= 9; j++) {
                find(i, j);
            }
        }

        String curr = convertToDigit(X);
        for(int i = 1; i <= N; i++) {
            if(i == X) continue;
            String cand = convertToDigit(i);
            search(cand, curr);
        }

        System.out.println(ans);
    }

    static void find(int x, int y) {
        int count_x = 0;
        int count_y = 0;
        int common = 0;

        for(int i = 0; i < 7; i++) {
            if(on[x][i]) count_x++;
            if(on[y][i]) count_y++;
            if(on[x][i] && on[y][i]) common++;
        }

        int time = (count_x - common) + (count_y - common);
        A[x][y] = time;
        A[y][x] = time;
    }

    static void search(String cand, String curr) {
        int count = 0;
        for(int i = 0; i < K; i++) {
            int n1 = Character.getNumericValue(cand.charAt(i));
            int n2 = Character.getNumericValue(curr.charAt(i));

            int time = A[n1][n2];

            count += time;
        }
        if(count <= P) ans++;
    }

    static String convertToDigit(int num) {
        String s = String.valueOf(num);
        if(s.length() == K) return s;
        else {
            String str = "";
            for(int i = 0; i < K - s.length(); i++) {
                str += "0";
            }
            return str + s;
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}