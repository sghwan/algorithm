package chapter4.problem3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0, i = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (p2 = 0; p2 < k - 1; p2++) {
            hashMap.put(arr[p2], hashMap.getOrDefault(arr[p2], 0) + 1);
        }

        for (p2 = k - 1; p2 < n; p2++) {
            hashMap.put(arr[p2], hashMap.getOrDefault(arr[p2], 0) + 1);
            answer.add(hashMap.size());
            hashMap.put(arr[p1], hashMap.get(arr[p1]) - 1);
            if (hashMap.get(arr[p1]) == 0) hashMap.remove(arr[p1]);
            p1++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        for (int a : solution(n, k, arr)) {
            System.out.print(a + " ");
        }

        return;
    }
}