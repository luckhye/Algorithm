package programmers.bfs;

import java.util.Arrays;

public class wordConvert_2 {


    public static void main(String[] args) {

        String param1 = "hit";
//        String param2 = "cog";
//        String[] param3 = {"hot", "dot", "dog", "lot", "log", "cog"};

        String param2 = "dot";
        String[] param3 = {"hot", "dot"};

        System.out.println("답 = " + solution(param1, param2, param3));
    }

    ;

    static int result = 50;
    static Boolean[] visited;

    public static int solution(String begin, String target, String[] words) {
        int answer = result;


        visited = new Boolean[50];
        Arrays.fill(visited, false);
        System.out.println("visited = " + Arrays.toString(visited));


        String txt = "step = ";
        dfs(begin, target, words, 0, txt);

        return result;
    }

    //다른 문자가 1개인지 확인하는 함수
    public static Boolean check_diff(String a, String b) {
        int dif_cnt = 0;
        Boolean result = false;

        String[] aArr = a.split("");
        String[] bArr = b.split("");
        for (int i = 0; i < a.length(); i++) {
            //System.out.printf(" aArr[i] = %s, bArr[i] = %s \n", aArr[i], bArr[i] );
            // 다른 문자가 1개일때
            if (!aArr[i].equals(bArr[i])) {
                dif_cnt++;
            }
        }

        // 다른문자가 한개일때
        //System.out.printf(" 다른문자가 한개가 아닐때  dif_cnt = %d \n", dif_cnt);
        if (dif_cnt == 1) {
            result = true;
        }
        return result;
    }


    static void dfs(String begin, String target, String[] words, int step, String txt) {
        System.out.println("");
        System.out.printf("begin = %s, target = %s, words = %s, step = %d \n", begin, target, Arrays.toString(words), step);

        txt += ">" + step;
        //System.out.printf("txt : ",txt);
        //System.out.println("txt :"+txt);


        if (begin == target) {
            System.out.println("begin == target = " + begin == target);
            result = result > step ? step : result;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            System.out.printf("한개의 문자만 다르고 방문 하지 않은 단어이면 탐색 시작 > i = %d, check_diff(begin, words[i]) = %b, visited[i] = %b, !visited[i] = %b \n", i, check_diff(begin, words[i]), visited[i], !visited[i]);
            // 한개의 문자만 다르고 방문 하지 않은 단어이면 탐색 시작
            if (check_diff(begin, words[i]) && !visited[i]) {
                //System.out.printf("한개의 문자만 다르고 방문 하지 않은 단어이면 탐색 시작 > i = %d, check_diff(begin, words[i]) = %b, visited[i] = %b \n", i, check_diff(begin, words[i]), visited[i]);
                visited[i] = true;
                // 그 단어부터 탐색을 다시 시작한다. 단계가 하나 추가되었으므로 step+1을 인자로 넘긴다.
                dfs(words[i], target, words, step + 1, txt);
                // dfs 재귀 호출하여 종료되어 여기로 돌아오면, 백트래킹 (방문 표시 해제) 하여 다음분기점부터 다시 탐색을 시작한다.
                visited[i] = false;
            }
        }

        return;
    }

}