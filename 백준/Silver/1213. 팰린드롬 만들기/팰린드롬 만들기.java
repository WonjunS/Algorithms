import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static char[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String name = br.readLine();

        N = name.length();
        arr = new char[26];

        for(int i = 0; i < N; i++) {
            char c = name.charAt(i);
            int idx = c - 'A';
            arr[idx]++;
        }

        String str1 = "", str2 = "", mid = "";
        boolean flag = true;
        int odd_count = 0;
        for(int i = 0 ; i < 26; i++) {
            char c = (char) (65 + i);
            int cnt = arr[i];

            if(cnt == 0) continue;
            if(cnt % 2 == 0) {
                int len = cnt / 2;
                for(int j = 0; j < len; j++) {
                    str1 = str1 + c;
                    str2 = c + str2;
                }
            } else {
                if(odd_count == 1) {
                    flag = false;
                    break;
                } else {
                    int len = cnt / 2;
                    for(int j = 0; j < len; j++) {
                        str1 = str1 + c;
                        str2 = c + str2;
                    }
                    mid = c + "";
                    odd_count++;
                }
            }
        }

        String answer = "";
        if(flag) {
            answer = str1 + mid + str2;
        } else {
            answer = "I'm Sorry Hansoo";
        }
        
        System.out.println(answer);
    }

}