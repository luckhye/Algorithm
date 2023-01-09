package naverFinancial;

import java.util.Arrays;

public class solve2 {

    public static void main(String[] args) throws InterruptedException {
        int param1 = 3;
        int param2 = 6;
        int param3 = 3;

        solution(10, 6, 5);
        System.out.println("cnt = " + cnt);
    }

    ;

    static int cnt = 0;

    public static int solution(int n, int m, int k) {
        int answer = -1;

        int sum = 0;
        int step = 0;
        String log = "";
//        dfs(m, k, sum, step, n, log) ;
        dfs(m, k, sum, step, n);
//        System.out.println("log = "+log);


        return answer % 1000007;
    }

    //private static void dfs(int m, int k, int sum, int step, int n, String log) {
    private static void dfs(int m, int k, int sum, int step, int n) {
        //log += ", m = "+m+", k = "+k + ", sum = " + sum + ", step = " + step + ", n = " + n+"\n";
        //System.out.println(log);
        if (step == n) {
            //System.out.printf("step = %d, n = %d, sum = %d, m  = %d \n", step, n, sum, m);
            if (sum == m) {
                cnt++;
            }
            return;
        }

        //System.out.println("step = "+ step);
        for (int i = 1; i <= k; i++) {
            //log += "+" +  i ;
            //System.out.println(log);
            //dfs(m, k, sum + i, step + 1, n, log );
            dfs(m, k, sum + i, step + 1, n);
        }


    }


}