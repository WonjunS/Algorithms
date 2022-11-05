import java.util.*;

public class Main {
    
    static int n;
    static int[] Dy;
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Dy = new int[1005];
    }
    
    static void pro() {
        Dy[1] = 1;
        Dy[2] = 2;
        for(int i = 3; i <= n; i++) {
            Dy[i] = (Dy[i - 1] + Dy[i - 2]) % 10007;
        }
        System.out.println(Dy[n]);
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}