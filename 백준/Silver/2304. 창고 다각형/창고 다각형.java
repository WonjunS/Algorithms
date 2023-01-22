import java.util.*;
import java.io.*;

public class Main {

    static int N, a, b, max_height, area;
    static int[][] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            max_height = Math.max(max_height, H);
            A[i][0] = L;
            A[i][1] = H;
        }

        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int p1 = A[0][0];
        int p2 = A[0][1];
        for(int i = 0; i < N; i++) {
            int L = A[i][0];
            int H = A[i][1];
            if(H == max_height) {
                area += p2 * (L - p1);
                a = L;
                break;
            }
            if(H > p2) {
                area += p2 * (L - p1);
                p1 = L;
                p2 = H;
            }
        }

        p1 = A[N - 1][0];
        p2 = A[N - 1][1];
        for(int i = N - 1; i >= 0; i--) {
            int L = A[i][0];
            int H = A[i][1];
            if(H == max_height) {
                area += p2 * (p1 - L);
                b = L;
                break;
            }
            if(H > p2) {
                area += p2 * (p1 - L);
                p1 = L;
                p2 = H;
            }
        }

        area += max_height * (b - a + 1);

        System.out.println(area);
    }
}