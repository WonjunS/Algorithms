import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
    static void hanoi(int n, int a, int b) {
        if(n > 1)
            hanoi(n - 1, a, 6 - a - b);
        
        sb.append(a + " " + b + "\n");
        
        if(n > 1)
            hanoi(n - 1, 6 - a - b, b);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        sb.append((long) (Math.pow(2, n) - 1)).append('\n');
        hanoi(n, 1, 3);
        System.out.println(sb);
    }
}