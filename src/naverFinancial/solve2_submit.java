package naverFinancial;

public class solve2_submit {

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
        //int answer = -1;

        int sum = 0;
        int step = 0;
        String log = "";
        dfs(m, k, sum, step, n);

        return cnt % 1000007;
    }

    private static void dfs(int m, int k, int sum, int step, int n) {
        if (step == n) {
            if (sum == m) {
                cnt++;
            }
            return;
        }

        for (int i = 1; i <= k; i++) {
            dfs(m, k, sum + i, step + 1, n);
        }


    }

}