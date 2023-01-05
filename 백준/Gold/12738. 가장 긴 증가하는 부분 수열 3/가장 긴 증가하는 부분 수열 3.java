import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            
            if(val > list.get(list.size() - 1)) {
                list.add(val);
            } else {
                int L = 1, R = list.size() - 1;
                while(L < R) {
                    int mid = (L + R) / 2;
                    if(list.get(mid) < val) {
                        L = mid + 1;
                    } else {
                        R = mid;
                    }
                }
                list.set(R, val);
            }
        }
        System.out.println(list.size() - 1);
    }
}