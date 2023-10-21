import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        int N = str.length();
        
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for(int i = 0; i < N; i++) {
            char c = str.charAt(i);
            left.push(c);
        }
        
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            String[] arr = br.readLine().split(" ");
            char c = arr[0].charAt(0);
            
            if(c == 'L') {
                if(!left.isEmpty()) {
                    right.push(left.pop());
                }
                continue;
            }
            if(c == 'D') {
                if(!right.isEmpty()) {
                    left.push(right.pop());
                }
                continue;
            }
            if(c == 'B') {
                if(!left.isEmpty()) {
                    left.pop();
                }
                continue;
            }
            if(c == 'P') {
                char newChar = arr[1].charAt(0);
                left.push(newChar);
            }
        }

        String answer = "";
        while(!left.isEmpty()) {
            right.push(left.pop());
        }
        
        while(!right.isEmpty()) {
            bw.write(right.pop());
        }

        bw.flush();
        bw.close();
    }
    
}