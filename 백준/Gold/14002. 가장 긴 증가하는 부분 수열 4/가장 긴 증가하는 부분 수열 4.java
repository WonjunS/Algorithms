import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A, Dy;

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        Dy = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        Dy[0] = 1;
        int ans = 1;
        for(int i = 1; i < N; i++) {
            Dy[i] = 1;
            for(int j = 0; j < i; j++) {
                if(A[i] > A[j]) Dy[i] = Math.max(Dy[i], Dy[j] + 1);
            }
            ans = Math.max(ans, Dy[i]);
        }

        int value = ans;
        Stack<Integer> stk = new Stack<>();
        for(int i = N - 1; i >= 0; i--) {
            if(Dy[i] == value) {
                stk.push(A[i]);
                value--;
            }
        }

        sb.append(ans).append('\n');
        while(!stk.isEmpty()) {
            sb.append(stk.pop()).append(' ');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}