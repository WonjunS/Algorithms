import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        
        String expression = br.readLine();
        int count = 0;
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == '+' || c == '-') {
                count++;
            }
        }

        
        String[] nums = new String[count + 1];
        char[] ops = new char[count];
        int idx_num = 0;
        int idx_op = 0;
        int k = 0;
        String n = "";
        while(k < expression.length()) {
            char c = expression.charAt(k);
            if(c == '+' || c == '-') {
                nums[idx_num++] = n;
                ops[idx_op++] = c;
                n = "";
            } else {
                n = n + c;
            }
            k++;
        }

        nums[idx_num++] = n;

        int total = Integer.parseInt(nums[0]);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < ops.length; i++) {
            char op = ops[i];
            int num = Integer.parseInt(nums[i + 1]);
            if(op == '+') {
                total += num;
            } else {
                list.add(total);
                total = num;
            }
        }

        list.add(total);
        
        int answer = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            answer = answer - list.get(i);
        }
        
        System.out.println(answer);
    }
    
}