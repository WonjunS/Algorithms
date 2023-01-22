import java.util.*;
import java.io.*;

public class Main {

    static class Star {
        private int x;
        private int y;

        public Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, L, K, max;
    static ArrayList<Star> stars;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stars = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new Star(x, y));
        }

        for(Star star : stars) {
            for(Star s : stars) {
                countStar(star.x, s.y);
            }
        }

        System.out.println(K - max);
    }

    static void countStar(int x, int y) {
        int count = 0;
        for(Star s : stars) {
            int nx = s.x;
            int ny = s.y;
            if(nx >= x && nx <= x + L && ny >= y && ny <= y + L) count++;
        }

        max = Math.max(max, count);
    }
}