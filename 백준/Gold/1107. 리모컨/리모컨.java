import java.util.*;

public class Main {

    static int N, M, ans;
    static boolean[] broken;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        broken = new boolean[10];
        for(int i = 0; i < M; i++) {
            int n = sc.nextInt();
            broken[n] = true;
        }
    }

    static void pro() {
        ans = Math.abs(N - 100);

        search();

        System.out.println(ans);
    }

    static void search() {
        int result = 500000;

        for(int i = 0; i < 1000000; i++) {
            if(valid(i)) {
                int count = String.valueOf(i).length() + Math.abs(N - i);
                ans = Math.min(ans, count);
            }
        }
    }

    static boolean valid(int n) {
        String s = Integer.toString(n);
        for(int i = 0; i < s.length(); i++) {
            int c = Character.getNumericValue(s.charAt(i));
            if(broken[c]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}