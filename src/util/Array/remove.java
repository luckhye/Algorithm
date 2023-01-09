package util.Array;


// ArrayList 특정 값 삭제
// https://developer-talk.tistory.com/486

import util.Class.Member;

import java.util.ArrayList;

/**
 * 함수
 * ArrayList.remove() - 인덱스
 * ArrayList.remove() - 특정 값
 * ArrayList.removeIf() - 특정 조건
 * <p>
 * 구현
 * 반복자(Iterator)
 * ArrayList의 요소가 사용자 정의 클래스
 * <p>
 * 예외
 * stringArrayList.remove(str);을 호출하면 ConcurrentModificationException 예외 발생
 */
public class remove {

    static ArrayList<String> stringArrayList;
    static ArrayList<Integer> integerArrayList;
    static ArrayList<Member> personArrayList;

    public static void main(String[] args) {


        stringArrayList = new ArrayList<>();
        stringArrayList.add("One");
        stringArrayList.add("Two");
        stringArrayList.add("Three");
        stringArrayList.add("Four");

        // solve_특정값
        remove("Two");


        integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(1);
        integerArrayList.add(2);

        // solve_특정값
        remove("1");
        // solve_인덱스
        remove(0);
        // solve_특정조건
        removeIf();

        personArrayList = new ArrayList<>();
        personArrayList.add(new Member("Tom", 10));
        personArrayList.add(new Member("Nick", 20));
        personArrayList.add(new Member("Bob", 30));
        // solve_ArrayList<Class> 특정클래스만
        classRemoveIf(personArrayList);

    }


    // 인덱스 제거
    // [One, Two, Three, Four] -> [One, Three, Four]
    private static void remove(Integer idx) {
        stringArrayList.remove(idx);
    }

    // 특정값 제거
    // [One, Two, Three, Four] -> [One, Three, Four]
    // ["1" ,"2", "3", "4" ] -> ["1" , "3", "4" ]
    private static void remove(Object rmvO) {
        stringArrayList.remove(rmvO);
    }

    // 특정 조건에 만족값
    // integerArrayList                             [1, 2, 3, 4] -> [1, 2]
    // integerArrayList.removeIf(item -> item > 2)  true
    private static void removeIf() {
        integerArrayList.removeIf(item -> item > 2);
    }


    // solve_ArrayList<Class> 특정클래스만
    // 입력 : [Person{name='Tom', age=10}, Person{name='Nick', age=20}, Person{name='Bob', age=30}
    // 결과 : [Person{name='Tom', age=10}]
    private static void classRemoveIf(ArrayList<Member> personArrayList) {
        personArrayList.removeIf((item) -> item.getAge() > 10);
    }

}
