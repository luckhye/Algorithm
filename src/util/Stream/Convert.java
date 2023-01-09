package util.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convert {

    //convert
    // ver8         https://ilovejinwon.tistory.com/54
    // streamVer    https://codechacha.com/ko/java8-convert-stream-to-array/
    // 람다ver       https://ryan-han.com/post/java/java-lambda/
    public static void main(String[] args) {

        // list data
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        // Stream을 배열(Array)로 변환하는 방법.
        ConvertStreamToArray(list, String[].class);
    }

    public static <T> T ConvertStreamToArray(List list, T type) {
        return (T) list.stream()
                .toArray(String[]::new);

    }
}
