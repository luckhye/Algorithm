package groundx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Test02 {
    public static void main(String[] args) {

        Solution s = new Solution();
        int serverCnt = 4;
        java.lang.String[] record = {"1 안녕", "1 빠이", "1 후후", "1 안녕", "2 안녕"};
        System.out.println("답 = " + Arrays.toString(s.solution(serverCnt, record)));
    }

    ;


    static class Solution {
        static int staticN = 5;

        public String[] solution(int n, String[] record) {
            String[] answer = {};
            staticN = n;
            // 서버별 분류
            ArrayList temp = Arrays.stream(record).map(s -> {
                String[] d = s.split(" ");
                int sNbr = Integer.parseInt(d[0]);
                String cNm = d[1];
                System.out.println("d  = " + Arrays.toString(d));


                ArrayList temp2 = new ArrayList();

                ArrayList<ArrayList> sList = new ArrayList<ArrayList>(staticN);
                System.out.println("sList.get(sNbr).size()   = " + sList.get(sNbr).size());
                System.out.println("sList.get(sNbr).contains(cNm)  = " + sList.get(sNbr).contains(cNm));
                if (sList.get(sNbr).size() < 5 && !(sList.get(sNbr).contains(cNm))) {
                    sList.get(sNbr).add(cNm);
                } else if (sList.get(sNbr).size() > 5 && !(sList.get(sNbr).contains(cNm))) {
                    sList.get(0).add(cNm);
                }

                return sList;
            }).collect(Collectors.toCollection(ArrayList::new));

            System.out.println("temp = " + temp);

            return answer;
        }

    }

}
