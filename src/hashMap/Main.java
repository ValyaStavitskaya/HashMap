package hashMap;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Dictionary map = new Dictionary();
        map.put("Lala",1);
        map.put("N",2);
        map.put("ba",3);
        map.put("na",9);
        System.out.println(map.entrySet());
        System.out.println(map.remove("na"));
        System.out.println(map.entrySet());
        System.out.println(map.containsKey("ba"));
        System.out.println(map.containsValue("9"));
        System.out.println(map.get("ba"));

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
