import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            if(val > list.get(list.size() - 1)) {
                list.add(val);
            } else {
                int left = 1, right = list.size() - 1, idx = right;
                while(left <= right) {
                    int mid = (left + right) / 2;
                    if(list.get(mid) < val) {
                        left = mid + 1;
                    } else {
                        idx = mid;
                        right = mid - 1;
                    }
                }
                list.set(idx, val);
            }
        }
        System.out.println(list.size() - 1);
    }
}