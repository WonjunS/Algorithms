import java.util.*;
import java.io.*;

public class Main {
    
    private static final StringBuilder sb = new StringBuilder();
    private static int N;
    private static List<String> exps;
    private static char[] ops;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            
            ops = new char[N - 1];

            exps = new ArrayList<>();
            
            dfs(0);

            exps.sort((o1, o2) -> (o1.compareTo(o2)));
            for(String exp : exps) {
                sb.append(exp).append('\n');
            }

            sb.append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
    private static void dfs(int k) {
        if(k == N - 1) {
            String str = "1";
            String opExp = "";
            String num = "1";
            int n = 2;
            List<String> numList = new ArrayList<>();
            for(int i = 0; i < ops.length; i++) {
                char op = ops[i];
                
                str = str + op + n;
                
                if(op == ' ') {
                    num = num + n;
                } else {
                    opExp = opExp + op;
                    
                    numList.add(num);
                    num = n + "";
                }
                n++;
            }
            
            if(!num.equals("")) numList.add(num);

            int total = Integer.parseInt(numList.get(0));
            for(int i = 0; i < opExp.length(); i++) {
                char c = opExp.charAt(i);
                int x = Integer.parseInt(numList.get(i + 1));
                if(c == '+') {
                    total = total + x;
                } else {
                    total = total - x;
                }
            }
            
            if(total == 0) {
                exps.add(str);
            }
            
            return;
        }
        
        ops[k] = '+';
        dfs(k + 1);
        ops[k] = '/';
        
        ops[k] = '-';
        dfs(k + 1);
        ops[k] = '/';

        ops[k] = ' ';
        dfs(k + 1);
        ops[k] = '/';
    }
    
}