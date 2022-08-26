package chapter6.problem8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = 0, rt = n - 1;
        Arrays.sort(arr);

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(arr[mid] > m) rt = mid - 1;
            else if(arr[mid] < m) lt = mid + 1;
            else {
                answer = mid + 1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        System.out.println(solution(n, m, arr));

    }
}
