import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] selected;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        selected = new int[N];
    }

    static void pro() {
        solve(0);

        System.out.println(sb);
    }

    static void solve(int idx) {
        if(idx == N) {
            for(int i = 0; i < N; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        for(int i = 1; i <= N; i++) {
            boolean flag = false;
            for(int j = 0; j < idx; j++) {
                if(selected[j] == i) {
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            selected[idx] = i;
            solve(idx + 1);
            selected[idx] = 0;
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}