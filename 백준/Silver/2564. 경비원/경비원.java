import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int s = Integer.parseInt(br.readLine());

        List<int[]> stores = new ArrayList<>();
        int dx = 0, dy = 0, d_dir = 0;
        for(int i = 0; i <= s; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int x = 0;
            int y = 0;

            switch (dir) {
                case 1:
                    x = k;
                    y = N;
                    break;
                case 2:
                    x = k;
                    y = 0;
                    break;
                case 3:
                    x = 0;
                    y = N - k;
                    break;
                case 4:
                    x = M;
                    y = N - k;
                    break;
                default:
                    break;
            }

            if(i == s) {
                dx = x;
                dy = y;
                d_dir = dir;
            } else {
                stores.add(new int[]{x, y, dir});
            }
        }

        int total = 0;
        int oneDist = (M + N) * 2;
        for(int i = 0; i < s; i++) {
            int x1 = dx;
            int y1 = dy;
            int dir1 = d_dir;
            int x2 = stores.get(i)[0];
            int y2 = stores.get(i)[1];
            int dir2 = stores.get(i)[2];

            int subTotal = 0;
            if(dir1 == dir2) {
                if(dir1 == 1 || dir1 == 2) {
                    subTotal += Math.abs(x1 - x2);
                } else {
                    subTotal += Math.abs(y1 - y2);
                }
            } else {
                // 1 <-> 2
                if((dir1 == 1 && dir2 == 2) || (dir1 == 2 && dir2 == 1)) {
                    int n = x1 + y1 + x2 + y2;
                    subTotal = Math.min(n, oneDist - n);
                }
                // 1 <-> 3
                if((dir1 == 1 && dir2 == 3) || (dir1 == 3 && dir2 == 1)) {
                    int n = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                    subTotal = Math.min(n, oneDist - n);
                }
                // 1 <-> 4
                if((dir1 == 1 && dir2 == 4) || (dir1 == 4 && dir2 == 1)) {
                    int n = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                    subTotal = Math.min(n, oneDist - n);
                }
                // 2 <-> 3
                if((dir1 == 2 && dir2 == 3) || (dir1 == 3 && dir2 == 2)) {
                    int n = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                    subTotal = Math.min(n, oneDist - n);
                }
                // 2 <-> 4
                if((dir1 == 2 && dir2 == 4) || (dir1 == 4 && dir2 == 2)) {
                    int n = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                    subTotal = Math.min(n, oneDist - n);
                }
                // 3 <-> 4
                if((dir1 == 3 && dir2 == 4) || (dir1 == 4 && dir2 == 3)) {
                    int n = x1 + y1 + x2 + y2;
                    subTotal = Math.min(n, oneDist - n);
                }
            }

            total += subTotal;
        }

        System.out.println(total);
    }

}