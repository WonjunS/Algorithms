import java.util.*;

public class Main {

    static int N;
    static int[] A;
    static boolean[] visited;
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        A = new int[N + 1];
        list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }

        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);

        sb.append(list.size()).append('\n');
        for(int n : list) {
            sb.append(n).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int x, int target) {
        if(!visited[A[x]]) {
            visited[A[x]] = true;
            dfs(A[x], target);
            visited[A[x]] = false;
        }
        if(A[x] == target) {
            list.add(target);
        }
    }
}