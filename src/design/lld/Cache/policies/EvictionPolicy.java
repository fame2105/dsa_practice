package design.lld.Cache.policies;

public interface EvictionPolicy<KEY, VALUE> {
    public void keyAccessed(KEY key);

    public KEY evict();
}
