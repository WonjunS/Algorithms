import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;

    static int H, W, total;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[W + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        for(int i = 1; i <= W; i++) {
            int right = 0;
            for(int j = i + 1; j <= W; j++) {
                right = Math.max(arr[j], right);
            }
            if(Math.min(left, right) - arr[i] > 0)
                total += Math.min(left, right) - arr[i];
            left = Math.max(arr[i], left);
        }

        System.out.println(total);
    }
}