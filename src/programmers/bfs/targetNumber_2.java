package programmers.bfs;

public class targetNumber_2 {

    public static void main(String[] args) {

        int[] param1 = {1, 1, 1, 1, 1};
        int param2 = 3;


        System.out.println("답 = " + solution(param1, param2));
    }

    ;


    public static int solution(int[] numbers, int target) {
        int answer = 0;
        System.out.println("solution-!");

        dfs(numbers, 0, 0, target);

        return result;

    }

    static int result = 0;

    private static void dfs(int[] numbers, int n, int sum, int target) {
        System.out.printf("n = %d, length = %d \n", n, numbers.length);
        if (n == numbers.length) {
            if (sum == target) {
                result += 1;
            }
            return;
        }
        dfs(numbers, n + 1, sum + numbers[n], target);
        dfs(numbers, n + 1, sum - numbers[n], target);
    }

}