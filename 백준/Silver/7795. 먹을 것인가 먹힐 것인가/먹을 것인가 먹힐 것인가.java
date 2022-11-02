import java.util.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    static int N, a, b, total;
    static int[] A;
    static int[] B;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        for(int t = 1; t <= N; t++) {
            a = sc.nextInt();
            b = sc.nextInt();
            
            A = new int[a];
            B = new int[b];
            
            for(int i = 0; i < a; i++) {
                A[i] = sc.nextInt();
            }
            
            for(int i = 0; i < b; i++) {
                B[i] = sc.nextInt();
            }
            
            Arrays.sort(A);
            Arrays.sort(B);
            
            total = 0;
            for(int x : A) {
                total += solution(x);
            }
            sb.append(total).append('\n');
        }
        
        System.out.println(sb);
    }
    
    static int solution(int val) {
        int L = 0;
        int R = B.length - 1;
        int count = 0;
        
        while(L <= R) {
            int mid = (L + R) / 2;
            if(val > B[mid]) {
                L = mid + 1;
                count = mid + 1;
            }
            else R = mid - 1;
        }
        return count;
    }
}