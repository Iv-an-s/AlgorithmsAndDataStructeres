package lectures.lecture8HashTables;

public class DoubleHashTableImpl <K, V> extends HashTableImpl<K, V>{

    public static final int DOUBLE_HASH_CONST = 5;

    public DoubleHashTableImpl(int initialCapacity) {
        super(initialCapacity);
    }

    private int hashDoubleFunc(K key){
        return DOUBLE_HASH_CONST - (key.hashCode() % DOUBLE_HASH_CONST);
    }

    @Override
    protected int getStep(K key) {
        return hashDoubleFunc(key);
    }
}
