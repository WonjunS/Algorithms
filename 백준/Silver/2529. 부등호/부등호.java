import java.util.*;

public class Main {

    static int K;
    static String min, max;
    static String[] A;
    static boolean[] selected;

    static void input() {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        A = new String[K];
        selected = new boolean[10];
        for(int i = 0; i < K; i++) {
            A[i] = sc.next();
        }
    }

    static void pro() {
        max = "0000000000";
        min = "9999999999";
        dfs("");

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(String s) {
        if(s.length() == K + 1) {
            check(s);
            return;
        } else {
            for(int i = 0; i <= 9; i++) {
                if(selected[i]) continue;
                selected[i] = true;
                dfs(s + i);
                selected[i] = false;
            }
        }
    }

    static void check(String s) {
        for(int i = 0; i < K; i++) {
            String operand = A[i];
            int n1 = Character.getNumericValue(s.charAt(i));
            int n2 = Character.getNumericValue(s.charAt(i + 1));
            if(operand.equals("<")) {
                if(n1 > n2) return;
            } else {
                if(n1 < n2) return;
            }
        }
        max = addZero(String.valueOf(Math.max(Long.parseLong(max), Long.parseLong(s))));
        min = addZero(String.valueOf(Math.min(Long.parseLong(min), Long.parseLong(s))));
    }

    static String addZero(String s) {
        if(s.length() == K + 1) return s;
        else return 0 + s;
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}