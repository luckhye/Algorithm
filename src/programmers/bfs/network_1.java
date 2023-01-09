package programmers.bfs;

import java.lang.reflect.Array;
import java.util.Arrays;

public class network_1 {

    public static void main(String[] args) {

        int param1 = 4;
        int[][] param2 = {{0, 1, 1, 0}, {1, 0, 1, 0}, {1, 1, 0, 0}, {0, 0, 0, 0}};
        System.out.println("답 = " + solution(param1, param2));
    }

    ;


    public static int solution(int n, int[][] computers) {
        int answer = 0;
        System.out.println("solution-!");
        //Boolean[] nodeStatus = {false,false,false,false,false};
        boolean[] nodeStatus = new boolean[n];
        Arrays.fill(nodeStatus, false);

        // 루트노드를 반복.
        for (int i = 0; i < n; i++) {
            // 갔던 노드는 루트노드가 될 수 없다.
            if (!nodeStatus[i]) {

                // 인접노드를 돌린다. 행 -> 렬 바꿔야하기때문에 재귀함수+인자[start]를 사용한다.
                dfs(i, computers, nodeStatus);

                // 네트워크 생성된 경우면 증가.
                ++answer;
            }
        }

        return answer;

    }

    private static void dfs(int start, int[][] computers, boolean[] nodeStatus) {
        // 경로에서 갔다온상태로 전환.
        nodeStatus[start] = true;

        // 경로를 모두 돈다.
        for (int j = 0; j < computers.length; j++) {
            // 경로중 인접경로(인접행렬)는 다시 그 길로 간다.
            // 경로중 갔던길은 다시 가지 않는다.
            if (computers[start][j] == 1 && nodeStatus[j] == false) {
                dfs(j, computers, nodeStatus);
            }
            ;

        }
    }

//   2차원 배열의 선언과 초기화도 1차원 배열과 비슷한 방식으로 이루어진다.
//    int[][] s = new int[3][5];
//
//
//    int[][] s1 = {
//            {1, 2, 3},
//            {4, 5, 6},
//            {7, 8, 9}
//    };


    // 2차원 배열 조회
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


}