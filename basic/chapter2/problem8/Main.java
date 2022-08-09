package chapter2.problem8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int[] solution(int[] arr) {
        int[] answer = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            answer[i] = 1;
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(i == j) continue;

                if(arr[i] < arr[j]) answer[i] += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int a : solution(arr)) {
            System.out.print(a + " ");
        }

        return;
    }
}
