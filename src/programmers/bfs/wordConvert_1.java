package programmers.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class wordConvert_1 {


    public static void main(String[] args) {

        String param1 = "hit";
        String param2 = "cog";
        String[] param3 = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println("답 = " + solution(param1, param2, param3));
    }

    ;


    public static int solution(String begin, String target, String[] words) {
        int answer = 0;


        // hit -> hiX , hXt , Xit       ["hot", "dot", "dog", "lot", "log", "cog"]
        // hXt -> hot               - hot
        // hot -> hoX, hXt, Xot         [ "dot", "dog", "lot", "log", "cog"]
        // Xot -> dot


        // 일치 비교    h,i,t -> h,o,t      동일 문자열 제거하고 차이가 1인것  -> list 의 차집합. (인접 문자열)

        String[] test = begin.split("");
        System.out.println("test = " + Arrays.toString(test));

//      ArrayList -> [[h, o, t], [d, o, t], [d, o, g], [l, o, t], [l, o, g], [c, o, g]]
        List<List<String>> compareWord = Arrays.stream(words).map(i ->
                Arrays.asList(i.split(""))
        ).collect(Collectors.toList());


        dfs(target, words, compareWord, begin);


        return answer;
    }

    private static void dfs(String target, String[] words, List<List<String>> compareWord, String srhWord) {

        List<String> srhListWord = Arrays.asList(srhWord.split(""));

        for (int i = 0; i < compareWord.size(); i++) {
            List<String> temp = srhListWord;

            System.out.println("srhListWord = " + srhListWord);
            System.out.println("compareWord.get(i) = " + compareWord.get(i));
            srhListWord.removeAll(compareWord.get(i));
            System.out.println("srhListWord = " + srhListWord);

//            System.out.println("temp.removeAll( compareWord.get(i) ) = "+ temp.removeAll(compareWord.get(i)) );
//            if( temp.removeAll( compareWord.get(i) ) ){
//
//            }
        }

        // dfs(begin, target, words);
    }


}