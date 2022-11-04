import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer st;
    
    static int N, M;
    static int[] trees;
    
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);
    }
    
    static void pro() {
        int h = 0;
        int pl = 1, pr = 2000000000;
        
        while(pl <= pr) {
            int mid = (pl + pr) / 2;
            long sum = 0;
            for(int i = 0; i < N; i++) {
                if(trees[i] <= mid) continue;
                sum += (long) (trees[i] - mid);
            }
            if(sum >= M) {
                h = mid;
                pl = mid + 1;
            }
            else {
                pr = mid - 1;
            }
        }
        System.out.println(h);
    }
    
    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}