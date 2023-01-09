package util.Path;

import java.io.File;

public class getImg {

    /**
     * 상대경로
     * <p>
     * 문법
     * / : 루트
     * ./ : 현재 위치
     * ../ : 현재 위치의 상단 폴더
     * <p>
     * 프로젝트의 상대경로
     * 왜냐하면 project 의 기본경로가 project파일이 있는 폴더 이기 때문이다.
     * 소스가 있는 곳이 절대 아니다.
     * 따라서 images폴더는 src폴더가 아닌 project root폴더에 넣어야 한다.
     * 출처: https://www.bitaholic.co.kr/entry/100030906957 [Bitaholic:티스토리]
     */
    public static void main(String[] args) {

        // 실패..
        String rootPath = "../../";               // 현재 폴더(Path) -> src 폴더 이동
        rootPath += "static/img/jinsu_1.png";     // src 폴더  -> jinsu_1.png로 이동
        File path = new File(rootPath);
        System.out.println(path.getAbsolutePath()); // /Users/jane.kwon/Desktop/work/workspace/algorithmT/../../static/img/jinsu_1.png
        System.out.println(path.isFile());          // false

        // 실패..
        File path2 = new File("./jinsu_1.png");
        System.out.println(path2.getAbsolutePath()); // /Users/jane.kwon/Desktop/work/workspace/algorithmT/./jinsu_1.png
        System.out.println(path2.isFile());          // false

        // 실패..
        File path3 = new File(rootPath);
        System.out.println(path3.getAbsolutePath()); // /Users/jane.kwon/Desktop/work/workspace/algorithmT/../../static/img/jinsu_1.png
        System.out.println(path3.isFile());          // false

        // 프로젝트의 상대경로 -> 성공
        File path4 = new File("src/static/img/jinsu_1.png");    // /Users/jane.kwon/Desktop/work/workspace/algorithmT/src/static/img/jinsu_1.png
        System.out.println(path4.getAbsolutePath());                     // true
        System.out.println(path4.isFile());

    }

    ;


}
