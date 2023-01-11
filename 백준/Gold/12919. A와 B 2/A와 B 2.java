import java.util.*;

public class Main {

    static String S, T;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        S = sc.next();
        T = sc.next();

        flag = false;
        recur(T);

        if(flag) System.out.println(1);
        else System.out.println(0);
    }

    static void recur(String t) {
        if(t.length() == S.length()) {
            if(S.equals(t)) flag = true;
            return;
        }
        if(t.charAt(0) == 'B') {
            String substring = t.substring(1);
            StringBuilder sb = new StringBuilder(substring);
            recur(sb.reverse().toString());
        }
        if(t.charAt(t.length() - 1) == 'A') {
            recur(t.substring(0, t.length() - 1));
        }
    }
}