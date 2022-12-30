import java.util.*;

public class Main {

    static int N, M;
    static int[] A;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        A = new int[M];
        for(int i = 0; i < M; i++) {
            A[i] = sc.nextInt();
        }
    }

    static void pro() {
        int L = 1, R = N, ans = R;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(determination(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean determination(int x) {
        int last = 0;
        for(int i = 0; i < M; i++) {
            int left = A[i] - x;
            if(last >= left) {
                last = A[i] + x;
                continue;
            }
            else return false;
        }
        if(last < N) return false;
        return true;
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}