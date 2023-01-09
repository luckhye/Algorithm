package naverFinancial;

import java.util.Arrays;

public class solve1_submit {

    public static void main(String[] args) throws InterruptedException {

        int[][] param3 = {{1, 2, 3, 4, 5, 6, 7, 8, 9}, {3, 4, 5, 3, 4, 5, 3, 4, 5}, {2, 2, 2, 2, 2, 2, 2, 2, 2}};
        int[][] param1 = {{1, 2, 3, 4, 5, 6, 7, 8, 9}};
        int[] param2 = {3, 4, 5, 3, 4, 5, 3, 4, 5};
        //System.out.println("답 = "+ mabangzin(param2 ) );
        System.out.println("답 = " + solution(param3));
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

                if (rSum != preSum || chkCnt == -1) {
                    chkCnt = -1;
                    break;
                }

                for (int c = 0; c < rM[r].length; c++) {
                    int cSum = Arrays.stream(rM[r]).sum();

                    if (rSum != cSum) {
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

            answer[k] = chkCnt;
        }


        System.out.println(Arrays.toString(answer));
        return answer;
    }


}