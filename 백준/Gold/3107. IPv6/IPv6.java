import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String ipv6 = br.readLine();

        StringBuilder sb = new StringBuilder();
        if(ipv6.contains("::")) {
            int idx = 0;
            for(idx = 0; idx < ipv6.length() - 1; idx++) {
                char c1 = ipv6.charAt(idx);
                char c2 = ipv6.charAt(idx + 1);
                if(c1 == ':' && c2 == ':') break;
            }

            String left = ipv6.substring(0, idx);
            String right = ipv6.substring(idx + 2, ipv6.length());

            String[] arr = new String[8];

            if(left.length() > 0 && !left.equals(" ")) {
                String[] str = left.split(":");

                for(int i = 0; i < str.length; i++) {
                    arr[i] = str[i];
                }
            }

            if(right.length() > 0 && !right.equals(" ")) {
                String[] str = right.split(":");

                for(int i = str.length - 1; i >= 0; i--) {
                    arr[7 - i] = str[str.length - i - 1];
                }
            }

            for(int i = 0; i < 8; i++) {
                String s = arr[i];

                if(s == null || s.equals("") || s.equals(" ")) {
                    sb.append("0000");
                } else {
                    for(int j = 0; j < 4 - s.length(); j++) {
                        sb.append("0");
                    }
                    sb.append(s);
                }
                
                if(i < 7) sb.append(":");
            }
        } else {
            String[] str = ipv6.split(":");
            for(int i = 0; i < str.length; i++) {
                String s = str[i];
                for(int j = 1; j <= 4 - s.length(); j++) {
                    sb.append("0");
                }
                sb.append(s);

                if(i < str.length - 1) {
                    sb.append(":");
                }
            }
        }

        System.out.println(sb.toString());
    }

}