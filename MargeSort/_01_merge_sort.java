package MargeSort;
/*
 * top-down 형식
 * 재귀로 작성
 */
public class _01_merge_sort {


    public static void merge_sort(int[] a) {

        merge_sort(a, 0, a.length - 1);
    }

    // 재귀함수로 top-down 방식 구현
    private static void merge_sort(int[] a , int left, int right) {

        if (left == right) return;  // sub list 가 1개의 원소만 가질 경우

        int mid = (left + right) / 2;

        merge_sort(a, left, mid);           // 왼쪽 sub list
        merge_sort(a, mid + 1, right);  // 오른쪽 sub list

        merge(a, left, mid, right);         // 병합
    }

    private static void merge(int[] a, int left, int mid, int right) {

        int length = right - left;
        int[]sorted = new int[length + 1];
        int idx = 0;

        int lo = left;
        int hi = mid + 1;

        while (lo <= mid && hi <= right) {

            if (a[lo] <= a[hi])
                sorted[idx++] = a[lo++];
            else
                sorted[idx++] = a[hi++];
        }

        while (hi <= right)
            sorted[idx++] = a[hi++];

        while (lo <= mid)
            sorted[idx++] = a[lo++];

        idx = 0;
        while (idx <= length)
            a[left++] = sorted[idx++];

    }
}
