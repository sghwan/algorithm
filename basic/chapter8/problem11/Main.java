package chapter8.problem11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int NUM = 7;
    static int[][] maze = new int[NUM][NUM];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(int l, int x, int y) {
        Queue<Coordinate> q = new LinkedList<>();
        q.offer(new Coordinate(x, y));
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Coordinate cur = q.poll();
                maze[cur.x][cur.y] = 1;
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx == NUM - 1 && ny == NUM - 1) return l + 1;
                    if (nx < 0 || nx > NUM - 1 || ny < 0 || ny > NUM - 1) continue;
                    if (maze[nx][ny] == 0) q.offer(new Coordinate(nx, ny));
                }
            }
            l++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < NUM; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < NUM; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        System.out.println(bfs(0, 0, 0));

        return;
    }
}

