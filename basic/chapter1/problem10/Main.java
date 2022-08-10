package chapter1.problem10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int[] solution(String s, char ch) {
        char[] arr = s.toCharArray();
        int[] answer = new int[s.length()];
        int p = 1000;

        for(int i = 0; i < s.length(); i++) {
            if(arr[i] == ch) {
                p = 0;
                answer[i] = p;
            } else {
                p += 1;
                answer[i] = p;
            }
        }

        for(int i = s.length() - 1; i >= 0; i--) {
            if(arr[i] == ch) {
                p = 0;
                answer[i] = p;
            } else {
                p += 1;
                if(answer[i] > p)
                    answer[i] = p;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        char ch = st.nextToken().charAt(0);

        int[] answer = solution(s, ch);

        for(int a : answer) {
            System.out.print(a+ " ");
        }

        return;
    }
}