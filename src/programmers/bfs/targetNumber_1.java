package programmers.bfs;

import java.util.ArrayList;
import java.util.Collections;

public class targetNumber_1 {

    public static void main(String[] args) {

        int[] param1 = {4, 1, 2, 1};
        int param2 = 4;

        System.out.println("답 = " + solution(param1, param2));
    }

    ;


    public static int solution(int[] numbers, int target) {
        int answer = 0;
        System.out.println("solution-!");

        int count = dfs(numbers, target, 0, 0, "0");
        //count = dfs2(numbers, 0, 0, target);


        return count;

    }

    // 파람 numbers, 파람 target, 반복 조건 i, 합산 sum, 더할 값 numbers요소
    private static int dfs(int[] numbers, int target, int i, int sum, String txt) {
        //System.out.printf("i = %d, sum = %d \n",i,sum);

        // 특정조건 동안 반복   : sum + numbers[i] 의 i가 array를 다 돌때.
        if (i == numbers.length) {
            // System.out.printf("txt = %s, sum = %d \n", txt,sum);
            // 특정조건을 기준으로 분기. : count 세기
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        // 그 외 반복.
        // i 번째 내용물.
        return dfs(numbers, target, i + 1, sum + numbers[i], txt + " + " + numbers[i]) + dfs(numbers, target, i + 1, sum + (-1) * numbers[i], txt + " - " + numbers[i]);
    }

    // 파람 numbers, 파람 target, 반복 조건 i, 합산 sum, 더할 값 numbers요소
    private static int dfs2(int[] numbers, int n, int sum, int target) {
        if (n == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs2(numbers, n + 1, sum + numbers[n], target) + dfs2(numbers, n + 1, sum - numbers[n], target);
    }

}