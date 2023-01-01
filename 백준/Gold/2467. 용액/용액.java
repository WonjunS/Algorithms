import java.util.*;
import java.io.*;

public class Main {

    static int N, left, right;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int L = 0, R = N - 1, best_sum = Integer.MAX_VALUE;
        while(L < R) {
            int sum = calc(L, R);
            if(sum == 0) {
                left = arr[L];
                right = arr[R];
                break;
            } else if(sum > 0) {
                if(Math.abs(sum) < best_sum) {
                    left = arr[L];
                    right = arr[R];
                    best_sum = Math.abs(sum);
                }
                R--;
            } else {
                if(Math.abs(sum) < best_sum) {
                    left = arr[L];
                    right = arr[R];
                    best_sum = Math.abs(sum);
                }
                L++;
            }
        }

        System.out.println(left + " " + right);
    }

    static int calc(int L, int R) {
        return arr[L] + arr[R];
    }
}