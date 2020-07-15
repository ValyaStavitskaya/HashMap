package home20;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 5, 3, 4, 2, 7};
        int b = 11;
        System.out.println(Arrays.toString(getIndex(arr, b)));

    }

    public static int[] getIndex(int[] array, int b) {
        if (array.length > 1) {
            int j = 1;
            for (int i = 0; i < array.length; i++) {
                for (int k = j; k < array.length; k++) {
                    if ((array[i] + array[k]) == b)
                        return new int[]{i, k};
                }
                j++;
            }
        }
        return null;
    }


}
