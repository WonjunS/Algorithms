import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        long answer = factorial(N);
        
        System.out.println(answer);
    }
    
    private static long factorial(int k) {
        if(k == 0 || k == 1) {
            return 1;
        }
        return k * factorial(k - 1);
    }
    
}