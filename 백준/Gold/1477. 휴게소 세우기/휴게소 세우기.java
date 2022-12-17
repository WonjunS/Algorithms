import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;

    static int N, M, L, ans;
    static int[] A;

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        Arrays.sort(A);

        int L = 1, R = 500;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(determination(mid)) {
                R = mid - 1;
                ans = mid;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean determination(int x) {
        int count = 0;
        for(int i = 1; i <= N; i++) {
            int diff = A[i] - A[i - 1];
            if(diff <= x) continue;
            if(diff % x == 0) count += (diff / x) - 1;
            else count += diff / x;
        }
        int diff = L - A[N];
        if(diff <= x) return count <= M;
        if(diff % x == 0) count += (diff / x) - 1;
        else count += diff / x;
        return count <= M;
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}