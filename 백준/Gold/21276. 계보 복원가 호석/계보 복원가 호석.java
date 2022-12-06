import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N, M, count;
    static ArrayList<String> list;
    static Map<String, Integer> indeg;
    static Map<String, Integer> countMap;
    static Map<String, ArrayList<String>> map;
    static Map<String, ArrayList<String>> new_map;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new ArrayList<>();
        indeg = new HashMap<>();
        countMap = new HashMap<>();
        map = new HashMap<>();
        new_map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            String name = sc.next();
            indeg.put(name, 0);
            map.put(name, new ArrayList<>());
            new_map.put(name, new ArrayList<>());
            list.add(name);
        }

        M = sc.nextInt();
        for(int i = 1; i <= M; i++) {
            String a = sc.next();
            String b = sc.next();

            map.get(b).add(a);
            indeg.put(a, indeg.get(a) + 1);
        }
    }

    static void pro() {
        ArrayList<String> ancestor = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        for(String k : indeg.keySet()) {
            if(indeg.get(k) == 0) {
                count++;
                q.add(k);
                ancestor.add(k);
            }
        }

        sb.append(count).append('\n');

        while(!q.isEmpty()) {
            String s = q.poll();

            int cnt = 0;
            for(String cand : map.get(s)) {
                indeg.put(cand, indeg.get(cand) - 1);
                if(indeg.get(cand) == 0) {
                    q.add(cand);
                    new_map.get(s).add(cand);
                    cnt++;
                }
            }
            countMap.put(s, cnt);
        }

        Collections.sort(list);
        Collections.sort(ancestor);
        for(String k : new_map.keySet()) {
            Collections.sort(new_map.get(k));
        }

        for(String s : ancestor) {
            sb.append(s).append(' ');
        }
        sb.append('\n');

        for(String cand : list) {
            sb.append(cand).append(' ');
            sb.append(new_map.get(cand).size()).append(' ');
            for(String c : new_map.get(cand)) {
                sb.append(c).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}