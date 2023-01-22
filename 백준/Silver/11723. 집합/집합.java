import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        ArrayList<Integer> list = new ArrayList<>();
        int M = Integer.parseInt(br.readLine());
        int x;
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    if(list.isEmpty() || !list.contains(x)) list.add(x);
                    continue;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    if(list.isEmpty() || !list.contains(x)) continue;
                    else list.remove(list.indexOf(x));
                    continue;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    if(list.isEmpty() || !list.contains(x)) {
                        sb.append('0').append('\n');
                    } else sb.append('1').append('\n');
                    continue;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    if(list.isEmpty() || !list.contains(x)) {
                        list.add(x);
                        continue;
                    } else list.remove(list.indexOf(x));
                    continue;
                case "all":
                    list.clear();
                    for(int i = 1; i <= 20; i++) list.add(i);
                    continue;
                case "empty":
                    list.clear();
                    continue;
            }
        }
        System.out.println(sb);
    }
}