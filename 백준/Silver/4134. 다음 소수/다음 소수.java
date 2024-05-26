import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            long n = Long.parseLong(br.readLine());

            while(true) {
                if(isPrimeNumber(n)) {
                    sb.append(n).append('\n');
                    break;
                }
                n++;
            }
        }

        System.out.println(sb.toString());
    }

    private static boolean isPrimeNumber(long x) {
        if(x == 1) {
            return false;
        }
        if(x == 2) {
            return true;
        }
        if(x % 2 == 0) {
            return false;
        }

        for(long i = 3; i <= (long) Math.sqrt(x); i+=2) {
            if(x % i == 0) {
                return false;
            }
        }

        return true;
    }

}