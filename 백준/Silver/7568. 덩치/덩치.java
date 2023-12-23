import java.util.*;
import java.io.*;

public class Main {
    
    private static class Person {
        private long no;
        private int cnt;
        private int height;
        private int weight;
        
        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
        
        public Person(long no, int cnt) {
            this.no = no;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        List<Person> list = new ArrayList<>();

        int[] A = new int[N];
        
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            list.add(new Person(x, y));
        }
        
        List<Person> count = new ArrayList<>();
        
        for(int i = 0; i < list.size(); i++) {
            Person curr = list.get(i);
            int cnt = 0;
            for(int j = 0; j < list.size(); j++) {
                if(i == j) continue;
                
                Person comp = list.get(j);
                
                if(curr.weight < comp.weight && curr.height < comp.height) {
                    cnt++;
                }
            }

            count.add(new Person((long) i, cnt));
        }
        
        count.sort((o1, o2) -> (o1.cnt - o2.cnt));

        for(int i = 1; i <= count.size(); i++) {
            Person p = count.get(i - 1);

            A[(int) p.no] = p.cnt + 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int x : A) {
            sb.append(x).append(' ');
        }
        
        System.out.println(sb.toString());
    }
    
}