import java.util.*;
import java.io.*;

public class Main {

    static int N, ans;
    static int[] arr;
    static boolean[] isAvailable;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        isAvailable = new boolean[2000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        search(0, 0);

        for(int i = 1; i <= 2000000; i++) {
            if(!isAvailable[i]) {
                ans = i;
                break;
            }
            else continue;
        }

        System.out.println(ans);
    }

    static void search(int sum, int idx) {
        isAvailable[sum] = true;
        if(idx == N) return;
        search(sum + arr[idx], idx + 1);
        search(sum, idx + 1);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}