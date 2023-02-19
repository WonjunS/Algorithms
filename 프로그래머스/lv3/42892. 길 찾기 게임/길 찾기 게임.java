import java.util.*;

class Solution {
    
    static class Node {
        private int x;
        private int y;
        private int idx;
        private Node left;
        private Node right;
        
        public Node(int x, int y, int idx, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.left = left;
            this.right = right;
        }
    }
    
    static int N;
    static List<Integer> list1, list2;
    static List<List<Integer>> answer;
    
    public List<List<Integer>> solution(int[][] nodeinfo) {
        answer = new ArrayList<>();
        N = nodeinfo.length;
        Node[] nodes = new Node[N];
        
        for(int i = 0; i < N; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
        }
        
        Arrays.sort(nodes, new Comparator<>(){
           public int compare(Node n1, Node n2) {
               if(n1.y == n2.y) {
                   return n1.x - n2.x;
               }
               return n2.y - n1.y;
           } 
        });
        
        Node parent = nodes[0];
        for(int i = 1; i < N; i++) {
            createTree(parent, nodes[i]);
        }
        
        list1 = new ArrayList<>();
        preorder(parent);
        answer.add(list1);
        
        list2 = new ArrayList<>();
        postorder(parent);
        answer.add(list2);
        
        return answer;
    }
    
    static void createTree(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) parent.left = child;
            else createTree(parent.left, child);
        } else {
            if(parent.right == null) parent.right = child;
            else createTree(parent.right, child);
        }
    }
    
    static void preorder(Node n) {
        if(n != null) {
            list1.add(n.idx);
            preorder(n.left);
            preorder(n.right);
        }
    }
    
    static void postorder(Node n) {
        if(n != null) {
            postorder(n.left);
            postorder(n.right);
            list2.add(n.idx);
        }
    }
}