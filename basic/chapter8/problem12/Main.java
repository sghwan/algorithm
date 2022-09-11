package chapter8.problem12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[][] farm;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(int l, int n, int m) {
        int answer = -1;
        int tomatoes = 0;
        Queue<Position> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (farm[i][j] == 1) q.offer(new Position(i, j));
                if (farm[i][j] == 0) tomatoes++;
            }
        }

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Position p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) continue;
                    if (farm[nx][ny] == 0) {
                        farm[nx][ny] = 1;
                        tomatoes--;
                        q.offer(new Position(nx, ny));
                    }
                }
            }
            l++;
        }

        if (tomatoes == 0) answer = l - 1;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        farm = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer t = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                farm[i][j] = Integer.parseInt(t.nextToken());
            }
        }

        System.out.println(bfs(0, n, m));

        return;
    }
}