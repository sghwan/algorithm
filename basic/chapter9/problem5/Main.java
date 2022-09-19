package chapter9.problem5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int vertex;
    int cost;

    public Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
        return this.cost - e.cost;
    }
}

class Solution {
    public int[] solution(int v, ArrayList<ArrayList<Edge>> list, int[] dis) {
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        dis[v] = 0;
        while (!pQ.isEmpty()) {
            Edge cur = pQ.poll();
            int curVex = cur.vertex;
            int curCost = cur.cost;
            if (curCost > dis[curVex]) continue;
            for (Edge e : list.get(curVex)) {
                if (dis[e.vertex] > curCost + e.cost) {
                    dis[e.vertex] = curCost + e.cost;
                    pQ.offer(new Edge(e.vertex, curCost + e.cost));
                }
            }
        }
        return dis;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Edge>> list = new ArrayList<>();
        int[] dis = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int curVertex = Integer.parseInt(st1.nextToken());
            int nextVertex = Integer.parseInt(st1.nextToken());
            int cost = Integer.parseInt(st1.nextToken());
            list.get(curVertex).add(new Edge(nextVertex, cost));
        }

        Solution s = new Solution();
        int[] result = s.solution(1, list, dis);

        for (int i = 2; i <= n; i++) {
            if (result[i] < Integer.MAX_VALUE) System.out.println(i + " : " + result[i]);
            else System.out.println(i + " : impossible");
        }

    }
}
