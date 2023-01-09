package baekjoon.basic1.Dynamic1;

import java.util.*;

public class _11053_seq {

    public static void main(String[] args) {
        int[] n = {10, 20, 10, 30, 20, 50};
        System.out.println(solution(n));
    }

    public static int solution(int[] n) {

        // stack
        Stack st = new Stack();

        // n
        Set<Integer> set = new HashSet<>();
        for (int i : n) {
            if (st.empty() || i > (int) st.peek()) {
                st.push(i);
            }
            ;

        }
        ;

        return st.size();
    }


}