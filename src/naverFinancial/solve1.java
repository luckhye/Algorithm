package naverFinancial;

import java.util.Arrays;

public class solve1 {

    public static void main(String[] args) throws InterruptedException {

        int[][] param3 = {{1, 2, 3, 4, 5, 6, 7, 8, 9}, {3, 4, 5, 3, 4, 5, 3, 4, 5}, {2, 2, 2, 2, 2, 2, 2, 2, 2}};
        int[][] param1 = {{1, 2, 3, 4, 5, 6, 7, 8, 9}};
        int[] param2 = {3, 4, 5, 3, 4, 5, 3, 4, 5};
        //System.out.println("답 = "+ mabangzin(param2 ) );
        System.out.println("답 = " + solution(param3));
    }

    ;

    public static int[] solution(int[][] numbers) throws InterruptedException {
        int[] answer = new int[numbers.length];

        for (int k = 0; k < numbers.length; k++) {
            int[][] resultM = getMagicSquare_custom(numbers[k]);
            answer[k] = chkCnt(resultM);
        }

        System.out.println(Arrays.toString(answer));
        return answer;

    }


    public static int[] mabangzin(int[] numbers) throws InterruptedException {
        int[] answer = {};

        int[][] m = new int[3][3];
        getMagicSquare(m);

        return answer;

    }

    private static void getMagicSquare(int[][] m) throws InterruptedException {
        int len = 3;
        System.out.printf("len = %d ", len);
        int row = 0, col = len / 2;

        for (int j = 0; j < 10; j++) {
            System.out.println();

        }
        dispM(m);
        Thread.sleep(1000);

        for (int i = 1; i <= len * len; i++) {
            System.out.printf("i = %d, m[%d][%d] = %d, row = %d, col = %d, %d \n", i, row, col, i, row, col, i % 3);
            m[row][col] = i;

            if (i % 3 == 0) {
                row++;
            } else {
                // 0 1 2
                row--;
                col++;
                System.out.printf(" row = %d, col = %d \n", row, col);
                if (row == -1) row = len - 1;
                if (col == len) col = 0;
            }

        }
        dispM(m);
        Thread.sleep(1000);
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


    // 정렬
    private static int[] arraySort(int[] m) {
        Arrays.sort(m);
        return m;
    }

    private static int[][] getMagicSquare_custom(int[] m) throws InterruptedException {
        int[][] rM = new int[3][3];
        int rmLen = 3;
        System.out.printf("len = %d ", rmLen);
        int row = 0, col = rmLen / 2;

        // 정렬
        arraySort(m);
        System.out.println("정렬~~ = " + Arrays.toString(m));


        for (int i = 1; i <= m.length; i++) {
            System.out.printf("i = %d, m[%d][%d] = %d, row = %d, col = %d, 나머지 = %d \n", i, row, col, m[i - 1], row, col, i % 3);
            rM[row][col] = m[i - 1];

            if (i % 3 == 0) {
                System.out.printf("계산전 row = %d, col = %d \n", row, col);
                row++;
                System.out.printf("계산후 row = %d, col = %d \n", row, col);
            } else {
                // 0 1 2
                System.out.printf("계산전 row = %d, col = %d \n", row, col);
                row--;
                col++;
                if (row == -1) row = rmLen - 1;
                if (col == rmLen) col = 0;
                System.out.printf("계산후 row = %d, col = %d \n", row, col);
            }

        }
        dispM(rM);

        return rM;
    }

    // 검증
    public static int chkCnt(int[][] m) {
        int preSum = 0;

        for (int r = 0; r < m.length; r++) {
            int rSum = Arrays.stream(m[r]).sum();
            if (r == 0) preSum = rSum;

            if (rSum != preSum) {
                return 0;
            }
            for (int c = 0; c < m[r].length; c++) {
                int cSum = Arrays.stream(m[r]).sum();

                if (rSum != cSum) {
                    return 0;
                }
            }

        }

        return 1;
    }


}