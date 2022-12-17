import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] Dy, from;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
    }

    static void pro() {
        Dy = new int[1000001];
        from = new int[1000001];

        solve();
        
        System.out.println(sb);
    }
    
    static void solve() {
        Dy[1] = 0;
        for(int i = 2; i <= N; i++) {
            Dy[i] = Dy[i - 1] + 1;
            from[i] = i - 1;
            if(i % 3 == 0) {
                if(Dy[i] > Dy[i / 3] + 1) {
                    Dy[i] = Dy[i / 3] + 1;
                    from[i] = i / 3;
                }
            }
            if(i % 2 == 0) {
                if(Dy[i] > Dy[i / 2] + 1) {
                    Dy[i] = Dy[i / 2] + 1;
                    from[i] = i / 2;
                }
            }
        }
        
        sb.append(Dy[N]).append('\n');
        
        while(true) {
            if(N == 0) break;
            sb.append(N).append(' ');
            N = from[N];
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}