package design.lld.Cache.storage;

public interface Storage<KEY, VALUE> {
    void put(KEY key, VALUE value);

    VALUE get(KEY key);

    void remove(KEY key);
}
