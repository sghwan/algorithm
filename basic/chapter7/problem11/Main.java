package chapter7.problem11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;
    static int n;
    static int[][] graph;
    static int[] ch;

    public static void dfs(int row) {
        if (row == n)  {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if(graph[row][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    dfs(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer node = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(node.nextToken());
            int b = Integer.parseInt(node.nextToken());
            graph[a][b] = 1;
        }

        ch[1] = 1;
        dfs(1);
        System.out.println(answer);
    }

}
