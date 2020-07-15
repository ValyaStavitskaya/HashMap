package home20;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = Arrays.asList(1, 9, 5, 3, 4, 2, 7);
        int b = 11;
        System.out.println(Arrays.toString(getIndex(list, b)));

    }

    public static int[] getIndex(List<Integer> list, int b) {
        if (list.size() > 1) {
            int j = 1;
            for (int i = 0; i < list.size(); i++) {
                for (int k = j; k < list.size(); k++) {
                    if ((list.get(i) + list.get(k)) == b)
                        return new int[]{i, k};
                }
                j++;
            }
        }
        return null;
    }


}
