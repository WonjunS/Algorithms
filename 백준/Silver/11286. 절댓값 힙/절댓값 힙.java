import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> positive = new PriorityQueue<>();
        PriorityQueue<Integer> negative = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            
            if(x == 0) {
                if(positive.isEmpty() && negative.isEmpty()) sb.append("0").append('\n');
                else if(positive.isEmpty() && !negative.isEmpty()) sb.append(negative.poll()).append('\n');
                else if(!positive.isEmpty() && negative.isEmpty()) sb.append(positive.poll()).append('\n');
                else {
                    int p = positive.peek();
                    int n = negative.peek();
                    if(Math.abs(p) < Math.abs(n)) sb.append(positive.poll()).append('\n');
                    else if(Math.abs(p) > Math.abs(n)) sb.append(negative.poll()).append('\n');
                    else sb.append(negative.poll()).append('\n');
                }
            } else {
                if(x < 0) negative.add(x);
                else positive.add(x);
            }
        }
        
        System.out.println(sb);
    }
}