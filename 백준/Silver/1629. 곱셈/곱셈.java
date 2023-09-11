import java.util.*;
import java.io.*;

public class Main {
    
    private static long A, B, C;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        
        long answer = calculate(B);
        
        System.out.println(answer);
    }
    
    private static long calculate(long k) {
        if(k == 1) {
            return A % C;
        }
        if(k % 2 == 0) {
            return twice(calculate(k / 2)) % C;
        }
        return A * calculate(k - 1) % C;
    }
    
    private static long twice(long a) {
        return a * a;
    }
    
}