package MargeSort;
/*
 * top-down 형식
 * 재귀로 작성
 */
public class _01_marge_sort {

    private static int[] sorted;

    public static void marge_sort(int[] a) {

        sorted = new int[a.length];
        marge_sort(a, 0, a.length - 1);
        sorted = null;
    }

    // 재귀함수로 top-down 방식 구현
    private static void marge_sort(int[] a , int left, int right) {

        if (left == right) return;  // sub list 가 1개의 원소만 가질 경우

        int mid = (left + right) / 2;

        marge_sort(a, left, mid);           // 왼쪽 sub list
        marge_sort(a, mid + 1, right);  // 오른쪽 sub list

        marge(a, left, mid, right);         // 병합
    }

    private static void marge(int[] a, int left, int mid, int right) {

        int lo = left;
        int hi = mid + 1;
        int idx = left;

        // sub list 중 하나가 끝까지 비교 되었을 경우 종료
        while (lo <= mid && hi <= right) {

            if (a[lo] <= a[hi])
                sorted[idx++] = a[lo++];
            else
                sorted[idx++] = a[hi++];
        }

        if (lo > mid) { // 남은 sub list 가 오른쪽 sub list 인 경우 나머지 요소 추가
            while (hi <= right)
                sorted[idx++] = a[hi++];
        }
        else {          // 남은 sub list 가 왼쪽 sub list 인 경우 나머지 요소 추가
            while (lo <= mid)
                sorted[idx++] = a[lo++];
        }

        while (left <= right) { // 합쳐진 배열 리턴
            a[left] = sorted[left++];
        }
    }
}
