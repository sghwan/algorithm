package chapter9.problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Person implements Comparable<Person>{
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person p) {
            return p.height - this.height;
        }
    }

    public static int solution(Person[] info) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        Arrays.sort(info);

        for (Person p : info) {
            if (p.weight > max) {
                max = p.weight;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] info = new Person[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            info[i] = new Person(height, weight);
        }

        System.out.println(solution(info));
    }
}
