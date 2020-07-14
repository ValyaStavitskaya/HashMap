package hashMap;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Dictionary map = new Dictionary();
//        System.out.println(16%16);
//        System.out.println(32%16);
        map.put(16,1);
        map.put(2,2);
        map.put(32,3);
        map.put(4,4);
        map.put(48,48);
        System.out.println(map.entrySet());
        System.out.println(map.size());
        map.remove(32);
        System.out.println(map.entrySet());
        System.out.println(map.containsKey(32));
        System.out.println(map.keySet());
        System.out.println(map.values());



//        HashMap hashMap = new HashMap();
//        System.out.println(map.entrySet());
//        hashMap.put(6,4);
//        hashMap.put(9,12);
//        hashMap.put(50,4);
//        map.putAll(hashMap);
//        System.out.println(map.entrySet());
//        System.out.println(map.size());

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
