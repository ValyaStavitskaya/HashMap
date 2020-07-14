package hashMap;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {


        Dictionary map = new Dictionary();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.clear();
        System.out.println(map.entrySet());
        System.out.println(map.get(3));
        System.out.println(map.size());
        System.out.println(map.remove(3));
        System.out.println(map.get(3));
        System.out.println(map.size());
        HashMap hashMap = new HashMap();
        System.out.println(map.entrySet());
        hashMap.put(6,4);
        hashMap.put(9,12);
        hashMap.put(50,4);
        map.putAll(hashMap);
        System.out.println(map.entrySet());
        System.out.println(map.size());

//        Set bb = map.entrySet();
//        System.out.println(bb);
//        map.remove("Lala");
//        System.out.println(bb);
//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        HashMap hashMap = new HashMap();
//        hashMap.put(6,4);
//        hashMap.put(9,12);
//        hashMap.put(50,4);
//        Set dd = hashMap.entrySet();
//        System.out.println(dd);










    }
}
