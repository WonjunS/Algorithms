import java.util.*;
import java.io.*;

public class Main {

    static int N, H;
    static int[] top, bottom;

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        top = new int[N / 2];
        bottom = new int[N / 2];

        for(int i = 0; i < N; i++) {
            if(i % 2 == 0) {
                bottom[i / 2] = Integer.parseInt(br.readLine());
            } else {
                top[i / 2] = Integer.parseInt(br.readLine());
            }
        }

        Arrays.sort(bottom);
        Arrays.sort(top);
    }

    static void pro() {
        int answer = N;
        int temp = 0;
        int answer_count = 0;

        for(int i = 1; i <= H; i++) {
            temp = search(i);

            if(answer == temp) {
                answer_count++;
            }
            if(answer > temp) {
                answer = temp;
                answer_count = 1;
            }
        }

        System.out.println(answer + " " + answer_count);
    }

    static int search(int x) {
        int L = 0, R = N / 2 - 1, cnt = 0;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(bottom[mid] >= x) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        cnt += N / 2 - L;

        L = 0;
        R = N / 2 - 1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(top[mid] >= H - x + 1) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        cnt += N / 2 - L;

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}