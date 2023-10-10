import java.util.*;
import java.io.*;

public class Main {
    
    private static int curr;
    private static String str;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        str = br.readLine();
        
        curr = 1;
        while(true) {
            if(str.length() == 0) {
                break;
            }

            erase();

            curr++;
        }
        
        System.out.println(curr - 1);
    }

    private static void erase() {
        String n = String.valueOf(curr);

        int idx = 0;
        while(idx < n.length()) {
            if(str.length() == 0) {
                return;
            }

            char c = n.charAt(idx);
            
            if(c == str.charAt(0)) {
                str = str.substring(1, str.length());
            }

            idx++;
        }
    }
    
}