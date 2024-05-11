import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            if(isPrimeNumber(k)) {
                sb.append(0).append('\n');
            } else {
                int before = -1;
                int after = -1;

                for(int i = k - 1; i >= 2; i--) {
                    if(isPrimeNumber(i)) {
                        before = i;
                        break;
                    }
                }

                for(int i = k + 1; i <= 1_299_709; i++) {
                    if(isPrimeNumber(i)) {
                        after = i;
                        break;
                    }
                }
                
                if(before == -1 | after == -1) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(after - before).append('\n');
                }
            }
        }
        
        System.out.println(sb.toString());
    }

    private static boolean isPrimeNumber(int x) {
        if(x == 2) {
            return true;
        }

        if(x == 1 || (x != 2 && x % 2 == 0)) {
            return false;
        }
        
        for(int i = 3; i <= Math.sqrt(x); i+=2) {
            if(x % i == 0) {
                return false;
            }
        }

        return true;
    }

}