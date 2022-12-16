import java.util.*;
import java.io.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    static ArrayList<Integer> a;
    
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        a = new ArrayList<>();
        while((input = br.readLine()) != null) {
            a.add(Integer.parseInt(input));
        }
    }
    
    static void pro() {
        traverse(0, a.size() - 1);
        System.out.println(sb);
    }
    
    static void traverse(int l, int r) {
        if(l > r) return;
        int mid = r;
        for(int i = l + 1; i <= r; i++) {
            if(a.get(i) > a.get(l)) {
                mid = i - 1;
                break;
            }
        }
        
        traverse(l + 1, mid);
        traverse(mid + 1, r);
        sb.append(a.get(l)).append('\n');
    }
    
    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}