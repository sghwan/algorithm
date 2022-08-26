package chapter6.problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] solution(int s, int n, int[] arr) {
        int[] answer = new int[s];

        for (int i = 0 ; i < n; i++) {
            int idx = s - 1;
            for(int k = 0; k < s; k++) {
                if(answer[k] == arr[i]) {
                    idx = k;
                    break;
                }
            }
            for(int j = idx; j >= 1; j--) {
                answer[j] = answer[j - 1];
            }
            answer[0] = arr[i];
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st1.nextToken());
        int n = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        for (int x : solution(s, n, arr)) {
            System.out.print(x + " ");
        }
    }
}


