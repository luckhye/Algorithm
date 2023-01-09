package uahan;

import java.sql.SQLOutput;
import java.util.*;

public class Test04 {


    public static void main(String[] args) {

        // write your code in Java SE 8
        Scanner sc = new Scanner(System.in);
        System.out.println("몇개의 숫자로 정렬하시겠습니까?\n");
        String test = sc.nextLine();

        System.out.println("입력값 :" + test);
        int n, i;
        int[] arr = new int[10000];
        n = Integer.valueOf(test);

        for (i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }


        System.out.printf("정렬전 배열 :");

        for (i = 0; i < n; i++)
            System.out.printf("%d ", arr[i]);
        System.out.printf("\n");

        Solution s = new Solution();
        s.Solution(arr, n);

        System.out.println("s = " + s);


        System.out.printf("정렬후 배열 :");
        for (i = 0; i < n; i++)
            System.out.printf("%d ", arr[i]);
        System.out.printf("\n");


    }


    static class Solution {
        public int Solution(int[] A, int n) {
            QuickSort(A, 0, n - 1);
            return 1;
        }


        void Swap(int arr[], int a, int b) // a,b 스왑 함수
        {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }


        int Partition(int arr[], int left, int right) {
            int pivot = arr[left]; // 피벗의 위치는 가장 왼쪽에서 시작
            int low = left + 1;
            int high = right;

            while (low <= high) // 교차되기 전까지 반복한다
            {
                while (low <= right && pivot >= arr[low]) // 피벗보다 큰 값을 찾는 과정
                {
                    low++; // low를 오른쪽으로 이동
                }
                while (high >= (left + 1) && pivot <= arr[high]) // 피벗보다 작은 값을 찾는 과정
                {
                    high--; // high를 왼쪽으로 이동
                }
                if (low <= high)// 교차되지 않은 상태이면 스왑 과정 실행
                {
                    Swap(arr, low, high); //low와 high를 스왑
                }
            }
            Swap(arr, left, high); // 피벗과 high가 가리키는 대상을 교환
            return high;  // 옮겨진 피벗의 위치정보를 반환

        }


        void QuickSort(int arr[], int left, int right) {
            if (left <= right) {
                int pivot = Partition(arr, left, right); // 둘로 나누어서
                QuickSort(arr, left, pivot - 1); // 왼쪽 영역을 정렬한다.
                QuickSort(arr, pivot + 1, right); // 오른쪽 영역을 정렬한다.
            }
        }
    }


}



