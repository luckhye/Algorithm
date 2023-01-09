package util.Stream;

import java.util.Arrays;
import java.util.List;

public class Collection {

    //https://codechacha.com/ko/java8-stream-collect/

    //https://velog.io/@sa833591/Java-Stream-4
    /**
     * reduce는 누적된 값을 계산한다.
     * <p>
     * Integer Example
     * subtotal+element 결과가 subtotal이 되고, 그 다음 element랑 계속 더해가며 누적된다.
     * 따라서 결과가 45로 누적되어 반환된다.
     * <p>
     * String Example
     * partString+element 결과가 partString이 되고, 그 다음 element랑 계속 합쳐지며 누적된다.
     * 따라서 결과가 abcdefgh로 누적되어 합쳐져 반환된다.
     */
    // Integer Example
    List<Integer> ages = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    int result = ages.stream().reduce(0, (subtotal, element) -> subtotal + element); // 45

    int result2 = ages.stream().reduce(0, Integer::sum); // 45

    // String Example
    String[][] namesArray = new String[][]{
            {"a", "b"}, {"c", "d"},
            {"e", "f"}, {"g", "h"}
    };

    String reduceStrResult = Arrays.stream(namesArray)
            .flatMap(innerArrays -> Arrays.stream(innerArrays))
            .reduce("", (partString, element) -> partString + element); // abcdefgh
}
