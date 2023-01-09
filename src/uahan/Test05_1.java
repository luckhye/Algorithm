package uahan;

import java.util.Arrays;

// 배민 - 탐색
public class Test05_1 {
    public static void main(String[] args) {


        Solution s = new Solution();
//        System.out.println("N,K");
//        System.out.println("sell,아래 sell");
//        System.out.println("U, sumU");
//        System.out.println("L, sumL");
//        System.out.println("C");
        int N = 2;
        int U = 2;
        int L = 2;
        int[] C = {2, 2};

        System.out.println("입력값 : N =" + N + ", U = " + U + ", L =" + L + ", C =" + Arrays.toString(C));
        System.out.println("답 : " + s.Solution(2, 2, C));


    }

    ;

    static class Solution {
        static int[][] M;
        static Boolean stop = false;

        public String Solution(int U, int L, int[] C) {
            int N = C.length; //2

            M = new int[2][N]; //2
            dfs(M, N, -1, 0, 0, 0, 0, U, L, C);
            if (!stop) {
                return "IMPOSSIBLE";
            }

            String result = "";
            for (int i = 0; i < M.length; i++) {
                result += Arrays.toString(M[i]) + "";
                if (i != M.length - 1) {
                    result += ",";
                }
            }
            ;
            result = result.replace("[", "").replace("]", "").replace(" ", "");

            return result;

        }

        ;


        public int dfs(int[][] sumM, int N, int k, int sumU, int sumL, int sumM_0, int sumM_1, int U, int L, int[] C) {

            if (k == N) {
                if (sumL == L && sumU == U) {
                    M = sumM;
                    stop = true;
                }
                return 1;
            }

            if (sumU > U || sumL > L) {
                sumM = new int[2][N];
                return 0;
            }

            if (sumM_1 > 1 || sumM_1 < 0) {
                sumM = new int[2][N];
                return 0;
            }

            if (k == -1) {
                return dfs(sumM, N, k + 1, sumU + 0, sumL + 0, 0, 0, U, L, C)
                        + dfs(sumM, N, k + 1, sumU + 1, sumL + 1, 1, 1, U, L, C);
            }

            sumM[0][k] = sumM_0;
            sumM[1][k] = sumM_1;
            return dfs(sumM, N, k + 1, sumU + 0, sumL + (C[k] - 0), 0, (C[k] - 0), U, L, C)
                    + dfs(sumM, N, k + 1, sumU + 1, sumL + (C[k] - 1), 1, (C[k] - 1), U, L, C);

        }

        ;


    }

}