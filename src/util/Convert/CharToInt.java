package util.Convert;

public class CharToInt {

    public static void main(String[] args) {

        // char -> int 로 변환
        String num = "872472";
        System.out.println(num.charAt(0));  // 문자 8
        System.out.println(Character.getNumericValue(num.charAt(0)));  // char -> int 변환
        System.out.println(num.charAt(0) - '0');                       // char -> int 변환 ( 아스키코드 '0' 수만큼 제거 하여 수를 맞추었음 )

    }

}
