import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int[] NGF = new int[N + 1];
        
        Map<Integer, Integer> count = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int x = Integer.parseInt(st.nextToken());
            A[i] = x;
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        
        Stack<Integer> stk = new Stack<>();
        for(int i = N; i > 0; i--) {
            int n = A[i];
            
            while(!stk.isEmpty() && count.get(n) >= count.get(stk.peek())) {
                stk.pop();
            }
            
            int x = (stk.isEmpty()) ? -1 : stk.peek();
            NGF[i] = x;
            
            stk.push(n);
        }
        
        for(int i = 1; i <= N; i++) {
            sb.append(NGF[i]).append(' ');
        }
        
        System.out.println(sb.toString());
    }
    
}