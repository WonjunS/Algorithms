import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static int Q, choice, k, b;
    static long ans;
    static String name;
    static HashMap<String, PriorityQueue<Integer>> map;

    static void input() {
        map = new HashMap<>();

        Q = sc.nextInt();
    }

    static void pro() {
        for(int q = 0; q < Q; q++) {
            choice = sc.nextInt();

            if(choice == 1) {
                name = sc.next();
                if(!map.containsKey(name)) {
                    map.put(name, new PriorityQueue<Integer>(Comparator.reverseOrder()));
                }
                k = sc.nextInt();
                for(int i = 0; i < k; i++) {
                    int C = sc.nextInt();
                    map.get(name).add(C);
                }
            } else {
                name = sc.next();
                b = sc.nextInt();
                if(!map.containsKey(name)) continue;
                else {
                    for(int i = 0; i < b; i++) {
                        if(map.get(name).isEmpty()) break;
                        int C = map.get(name).remove();
                        ans += C;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}