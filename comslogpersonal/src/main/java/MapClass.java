public class MapClass<K, V> {

    private MapEntry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 10;
    static int size = 0;

    MapClass() {
        buckets = new MapEntry[INITIAL_CAPACITY];
    }

    public int getHashCode(K key) {
        return Math.abs(key.hashCode() % INITIAL_CAPACITY);
    }

    public void putMap(K key, V value) {
        MapEntry entry = new MapEntry<>(key, value, null);
        int hashCode = getHashCode(key);
        if (buckets[hashCode] == null) {
            buckets[hashCode] = entry;
            size++;
        } else {
            MapEntry<K, V> current = buckets[hashCode];
            if (key.equals(current.key)) {
                buckets[hashCode] = entry;
                return;
            }
            while (current.next != null) {
                if (key.equals(current.key)) {
                    buckets[hashCode] = entry;
                    return;
                }
                current = current.next;
            }
            current.next = entry;
            size++;
        }
    }

    public void removeMap(K key) {
        int hashCode = getHashCode(key);
        if (buckets[hashCode] == null) {
            System.out.println("Key not found");
        } else {
            MapEntry<K, V> current = buckets[hashCode];
            while (current.next != null) {
                if ((current.next.key).equals(key)) {
                    current.next = current.next.next;
                    size--;
                    return;
                }
                current = current.next;
            }
        }
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        int hashCode = getHashCode(key);
        if (buckets[hashCode] == null) {
            return null;
        } else {
            MapEntry<K, V> temp = buckets[hashCode];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return null;
    }


    public boolean containsKey(K key) {
        boolean found = false;
        int hashCode = getHashCode(key);
        if (buckets[hashCode] != null) {
            MapEntry<K, V> temp = buckets[hashCode];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    found = true;
                }
                temp = temp.next;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        MapClass mapimp = new MapClass();
        mapimp.putMap(10, "Rana");
        System.out.println(mapimp.get(10));
        mapimp.putMap(10, "dolly");
        System.out.println(mapimp.get(10));
        mapimp.putMap(11, "laddoo");
        System.out.println(mapimp.get(11));
        mapimp.putMap(11, "manu");
        System.out.println(mapimp.get(11));
        mapimp.putMap(33, "sahu");
        System.out.println(mapimp.get(33));
        mapimp.putMap(65, "rohit");
        System.out.println(mapimp.get(65));
        mapimp.putMap(75, "raj");
        System.out.println(mapimp.get(75));
        mapimp.putMap(85, "suni");
        System.out.println(mapimp.get(85));
        mapimp.removeMap(75);
        System.out.println(mapimp.get(75));
        mapimp.putMap(95, "moni");
        System.out.println(mapimp.get(95));
        System.out.println("Size " + mapimp.size);
        System.out.println("Found 65 :" + mapimp.containsKey(65));
    }
}
