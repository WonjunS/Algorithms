import java.util.*;
import java.io.*;

public class Main {
    
    static class Task {
        private int T;
        private int S;
        
        public Task(int T, int S) {
            this.T = T;
            this.S = S;
        }
    }
    
    private static List<Task> list;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        list = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            
            list.add(new Task(t, s));
        }
        
        list.sort(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.S == o2.S) {
                    return o2.T - o1.T;
                }
                return o1.S - o2.S;
            }
        });
        
        Task task = list.get(0);
        int max = task.S - task.T;
        
        int start = -1;
        for(int i = 0; i <= max; i++) {
            boolean run = true;
            int time = i;
            for(Task t : list) {
                time += t.T;
            
                if(time > t.S) {
                    run = false;
                    break;
                }
            }
            if(run) {
                start = i;
            }
        }
        
        System.out.println(start);
    }
    
}