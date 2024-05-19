import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = i - 1; j >= 0; j--) {
                int x1 = 0;
                int y1 = arr[j];
                int x2 = i - j;
                int y2 = arr[i];

                double g = calcGradient(x1, y1, x2, y2);

                boolean flag = true;
                for(int k = j + 1; k < i; k++) {
                    int x = k - j;
                    int y = arr[k];

                    if(y - (g * x) >= y1 ) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    cnt++;
                }
            }

            for(int j = i + 1; j < N; j++) {
                int x1 = 0;
                int y1 = arr[i];
                int x2 = j - i;
                int y2 = arr[j];

                double g = calcGradient(x1, y1, x2, y2);

                boolean flag = true;
                for(int k = i + 1; k < j; k++) {
                    int x = k - i;
                    int y = arr[k];

                    if(y - (g * x) >= y1 ) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    cnt++;
                }
            }

            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
        
    }

    private static double calcGradient(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (double) (x2 - x1);
    }

}