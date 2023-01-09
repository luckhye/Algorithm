package util.Array;

import java.util.Arrays;

public class Construct {


//   1. 2차원 배열의 선언과 초기화도 1차원 배열과 비슷한 방식으로 이루어진다.
//    int[][] s = new int[3][5];
//
//
//    int[][] s1 = {
//            {1, 2, 3},
//            {4, 5, 6},
//            {7, 8, 9}
//    };


    //    2. 2차원 배열 조회 ( 왼쪽이 행, 오른쪽이 열 )
//    computers[0]=[1,1,0]
//    computers[0][0]=1
//    computers[0][1]=1
//    computers[0][2]=0
//    computers[1]=[1,1,0]
//    computers[1][0]=1
//    computers[1][1]=1
//    computers[1][2]=0
//    computers[2]=[0,0,1]
//    computers[2][0]=0
//    computers[2][1]=0
//    computers[2][2]=1
    public static void demantion2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("computers[%d] = %s \n ", i, Arrays.toString(arr[i]));
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("computers[%d][%d] = %d \n", i, j, arr[i][j]);
            }
            ;
        }
        ;
    }

    // 3. 배열값 초기값
    // Boolean[] nodeStatus = {false,false,false,false,false};
    // boolean[] nodeStatus = new boolean[n];


}
