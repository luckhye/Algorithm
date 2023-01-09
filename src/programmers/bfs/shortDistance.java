package programmers.bfs;

import java.util.Arrays;

public class shortDistance {

    public static void main(String[] args) {

        int[][] param1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println("답 = " + solution(param1));
    }

    ;


    /**
     * network_1 문제는
     * 네트워크 생성 갯수 조회,( 즉, 순환경로를 구분해야하는게 포인트 )
     * dfs가 순환경로 1
     * <p>
     * 최단거리 문제는
     * 특정지점의 경로 조회 (즉, 경로 이면서, 최단 경로를 구분하는게 포인트 )개
     * dfs가 순환경로 1
     * <p>
     * 패턴
     * 다 돔  -> 행렬
     * 인접만 감 -> 인접행렬
     * 경로갔음 -> 행구분배열 boolean[]
     * <p>
     * 절차
     * 인접은 1로 구분
     * 갔던길은 가지않도록 행구분배열 사용
     * 카운팅은 최단경로 접점(node) 수. -> 보관 배열 필요.
     **/


    public static int solution(int[][] maps) {
        int answer = -1;
        // 카운팅은 최단경로 접점(node) 수. -> 보관 배열 필요.
        int[] injupNodeCount = new int[maps.length];
        Arrays.fill(injupNodeCount, 0);

        // 경로갔음 행구분배열 boolean[]
        boolean[] chk = new boolean[maps.length];
        Arrays.fill(chk, false);

        // 행렬
        dfs(maps, 0, chk, injupNodeCount);

        // 최소값.
        Arrays.sort(injupNodeCount);
        answer = injupNodeCount[0];

        return answer;
    }

    private static void dfs(int[][] maps, int start, boolean[] chk, int[] injupNodeCount) {
        chk[start] = true;

        // 인접행렬
        for (int j = 0; j < maps.length; j++) {
            if (maps[start][j] == 1) {
                dfs(maps, j, chk, injupNodeCount);
            }
        }


    }


}