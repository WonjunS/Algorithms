import java.util.*;

public class Main {

    static int count, max_a, max_b, A, B;
    static long X;
    static String num1, num2;

    static void input() {
        Scanner sc = new Scanner(System.in);

        num1 = sc.next();
        num2 = sc.next();
    }

    static void pro() {
        if(num1.length() >= 64 || num2.length() >= 64) {
            if(determination(num1) || determination(num2)) {
                System.out.println("Impossible");
                return;
            }
        }

        for(int i = 0; i < num1.length(); i++) {
            char c = num1.charAt(i);
            if(Character.isDigit(c)) {
                max_a = Math.max(Character.getNumericValue(c), max_a);
            } else {
                max_a = Math.max(max_a, (c - 'a' + 10));
            }
        }

        for(int i = 0; i < num2.length(); i++) {
            char c = num2.charAt(i);
            if(Character.isDigit(c)) {
                max_b = Math.max(Character.getNumericValue(c), max_b);
            } else {
                max_b = Math.max(max_b, (c - 'a' + 10));
            }
        }

        for(int a = max_a + 1; a <= 36; a++) {
            for(int b = max_b + 1; b <= 36; b++) {
                if(a == b) continue;
                dfs(a, b);
            }
        }

        if(count == 0) System.out.println("Impossible");
        if(count == 1) System.out.println(X + " " + A + " " + B);
        if(count >= 2) System.out.println("Multiple");
    }

    static boolean determination(String n) {
        for(int i = 0; i < n.length() - 64; i++) {
            char c = n.charAt(i);
            if(c == '0' || c == '1') continue;
            else return false;
        }
        return true;
    }

    static void dfs(int a, int b) {
        long x_a = 0, x_b = 0;

        for(int i = num1.length() - 1; i >= 0; i--) {
            int n = 0;
            int length = num1.length() - 1 - i;
            char c = num1.charAt(i);
            if(Character.isDigit(c)) n = Character.getNumericValue(c);
            else n = c - 'a' + 10;

            x_a += (long) Math.pow(a, length) * (long) n;
        }

        for(int i = num2.length() - 1; i >= 0; i--) {
            int n = 0;
            int length = num2.length() - 1 - i;
            char c = num2.charAt(i);
            if(Character.isDigit(c)) n = Character.getNumericValue(c);
            else n = c - 'a' + 10;

            x_b += (long) Math.pow(b, length) * (long) n;
        }

        if(x_a == x_b) {
            count++;
            A = a;
            B = b;
            X = x_a;
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}