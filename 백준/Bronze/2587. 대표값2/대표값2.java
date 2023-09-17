import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = 5;
        int sum = 0;
        int[] arr = new int[N];
        while(N > 0) {
            int x = Integer.parseInt(br.readLine());
            sum += x;
            
            arr[--N] = x;
        }
        
        Arrays.sort(arr);
        
        System.out.println(sum / 5);
        
        System.out.println(arr[2]);
    }
    
}