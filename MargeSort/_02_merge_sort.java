package MargeSort;
/*
 * bottom-up 형식
 * 반복문으로 작성
 */

public class _02_merge_sort {

    // 정렬할 배열

    public static void merge_sort(int[] a) {

        merge_sort(a, 0, a.length - 1);
    }

    private static void merge_sort(int[] a, int left, int right) {

        // sub list 를 나누는 기준을 두배씩 늘린다
        for (int size = 1; size <= right; size = size << 1) {

            /*
             * sub list 는 size * 2 마다 반복 되므로
             * l 을 size * 2 만큼씩 이동시키며 sub list 의
             * 시작점을 결정한다.
             *
             * sub list 를 둘로 나누고 이를 병합한다.
             * sub list 의 끝(hi)은 l + (size * 2) - 1 이지만
             * 최종 배열의 인덱스인 right 를 넘어갈 수 있으므로
             * right 와 비교 해 작은 값을 hi 로 선택한다.
             */
            for (int l = 0; l <= right - size; l += size << 1) {
                int lo = l;
                int mid = 1 + size - 1;
                int hi = Math.min(l + (size << 1) - 1, right);
                merge(a, lo, mid, hi);
            }
        }
    }

    private static void merge(int[] a, int left, int mid, int right) {

        int length = right - left;
        int[]sorted = new int[length];
        int idx = 0;

        int lo = left;
        int hi = mid + 1;

        while (lo <= mid && hi <= right) {

            if (a[lo] <= a[hi])
                sorted[idx++] = a[lo++];
            else
                sorted[idx++] = a[hi++];
        }

        if (lo > mid) {
            while (hi <= right)
                sorted[idx++] = a[hi++];
        }
        else {
            while (lo <= mid)
                sorted[idx++] = a[lo++];
        }

        idx = 0;
        while (idx <= length)
            a[left++] = sorted[idx++];

    }
}
