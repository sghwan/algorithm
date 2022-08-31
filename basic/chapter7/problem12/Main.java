package chapter7.problem12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;
    static int n;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public static void dfs(int row) {
        if (row == n) {
            answer++;
        } else {
            for (int i = 0; i < graph.get(row).size(); i++) {
                int v = graph.get(row).get(i);
                if (ch[v] == 0) {
                    ch[v] = 1;
                    dfs(v);
                    ch[v] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        ch = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer node = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(node.nextToken());
            int b = Integer.parseInt(node.nextToken());
            graph.get(a).add(b);
        }

        ch[1] = 1;
        dfs(1);
        System.out.println(answer);
    }

}

