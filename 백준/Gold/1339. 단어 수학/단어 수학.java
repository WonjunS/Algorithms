import java.util.*;
import java.io.*;

public class Main {

    static int N, ans;
    static String[] str;
    static int[] arr;

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = new String[N];
        arr = new int[26];
        for(int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
    }

    static void pro() {
        for(int i = 0; i < N; i++) {
            String s = str[i];
            int k = 1;
            for(int j = s.length() - 1; j >= 0; j--) {
                arr[s.charAt(j) - 'A'] += k;
                k *= 10;
            }
        }

        Arrays.sort(arr);
        int n = 9;
        for(int i = 25; i >= 0; i--) {
            if(arr[i] == 0) continue;
            ans += (n * arr[i]);
            n--;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}