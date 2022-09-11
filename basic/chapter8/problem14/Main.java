package chapter8.problem14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, answer = Integer.MAX_VALUE;
    static ArrayList<Point> list = new ArrayList<>();
    static ArrayList<Point> home = new ArrayList<>();
    static int[] ch;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int distance(ArrayList<Point> store) {
        int distance = 0;
        for (Point h : home) {
            int min = Integer.MAX_VALUE;
            for (Point p : store) {
                min = Math.min(min, Math.abs(h.x - p.x) + Math.abs(h.y - p.y));
            }
            distance += min;
        }
        return distance;
    }

    public static void chooseStore(int l, int s) {
        if (l == m) {
            ArrayList<Point> store = new ArrayList<>();
            for (int idx : ch) {
                store.add(list.get(idx));
            }
            answer = Math.min(distance(store), answer);
        } else {
            for (int i = s; i < list.size(); i++) {
                ch[l] = i;
                chooseStore(l + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ch = new int[m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st1.nextToken());
                if (tmp == 2) list.add(new Point(i, j));
                else if (tmp == 1) home.add(new Point(i, j));
            }
        }

        chooseStore(0, 0);
        System.out.println(answer);
    }
}
