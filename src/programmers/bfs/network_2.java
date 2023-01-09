package programmers.bfs;

import java.util.Arrays;

public class network_2 {

    public static void main(String[] args) {

        int param1 = 4;
        int[][] param2 = {{0, 1, 1, 0}, {1, 0, 1, 0}, {1, 1, 0, 0}, {0, 0, 0, 0}};
        System.out.println("답 = " + solution(param1, param2));
    }

    ;


    public static int solution(int n, int[][] computers) {
        int answer = 0;
        System.out.println("solution-!");

        //demantion2( omputers );
        return dfs_blog(n, computers);

    }

    public static int dfs_blog(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!chk[i]) {
                dfs(computers, chk, i);
                answer++;
            }
        }
        return answer;
    }

    static void dfs(int[][] computers, boolean[] chk, int start) {
        chk[start] = true;
        System.out.printf("start = %d, computers[start] = %s, chk = %s \n", start, Arrays.toString(computers[start]), Arrays.toString(chk));

        for (int i = 0; i < computers.length; i++) {
            if (computers[start][i] == 1 && !chk[i]) {
                dfs(computers, chk, i);
            }
        }
    }

}