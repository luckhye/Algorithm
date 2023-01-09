package programmers.bfs;

import java.util.Scanner;

public class DepthFirstSearch {
    static int node;            //정점의 개수
    static int root;            //시작 정점
    static int[][] nMatrix;     //인접 행렬 생성
    static int[] nodeVisit;     //정점의 방문 여부를 가리키는 배열
    static int nd1, nd2;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        node = scan.nextInt(); //정점의 개수 입력
        root = Integer.parseInt(scan.nextLine().trim()); //시작할 정점입력
        nMatrix = new int[node + 1][node + 1]; //+1을 시킨 이후는 정점의 시작을 0이아닌 1로시작하기 위해서이다.!
        nodeVisit = new int[node + 1]; //+1을 시킨 이후는 정점의 시작을 0이아닌 1로시작하기 위해서이다.!

        while (true) {
            nd1 = scan.nextInt();
            nd2 = scan.nextInt();

            if (nd1 < 0 && nd2 < 0) //두 개의 점이 0보다 작을 경우 break;
                break;

            nMatrix[nd1][nd2] = nMatrix[nd2][nd1] = 1;         //정점 vt1과 vt2가 연결되었음을 표기
            //인접행렬의 내용을 이해하면 위에 코드를 이해할 수 있습니다.  //예를 들어 1정점 2정점이 연결되었으면 [1][2] 와 [2][1] 배열의 자리가 1이된다.        }

            dfs(root); //dfs를 시작합니다.

        }
    }

    public static void dfs(int start) {
        nodeVisit[start] = 1;

        for (int i = 1; i <= node; i++) {
            if (nMatrix[start][i] == 1 && nodeVisit[i] == 0) {
                System.out.println(start + "->" + i + "로 이동합니다");
                dfs(i);
            }
        }
    }
}




