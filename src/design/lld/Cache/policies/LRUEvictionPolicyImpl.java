package design.lld.Cache.policies;

import design.lld.Cache.algorithm.DoublyLinkedListNode;

import java.util.Map;

public class LRUEvictionPolicyImpl<KEY, VALUE> implements EvictionPolicy<KEY, VALUE>{
    private final Map<KEY, DoublyLinkedListNode> mapper;
    private final DoublyLinkedListNode list;

    public LRUEvictionPolicyImpl(Map<KEY, DoublyLinkedListNode> mapper, DoublyLinkedListNode list) {
        this.mapper = mapper;
        this.list = list;
    }

    @Override
    public void keyAccessed(KEY key) {

    }

    @Override
    public KEY evict() {
        return null;
    }
}
