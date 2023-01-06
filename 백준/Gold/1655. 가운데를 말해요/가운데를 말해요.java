import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> over = new PriorityQueue<>();
        PriorityQueue<Integer> under = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            
            if(under.size() == 0) {
                under.add(x);
            } else {
                if(under.size() == over.size()) {
                    if(x <= under.peek()) {
                        under.add(x);
                    } else {
                        if(x > over.peek()) {
                            under.add(over.poll());
                            over.add(x);
                        } else {
                            under.add(x);
                        }
                    }
                } else {
                    if(x > under.peek()) {
                        over.add(x);
                    } else {
                        over.add(under.poll());
                        under.add(x);
                    }
                }
            }
            sb.append(under.peek()).append('\n');
        }
        
        System.out.println(sb);
    }
}