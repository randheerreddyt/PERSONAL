public class MapEntry<K, V> {

    K key;
    V value;
    MapEntry<K, V> next;

    public MapEntry(K key, V value, MapEntry<K,V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
