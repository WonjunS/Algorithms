import java.util.*;

public class Main {

    static int N, S, ans;
    static ArrayList<Integer> arr;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        arr = new ArrayList<>();
        arr.add(0);
        for(int i = 0; i < N; i++) {
            int x = sc.nextInt();
            arr.add(x);
        }
    }

    static void pro() {
        ans = N + 1;
        int sum = 0;
        int R = 0;
        for(int L = 1; L <= N; L++) {
            sum -= arr.get(L - 1);
            while(R < N && sum < S) {
                R++;
                sum += arr.get(R);
            }
            if(sum >= S) {
                ans = Math.min(ans, (R - L + 1));
            }
        }
        if(ans == N + 1) ans = 0;

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}