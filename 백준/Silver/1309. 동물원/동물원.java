import java.util.*;

public class Main {
    
    static int N;
    static int[] Dy;
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        Dy = new int[N + 1];
    }
    
    static void pro() {
        Dy[0] = 1;
        Dy[1] = 3;
        for(int i = 2; i <= N; i++) {
            Dy[i] = (Dy[i - 1] * 2 + Dy[i - 2]) % 9901;
        }
        
        System.out.println(Dy[N]);
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}