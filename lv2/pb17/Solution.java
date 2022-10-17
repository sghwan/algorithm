package lv2.pb17;

/**
 * 행렬의 곱셈
 */
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int k = 0; k < arr2[0].length; k++) {
                for (int j = 0; j < arr1[i].length; j++) {
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }

        return answer;
    }
}
