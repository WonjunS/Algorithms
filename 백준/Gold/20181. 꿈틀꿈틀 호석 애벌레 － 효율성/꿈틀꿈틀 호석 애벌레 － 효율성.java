import java.util.*;

public class Main {

    static class Interval {
        private int left;
        private int satisfy;

        public Interval() { }
    }

    static int N, K;
    static int[] A;
    static long[] Dy;
    static ArrayList<Interval>[] intervals;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        Dy = new long[N + 1];
        A = new int[N + 1];
        intervals = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            intervals[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
    }

    static void pro() {
        long sum = 0;
        for(int L = 1, R = 0; L <= N; L++) {
            while(sum < K && R + 1 <= N) sum += A[++R];
            if(sum >= K) {
                Interval i = new Interval();
                i.left = L;
                i.satisfy = (int) sum - K;
                intervals[R].add(i);
            }
            sum -= A[L];
        }

        for(int R = 1; R <= N; R++) {
            Dy[R] = Dy[R - 1];
            for(Interval i : intervals[R]) {
                Dy[R] = Math.max(Dy[R], Dy[i.left - 1] + i.satisfy);
            }
        }

        System.out.println(Dy[N]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}