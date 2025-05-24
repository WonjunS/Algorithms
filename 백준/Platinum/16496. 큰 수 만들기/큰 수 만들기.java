import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        String[] strNums = new String[N];
        for(int i = 0; i < N; i++) {
            strNums[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(strNums, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        boolean flag = false;
        for(int i = 0; i < N - 1; i++) {
            String s = strNums[i];
            if(flag == false && s.equals("0")) {
                continue;
            }
            flag = true;
            sb.append(s);
        }

        sb.append(strNums[N - 1]);

        System.out.println(sb.toString());
    }
}