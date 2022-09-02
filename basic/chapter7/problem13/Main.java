package chapter7.problem13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int n, m;

    public static int[] bfs(int v) {
        int l = 1;
        int[] answer = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int nv = q.poll();
                int listLen = graph.get(nv).size();
                for (int j = 0; j < listLen; j++) {
                    int x = graph.get(nv).get(j);
                    if (ch[x] == 0) {
                        ch[x] = 1;
                        answer[x] = l;
                        q.offer(x);
                    }
                }
            }
            l++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        ch = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            StringTokenizer node = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(node.nextToken());
            int b = Integer.parseInt(node.nextToken());
            graph.get(a).add(b);
        }

        ch[1] = 1;
        int[] result = bfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + result[i]);
        }
    }
}
