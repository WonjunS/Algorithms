import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int P = Integer.parseInt(br.readLine());
        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            sb.append(n).append(' ');

            int[] A = new int[20];
            for (int i = 0; i < 20; i++) {
                int x = Integer.parseInt(st.nextToken());
                A[i] = x;
            }

            int total = 0;
            while (true) {
                int sub = 0;
                for (int i = 1; i < 20; i++) {
                    int idx = i;
                    int curr = A[i];
                    
                    for (int j = i - 1; j >= 0; j--) {
                        if (A[i] < A[j]) {
                            idx = j;
                        }
                    }
                    
                    if(idx == i) continue;

                    int prev = A[idx];
                    for (int j = idx + 1; j <= i; j++) {
                        int temp = A[j];
                        A[j] = prev;
                        prev = temp;
                    }

                    A[idx] = curr;
                    sub += (i - idx);
                }

                if (sub == 0) {
                    break;
                } else {
                    total += sub;
                }
            }

            sb.append(total).append('\n');
        }

        System.out.println(sb.toString());
    }

}