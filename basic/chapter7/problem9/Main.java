package chapter7.problem9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int data) {
        this.data = data;
        lt = null;
        rt = null;
    }
}

public class Main {
    Node root;

    public int dfs(int l, Node root) {
        if (root.lt == null && root.rt == null) return l;
        else return Math.min(dfs(l + 1, root.lt), dfs(l + 1, root.rt));
    }

    public static void main(String[] args) throws IOException {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.dfs(0, tree.root));
    }
}
