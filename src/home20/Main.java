package home20;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 9, 5, 3, 4, 2, 7);
        int b = 5;
        System.out.println(getIndex(list, b));

    }

    public static List getIndex(List<Integer> list, int b) {
        ArrayList<Integer> array = new ArrayList<>(list);
        Collections.sort(array);
        int first = 0;
        int last = array.size() - 1;
        int a;
        int c;
        while (first < last) {
            int s = array.get(first) + array.get(last);
            if (s == b){
                 a = array.get(first);
                 c = array.get(last);
                return Arrays.asList(list.indexOf(a), list.indexOf(c));}
            else {
                if (s < b) first++;
                else last--;
            }
        }
        return null;

    }
}





