package algoritms;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {6, 7, 2, 5, 8, 1};
        System.out.println(Arrays.toString(nums));
        int size = nums.length;
        sort(nums, size);
        System.out.println(Arrays.toString(nums));
    }

    static int[] sort(int[] array, int size) {
        if (size == 1) return array;

        for (int i = size/2 - 1; i >= 0; i--) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            if (left < size && array[left] > array[i])
                swap(array, left, i);

            if (right < size && array[right] > array[i])
                swap(array, i, right);
        }
        swap(array, 0, --size);
        return sort(array, size);
    }

    static void swap(int[] array, int min, int max) {
        int temp = array[min];
        array[min] = array[max];
        array[max] = temp;
    }
}
