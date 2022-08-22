package chapter5.problem8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Obj {
        int risk;
        int idx;

        public Obj(int risk, int idx) {
            this.risk = risk;
            this.idx = idx;
        }
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0, max = 0, cnt = 0, k = 0;
        Integer[] order = new Integer[n];
        Queue<Obj> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            order[i] = arr[i];
            queue.add(new Obj(arr[i], i));
        }

        Arrays.sort(order, Collections.reverseOrder());

        while (true) {
            if(queue.peek().risk == order[k]) {
                Obj tmp = queue.poll();
                cnt++;
                k++;
                if(tmp.idx == m) break;
            } else {
                Obj tmp = queue.poll();
                queue.add(tmp);
            }
        }

        answer = cnt;

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        System.out.println(solution(n, m, arr));
        return;
    }
}

