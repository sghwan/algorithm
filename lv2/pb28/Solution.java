package lv2.pb28;

/**
 * 피로도
 * 정답이긴 하나 코드를 줄일 수 있다. dfs는 값을 넘겨 즉시 계산한다는 생각을 해본다.
 */
class Solution {
    static int[] permutation;
    static boolean[] check;
    static int max = Integer.MIN_VALUE;

    public void dfs(int l, int row, int[][] dungeons, int k) {
        if (l == row) {
            int entranceCount = 0;

            for (int i : permutation) {
                int requiredStamina = dungeons[i][0];
                int consumedStamina = dungeons[i][1];

                if (k < requiredStamina) break;

                k = k - consumedStamina;
                entranceCount++;
            }

            max = Math.max(max, entranceCount);
        } else {
            for (int i = 0; i < row; i++) {
                if (check[i] == false) {
                    check[i] = true;
                    permutation[l] = i;
                    dfs(l + 1, row, dungeons, k);
                    check[i] = false;
                }
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int row = dungeons.length;
        permutation = new int[row];
        check = new boolean[row];

        dfs(0, row, dungeons, k);

        return answer = max;
    }
}
