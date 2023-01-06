import java.util.*;

public class Main {

    static int N, ans;
    static boolean[] isPrime;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
    }

    static void pro() {
        preprocess();
        
        for(int i = N; i <= 1003001; i++) {
            if(isPrime[i] && isPalindrome(i)) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
    
    static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        for(int i = 0; i <= s.length() / 2; i++) {
            if(s.charAt(i) == s.charAt(s.length() - i - 1)) continue;
            else return false;
        }
        return true;
    }

    static void preprocess() {
        isPrime = new boolean[1003002];

        isPrime[1] = false;
        for(int n = 2; n <= 1003001; n++) {
            if(n == 2) isPrime[n] = true;
            if(n % 2 == 0 && n != 2) isPrime[n] = false;
            else{
                boolean flag = true;
                for(int k = 2; k <= Math.sqrt(n); k++) {
                    if(n % k == 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    isPrime[n] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}