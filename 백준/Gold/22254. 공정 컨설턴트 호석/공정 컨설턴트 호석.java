import java.util.*;

public class Main {

    static int N, X, ans;
    static int[] A;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        X = sc.nextInt();

        A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
    }

    static void pro() {
        int L = 1, R = N, ans = N;
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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < x; i++) {
            pq.add(0);
        }
        for(int i = 0; i < N; i++) {
            int pick = pq.poll();
            if(pick + A[i] > X) return false;
            pq.add(pick + A[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}