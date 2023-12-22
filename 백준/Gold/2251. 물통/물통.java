import java.util.*;
import java.io.*;

public class Main {
    
    private static List<Integer> list;
    private static int volA, volB, volC;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        
        volA = Integer.parseInt(str.split(" ")[0]);
        volB = Integer.parseInt(str.split(" ")[1]);
        volC = Integer.parseInt(str.split(" ")[2]);
        
        list = new ArrayList<>();
        
        bfs();
        
        list.sort((o1, o2) -> (o1 - o2));
        
        StringBuilder sb = new StringBuilder();
        for(int x : list) {
            sb.append(x).append(' ');
        }
        
        System.out.println(sb.toString());
    }
    
    private static class Bottle {
        private int a;
        private int b;
        private int c;
        
        public Bottle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    private static void bfs() {
        Queue<Bottle> q = new LinkedList<>();
        boolean[][][] visit = new boolean[volA + 1][volB + 1][volC + 1];
        
        q.add(new Bottle(0, 0, volC));
        
        while(!q.isEmpty()) {
            Bottle curr = q.poll();

            if(visit[curr.a][curr.b][curr.c]) continue;

            if(curr.a == 0) list.add(curr.c);

            visit[curr.a][curr.b][curr.c] = true;

            // a -> b
            q.add(new Bottle(Math.max(0, curr.a + curr.b - volB), Math.min(volB, curr.a + curr.b), curr.c));

            // b -> a
            q.add(new Bottle(Math.min(volA, curr.a + curr.b), Math.max(0, curr.a + curr.b - volA), curr.c));

            // a -> c
            q.add(new Bottle(Math.max(0, curr.a + curr.c - volC), curr.b, Math.min(volC, curr.a + curr.c)));

            // c -> a
            q.add(new Bottle(Math.min(volA, curr.a + curr.c), curr.b, Math.max(0, curr.a + curr.c - volA)));

            // b -> c
            q.add(new Bottle(curr.a, Math.max(0, curr.b + curr.c - volC), Math.min(volC, curr.b + curr.c)));

            // c -> b
            q.add(new Bottle(curr.a, Math.min(volB, curr.b + curr.c), Math.max(0, curr.b + curr.c - volB)));
        }
    }
    
}