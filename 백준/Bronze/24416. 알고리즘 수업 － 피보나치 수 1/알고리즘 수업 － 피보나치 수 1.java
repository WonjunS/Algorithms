import java.util.*;
import java.io.*;

public class Main {
    
    private static int count1, count2;
    private static int[] F;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        F = new int[n + 1];
        
        fib1(n);
        fib2(n);
        
        System.out.println((count1 + 1) + " " + count2);
    }
    
    private static int fib1(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        count1++;
        return fib1(n - 1) + fib1(n - 2);
    }
    
    private static void fib2(int n) {
        F[1] = 1;
        F[2] = 1;
        for(int i = 3; i <= n; i++) {
            F[i] = F[i - 1] + F[i - 2];
            count2++;
        }
    }
    
}