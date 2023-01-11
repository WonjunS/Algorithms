import java.util.*;
import java.io.*;

public class Main {
    
    static int N, D, K, C, ans;
    static int[] arr;
    static Map<Integer, Integer> map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        boolean flag = false;
        for(int L = 0, R = 0; L < N; L++) {
            int gap = K;
            if(arr[L % N] == C) {
                gap = K + 1;
                flag = true;
            }
            while(R - L < gap) {
                map.put(arr[R % N], map.getOrDefault(arr[R % N], 0) + 1);
                R++;
            }
            if(arr[R % N] == C) {
                map.put(arr[R % N], map.getOrDefault(arr[R % N], 0) + 1);
                flag = true;
            }
            
            ans = Math.max(ans, map.size());
            
            if(map.get(arr[L % N]) == 1) map.remove(arr[L % N]);
            else map.put(arr[L % N], map.get(arr[L % N]) - 1);
        }
        
        if(!flag) ans += 1;
        System.out.println(ans);
    }
}