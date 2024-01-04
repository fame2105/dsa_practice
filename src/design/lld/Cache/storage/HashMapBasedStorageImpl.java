package design.lld.Cache.storage;

public class HashMapBasedStorageImpl<KEY, VALUE> implements Storage<KEY, VALUE> {
    private int capacity;
    private int size;

    public HashMapBasedStorageImpl(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void put(KEY key, VALUE value) {

    }

    @Override
    public VALUE get(KEY key) {
        return null;
    }

    @Override
    public void remove(KEY key) {

    }
}
