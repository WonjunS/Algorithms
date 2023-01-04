import java.util.*;
import java.io.*;

public class Main {

    static int N, d, k, c, max;
    static int[] A;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        A = new int[N];
        map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        boolean flag = false;
        for(int L = 0, R = 0; L < N; L++) {
            int diff = k;
            if(A[L % N] == c) {
                diff = k + 1;
                flag = true;
            }
            while(R - L < diff) {
                if(map.containsKey(A[R % N])) map.put(A[R % N], map.get(A[R % N]) + 1);
                else map.put(A[R % N], 1);
                R++;
            }
            if(A[R % N] == c) {
                if(map.containsKey(A[R % N])) map.put(A[R % N], map.get(A[R % N]) + 1);
                else map.put(A[R % N], 1);
                flag = true;
            }

            max = Math.max(max, map.size());
            
            if(!map.containsKey(A[L % N])) continue;
            if(map.get(A[L % N]) == 1) map.remove(A[L % N]);
            else map.put(A[L % N], map.get(A[L % N]) - 1);
        }
        
        if(!flag) max += 1;

        System.out.println(max);
    }
}