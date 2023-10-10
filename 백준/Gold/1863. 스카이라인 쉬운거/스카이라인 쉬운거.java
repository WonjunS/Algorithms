import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        int[] heights = new int[n];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            heights[i] = y;
        }

        Stack<Integer> stk = new Stack<>();
        int answer = 0;
        
        for(int h : heights) {
            if(h == 0) {
                answer += stk.size();
                stk.clear();
                continue;
            }
            
            if(stk.isEmpty()) {
                stk.push(h);
                continue;
            }
            
            int prev = stk.peek();
            if(prev < h) {
                stk.push(h);
            } else {
                while(!stk.isEmpty() && stk.peek() > h) {
                    stk.pop();
                    answer++;
                }
                
                if(!stk.isEmpty() && stk.peek() < h) {
                    stk.push(h);
                }
                if(stk.isEmpty()) {
                    stk.push(h);
                }
            }
        }
        
        answer += stk.size();
        
        System.out.println(answer);
    }
    
}