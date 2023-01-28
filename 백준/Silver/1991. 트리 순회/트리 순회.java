import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static ArrayList<Integer>[] child;

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        child = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            child[i] = new ArrayList<>();
        }
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char child1 = st.nextToken().charAt(0);
            char child2 = st.nextToken().charAt(0);

            if(child1 != '.') child[parent - 'A'].add(child1 - 'A');
            if(child1 == '.') child[parent - 'A'].add(-1);
            if(child2 != '.') child[parent - 'A'].add(child2 - 'A');
            if(child2 == '.') child[parent - 'A'].add(-1);
        }
    }

    static void pro() {
        preorder(0);
        sb.append('\n');
        inorder(0);
        sb.append('\n');
        postorder(0);
        sb.append('\n');
        System.out.println(sb);
    }

    static void preorder(int curr) {
        if(curr == -1) return;
        sb.append((char) (curr + 'A'));
        for(int y : child[curr]) {
            preorder(y);
        }
    }

    static void inorder(int curr) {
        if(curr == -1) return;
        inorder(child[curr].get(0));
        sb.append((char) (curr + 'A'));
        inorder(child[curr].get(1));
    }

    static void postorder(int curr) {
        if(curr == -1) return;
        postorder(child[curr].get(0));
        postorder(child[curr].get(1));
        sb.append((char) (curr + 'A'));
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}