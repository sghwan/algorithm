package lv2.pb30;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 프렌즈4블록
 * 정답, 효율성도 어느정도는 나오는 듯함 하지만 코드의 가독성이 떨어져 리팩토링 필요
 */
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};

    private char[][] toArray(int m, int n, String[] board) {
        char[][] arr = new char[m][n];

        for (int i = 0; i < m; i++) {
            String tmp = board[i];
            for (int j = 0; j < n; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        return arr;
    }

    private List<Point> searchBlockTobeRemoved(int m, int n, char[][] map) {
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                boolean flag = false;

                if (map[i][j] == '0')
                    continue;

                for (int k = 0; k < 3; k++) {
                    if (map[i][j] != map[i + dx[k]][j + dy[k]]) {
                        flag = true;
                        break;
                    }
                }

                if (flag)
                    continue;

                list.add(new Point(i, j));

                for (int k = 0; k < 3; k++) {
                    list.add(new Point(i + dx[k], j + dy[k]));
                }
            }
        }

        return list;
    }

    private int destroyBlock(List<Point> points, char[][] map) {
        int count = 0;

        for (Point p : points) {
            if (map[p.x][p.y] != '0') {
                map[p.x][p.y] = '0';
                count++;
            }
        }

        return count;
    }

    private void moveBlock(int m, int n, char[][] map) {
        for (int i = 0; i < n; i++) {
            LinkedList<Character> list = new LinkedList<>();

            for (int j = 0; j < m; j++) {
                list.add(map[j][i]);
            }

            for (int j = 0; j < m; j++) {
                if (list.get(j) == '0')
                    list.addFirst(list.remove(j));
            }

            for (int j = 0; j < m; j++) {
                map[j][i] = list.get(j);
            }
        }
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = toArray(m, n, board);

        while (true) {
            List<Point> points = searchBlockTobeRemoved(m, n, map);
            if (points.size() == 0) break;
            answer += destroyBlock(points, map);
            moveBlock(m, n, map);
        }

        return answer;
    }
}