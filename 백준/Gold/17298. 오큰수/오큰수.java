import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int[] NGE = new int[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Integer> stk = new Stack<>();
        for(int i = N; i > 0; i--) {
            int x = A[i];
            
            if(stk.isEmpty()) {
                stk.push(x);
                NGE[i] = -1;
                continue;
            }
            
            if(x < stk.peek()) {
                NGE[i] = stk.peek();
            } else {
                while(!stk.isEmpty() && x >= stk.peek()) {
                    stk.pop();
                }
                
                if(stk.isEmpty()) {
                    NGE[i] = -1;
                } else {
                    NGE[i] = stk.peek();
                }
            }
            
            stk.push(x);
        }
        
        for(int i = 1; i <= N; i++) {
            sb.append(NGE[i]).append(' ');
        }
        
        System.out.println(sb.toString());
    }
    
}