package chapter9.problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture> {
    int money;
    int day;

    public Lecture(int money, int day) {
        this.money = money;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture l) {
        return l.day - this.day;
    }
}

class Solution {
    public int solution(Lecture[] arr, int n) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(arr);
        int max = arr[0].day;
        int j = 0;

        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (arr[j].day < i) break;
                q.add(arr[j].money);
            }
            if (!q.isEmpty()) answer += q.poll();
        }

        return answer;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Lecture[] arr = new Lecture[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            arr[i] = new Lecture(money, day);
        }

        Solution s = new Solution();
        System.out.println(s.solution(arr, n));
    }
}
