import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] nums;
    
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nums = new int[N];
        for(int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(br.readLine());
    }
    
    static void solution() {
        Arrays.sort(nums);
        
        int best = Integer.MAX_VALUE;
        int R = 0;
        
        for(int L = 0; L < N; L++) {
            while(R < N - 1 && (nums[R] - nums[L]) < M) {
                R++;
            }
            int diff = nums[R] - nums[L];
            if(diff >= M) {
                best = Math.min(diff, best);
            }
            if(best == M) break;
        }
        
        System.out.println(best);
    }
    
    public static void main(String[] args) throws Exception {
        input();
        solution();
    }
}