package chapter9.problem7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int town;
    int cost;

    public Edge(int town, int cost) {
        this.town = town;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

class Solution {
    public int solution(ArrayList<ArrayList<Edge>> graph, int v, int e) {
        int answer = 0;
        int[] ch = new int[v + 1];
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));

        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int curTown = tmp.town;
            int curCost = tmp.cost;
            if (ch[curTown] == 0) {
                ch[curTown] = 1;
                answer += curCost;
                for (Edge x : graph.get(curTown)) {
                    int xTown = x.town;
                    int xCost = x.cost;
                    if (ch[xTown] == 0) pQ.offer(new Edge(xTown, xCost));
                }
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
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, cost));
            graph.get(b).add(new Edge(a, cost));
        }

        Solution s = new Solution();
        System.out.println(s.solution(graph, v, e));
    }
}
