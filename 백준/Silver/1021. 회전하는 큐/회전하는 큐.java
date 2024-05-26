import java.util.*;
import java.io.*;

public class Main {

    private static class Queue {

        private int size;
        private int[] queue;

        public Queue(int N) {
            this.queue = new int[N];
            this.size = N;
        }

        public void init() {
            for(int i = 0; i < size; i++) {
                queue[i] = i + 1;
            }
        }

        public int dequeue() {
            if(size == 0) {
                return -1;
            }

            int t = queue[0];
            size--;
            for(int i = 0; i < size; i++) {
                queue[i] = queue[i + 1];
            }
            queue[size] = -1;

            return t;
        }

        public int getIndex(int x) {
            int idx = 0;
            for(int i = 0; i < size; i++) {
                if(queue[i] == x) {
                    idx = i;
                }
            }
            return idx;
        }

        public void shiftLeft() {
            int temp = queue[0];
            for(int i = 0; i < size - 1; i++) {
                queue[i] = queue[i + 1];
            }
            queue[size - 1] = temp;
        }

        public void shiftRight() {
            int temp = queue[size - 1];
            int[] tmp = queue.clone();
            for(int i = 1; i < size; i++) {
                queue[i] = tmp[i - 1];
            }
            queue[0] = temp;
        }

        public void list() {
            String str = "";
            for(int i = 0; i < size; i++) {
                str = str + queue[i] + " ";
            }

            System.out.println(str);
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue q = new Queue(N);
        q.init();

        int answer = 0;

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());

            int idx = q.getIndex(x);

            int left = idx;
            int right = q.size - idx;

            if(left >= right) {
                for(int i = 0; i < right; i++) {
                    q.shiftRight();
                }

                q.dequeue();
                answer += right;
            } else {
                for(int i = 0; i < left; i++) {
                    q.shiftLeft();
                }

                q.dequeue();
                answer += left;
            }
        }

        System.out.println(answer);
    }

}