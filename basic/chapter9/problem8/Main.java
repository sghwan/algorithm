package chapter9.problem8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int t1;
    int t2;
    int cost;

    public Edge(int t1, int t2, int cost) {
        this.t1 = t1;
        this.t2 = t2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
        return this.cost - e.cost;
    }
}

class Solution {
    int[] unf;

    public int find(int t) {
        if (unf[t] == t) return t;
        else return unf[t] = find(unf[t]);
    }

    public void union(int t1, int t2) {
        int ft1 = find(t1);
        int ft2 = find(t2);
        if (ft1 != ft2) unf[ft1] = ft2;
    }

    public int solution(ArrayList<Edge> graph, int v, int e) {
        int answer = 0;
        unf = new int[v + 1];
        Collections.sort(graph);

        for (int i = 1; i <= v; i++) unf[i] = i;

        for (Edge tmp : graph) {
            int ft1 = find(tmp.t1);
            int ft2 = find(tmp.t2);
            if (ft1 != ft2) {
                answer += tmp.cost;
                union(tmp.t1, tmp.t2);
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        ArrayList<Edge> graph = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new Edge(t1, t2, cost));
        }

        Solution s = new Solution();
        System.out.println(s.solution(graph, v, e));
    }
}
