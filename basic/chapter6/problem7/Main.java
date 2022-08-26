package chapter6.problem7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }
    }

    public static Coordinate[] solution(int n, Coordinate[] cArr) {
/*
        //클래스만 만들어 주고 Arrays util을 사용한 정렬을 할 때
        Arrays.sort(cArr, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            }
        });

        return cArr;
 */
        //클래스를 Comparable 인터페이스를 implements 하여 compareTo 메서드를 오버라이딩할 때
        Arrays.sort(cArr);
        return cArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Coordinate[] cArr = new Coordinate[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cArr[i] = new Coordinate(x, y);
        }
        for (Coordinate c : solution(n, cArr)) {
            System.out.println(c.x + " " + c.y);
        }
    }
}
