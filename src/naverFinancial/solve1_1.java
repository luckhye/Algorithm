package naverFinancial;

import java.util.Arrays;

public class solve1_1 {

    public static void main(String[] args) throws InterruptedException {

        int[][] param3 = {{1, 2, 3, 4, 5, 6, 7, 8, 9}, {3, 4, 5, 3, 4, 5, 3, 4, 5}, {2, 2, 2, 2, 2, 2, 2, 2, 2}};
        int[][] param1 = {{1, 2, 3, 4, 5, 6, 7, 8, 9}};
        int[] param2 = {3, 4, 5, 3, 4, 5, 3, 4, 5};
        int[][] param4 = {{1, 2, 3, 4, 1, 2, 3, 4, 100}, {1, 2, 1, 2, 1, 2, 1, 2, 1}};
        //System.out.println("답 = "+ mabangzin(param2 ) );
        System.out.println("답 = " + solution(param4));
    }

    ;

    public static int[] solution(int[][] numbers) {
        int[] answer = new int[numbers.length];

        for (int k = 0; k < numbers.length; k++) {
            //int[][] resultM = magicSquare( numbers[k] );
            int[] m = numbers[k];


            int[][] rM = new int[3][3];
            int rmLen = 3;
            //System.out.printf("len = %d ", rmLen);
            int row = 0, col = rmLen / 2;

            // 정렬
            Arrays.sort(m);
            //System.out.println("정렬~~ = "+Arrays.toString(m));


            for (int i = 1; i <= m.length; i++) {
                rM[row][col] = m[i - 1];

                if (i % 3 == 0) {
                    //System.out.printf("계산전 row = %d, col = %d \n", row, col);
                    row++;
                    //System.out.printf("계산후 row = %d, col = %d \n", row, col);
                } else {
                    // 0 1 2
                    //System.out.printf("계산전 row = %d, col = %d \n", row, col);
                    row--;
                    col++;
                    if (row == -1) row = rmLen - 1;
                    if (col == rmLen) col = 0;
                    //System.out.printf("계산후 row = %d, col = %d \n", row, col);
                }

            }

            int[][] resultM = rM;


            // 검증
            int chkCnt = 0;
            int preSum = 0;
            for (int r = 0; r < rM.length; r++) {
                int rSum = Arrays.stream(rM[r]).sum();
                if (r == 0) preSum = rSum;
                System.out.printf("r  = %d, rSum = %d , preSum = %d \n", r, rSum, preSum);

                if (rSum != preSum || chkCnt == -1) {
                    System.out.println("R break!");
                    chkCnt = -1;
                    break;
                }

                for (int c = 0; c < rM[r].length; c++) {
                    int cSum = Arrays.stream(rM[r]).sum();

                    if (rSum != cSum) {
                        System.out.println("C break!");
                        chkCnt = -1;
                        break;
                    }
                }

            }
            ;

            if (chkCnt == -1) {
                chkCnt = 0;
            } else {
                chkCnt = 1;
            }


            System.out.println("chkCnt = " + chkCnt);

            answer[k] = chkCnt;
        }

        System.out.println("answer = " + answer + ",  " + Arrays.toString(answer));
        return answer;
    }


    // 2차원 배열 출력 함수
    public static void dispM(int[][] m) {
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++)
                System.out.printf("%3d", m[r][c]);
            System.out.println();
        }
        System.out.println();

    }


}