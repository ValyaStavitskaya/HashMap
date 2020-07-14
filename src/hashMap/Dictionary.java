package hashMap;

import java.util.*;

public class Dictionary implements Map {
    private final int NUM_BUCKETS = 16;
    private Entry[] data = new Entry[NUM_BUCKETS];
    private int size;

    public Object put(Object key, Object value) {
        int hash = Entry.calculateHash(key);
        int positiveHash = Math.abs(hash);
        int index = positiveHash % NUM_BUCKETS;

        if (data[index] == null) {
            Entry last = data[index];
            data[index] = new Entry(last, key, value);
            size++;
            return null;
        } else {
            if (data[index].key.equals(key)) {
                Object prev = data[index].value;
                data[index].value = value;
                return prev;
            } else {
                Entry last = data[index];
                data[index] = new Entry(last, key, value);
                size++;
                return null;
            }
        }
    }

    @Override
    public Object get(Object key) {

        int hash = Entry.calculateHash(key);
        int positiveHash = Math.abs(hash);
        int index = positiveHash % NUM_BUCKETS;

        Entry current = data[index];
        while ((current != null)) {
            if (current.key.equals(key))
                return current.value;
            else current = current.next;
        }
        return null;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (Entry e : data) {
            if (e != null && e.key.equals(key))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry e : data) {
            if (e != null && e.value.equals(value))
                return true;
        }
        return false;
    }

    public Object remove(Object key) {
        Object result = null;
        int hash = Entry.calculateHash(key);
        int positiveHash = Math.abs(hash);
        int index = positiveHash % NUM_BUCKETS;
        Entry head = data[index];

        if (data[index] == null) {
            return null;
        }

        if(head.key.equals(key)&&head.next == null){
            data[index]=null;
            size--;
            return head.value;
        }
        if(head.key.equals(key)&&head.next != null){
            result = head.value;
            head= head.next;
            size--;
            return result;
        }
//        Entry toRemove = null;
//        while ((head != null)) {
//            if (head.key.equals(key)) {
//                toRemove = head;
//            } else head = head.next;
//            if(toRemove.equals(head)&&head.next == null){
//                data[index] = null;
//                return toRemove.value;
//            }
//            if(toRemove.equals(head)){
//                head = head.next;
//                data[index] = null;
//                return toRemove.value;
//            }



//            return null;
//        }



//        Entry current = data[index];
//        while ((current != null)) {
//            if (current.key.equals(key)) {
//                return current;
//            } else current = current.next;
//        }
        return null;
    }

    public Object removeEntry(Entry e) {


        return null;

    }

//    @Override
//    public Object remove(Object key) {
//        Entry[] result = new Entry[NUM_BUCKETS];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = data[i];
//
//        }
//        size--;
//        return null;


//        if (containsKey(key)) {
//            for (Entry e : data) {
//                if (e != null && e.key.equals(key)) {
//                    result = e.value;
//                    removeEntry(key);
//                    size--;
//                    return result;
//                }
//            }
//        }

    //}

    @Override
    public void putAll(Map m) {
        Iterator<Map.Entry> iterator = m.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = iterator.next();
            put(pair.getKey(), pair.getValue());

        }
    }


    @Override
    public void clear() {
        if (size != 0) {
            for (Entry e : data) {
                if (e != null) {
                    e = null;
                    size--;
                }
            }
        }
    }

    @Override
    public Set keySet() {
        Set result = new HashSet();
        for (Entry e : data) {
            if (e != null) {
                result.add(e.key);
            }
        }
        return result;
    }

    @Override
    public Collection values() {
        Set result = new HashSet();
        for (Entry e : data) {
            if (e != null) {
                result.add(e.value);
            }
        }
        return result;
    }

    @Override
    public Set<Map.Entry> entrySet() {
        Set result = new HashSet();
        for (Entry e : data) {

            if (e != null) {
                while (e != null) {
                    result.add(e.key + "=" + e.value);
                    e = e.next;
                }
            }
        }
        return result;
    }


    public static class Entry implements Map.Entry {
        Entry next;
        Object key;
        Object value;

        public Entry(Entry next, Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object newValue) {
            Object oldValue = value;
            value = newValue;
            return oldValue;
        }

        public static int calculateHash(Object key){
            String s = key.toString();
            return s.length();

        }
        public  String toString() { return key + "=" + value; }

    }

    public static void main(String[] args) {
        Dictionary map = new Dictionary();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.clear();
        System.out.println(map.entrySet());
        System.out.println(map.get(3));
        System.out.println(map.size());


    }
}
