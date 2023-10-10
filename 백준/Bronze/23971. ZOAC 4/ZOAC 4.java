import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int x = (H % (N + 1) == 0) ? H / (N + 1) : H / (N + 1) + 1;
        int y = (W % (M + 1) == 0) ? W / (M + 1) : W / (M + 1) + 1;
        
        long total = x * y;
        
        System.out.println(total);
    }
    
}