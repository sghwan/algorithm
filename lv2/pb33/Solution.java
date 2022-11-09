package lv2.pb33;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

/**
 * 방문 길이
 * 앞 뒤 화살표 방향이 달라도 방문한 곳이라면 갔다온 길 이라는 것이 함정
 */
class Arrow {
    int headX, headY;
    int tailX, tailY;

    public Arrow(int headX, int headY, int tailX, int tailY) {
        this.headX = headX;
        this.headY = headY;
        this.tailX = tailX;
        this.tailY = tailY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arrow arrow = (Arrow) o;
        return headX == arrow.headX
                && headY == arrow.headY
                && tailX == arrow.tailX
                && tailY == arrow.tailY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(headX, headY, tailX, tailY);
    }
}

class Solution {
    static int x = 0;
    static int y = 0;

    public boolean up() {
        if (y < 5) {
            y = y + 1;
            return true;
        }

        return false;
    }

    public boolean down() {
        if (y > -5) {
            y = y - 1;
            return true;
        }

        return false;
    }

    public boolean right() {
        if (x < 5) {
            x = x + 1;
            return true;
        }

        return false;
    }

    public boolean left() {
        if (x > -5) {
            x = x - 1;
            return true;
        }

        return false;
    }

    public boolean moveBy(char dir) {
        if (dir == 'U') return up();
        if (dir == 'D') return down();
        if (dir == 'R') return right();
        if (dir == 'L') return left();
        return false;
    }

    public int solution(String dirs) {
        int answer = 0;
        Set<Arrow> hashSet = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            int tailX = x;
            int tailY = y;
            boolean flag = moveBy(dirs.charAt(i));
            if (flag && hashSet.add(new Arrow(x, y, tailX, tailY)) && hashSet.add(new Arrow(tailX, tailY, x, y))){
                answer++;
            }
        }

        return answer;
    }
}