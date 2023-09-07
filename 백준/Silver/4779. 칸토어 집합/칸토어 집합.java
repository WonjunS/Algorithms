import java.util.*;
import java.io.*;

public class Main {
    
    private static char[] line;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String input;

        while((input = br.readLine()) != null) {
            if(input.equals("")) {
                break;
            }

            int N = Integer.parseInt(input);
            
            int length = (int) Math.pow(3, N);
            
            generateLine(length);
            
            cut(length / 3, length / 3);
            
            for(int i = 0; i < length; i++) {
                sb.append(line[i]);
            }
            
            sb.append('\n');

        }
        
        System.out.println(sb.toString());
    }
    
    private static void generateLine(int L) { 
        line = new char[L];
        for(int i = 0; i < L; i++) {
            line[i] = '-';
        }
    }
    
    private static void cut(int x, int L) {
        if(L == 0) {
            return;
        }
        
        int len = (L / 3) * 2;
        
        for(int i = x; i < x + L; i++) {
            line[i] = ' ';
        }
        
        cut(x - len, L / 3);
        cut(x + len + len, L / 3);
    }
    
}