package hashMap;

import java.util.*;

public class Dictionary implements Map {
    private final int NUM_BUCKETS = 16;
    private Entry[] data = new Entry[NUM_BUCKETS];
    private int size;

    public Object put(Object key, Object value) {
        int hash = key.hashCode();
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

        int hash = key.hashCode();
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
            if (e != null) {
                while (e != null) {
                    if (e.key.equals(key))
                        return true;
                    e = e.next;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry e : data) {
            if (e != null) {
                while (e != null) {
                    if (e.value.equals(value))
                        return true;
                    e = e.next;
                }
            }
        }
        return false;
    }

    public Object remove(Object key) {
        Object result;
        int hash = key.hashCode();
        int positiveHash = Math.abs(hash);
        int index = positiveHash % NUM_BUCKETS;
        Entry head = data[index];

        if (data[index] == null) {
            return null;
        }

        if (head.key.equals(key) && head.next == null) {
            data[index] = null;
            size--;
            return head.value;
        }
        if (head.key.equals(key) && head.next != null) {
            result = head.value;
            data[index] = data[index].next;
            size--;
            return result;
        }


        while ((head.next != null)) {
            if (head.next.key.equals(key)) {
                if (head.next.next == null) {
                    result = head.next.value;

                    head.next = null;
                    size--;

                    return result;
                } else {
                    result = head.next.value;
                    head.next = head.next.next;
                    size--;

                    return result;
                }
            } else head = head.next;
        }

        return null;
    }


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
                    while (e != null) {
                        remove(e.getKey());
                        e = e.next;
                    }
                }
            }
        }
    }

    @Override
    public Set keySet() {
        Set result = new HashSet();
        for (Entry e : data) {
            if (e != null) {
                while (e != null) {
                    result.add(e.key);
                    e = e.next;
                }
            }
        }
        return result;
    }

    @Override
    public Collection values() {
        Set result = new HashSet();
        for (Entry e : data) {
            if (e != null) {
                while (e != null) {
                    result.add(e.value);
                    e = e.next;
                }
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

        public String toString() {
            return key + "=" + value;
        }

    }

}
