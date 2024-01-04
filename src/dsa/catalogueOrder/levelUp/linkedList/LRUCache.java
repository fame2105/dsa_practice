package dsa.catalogueOrder.levelUp.linkedList;

import java.util.HashMap;

public class LRUCache {
    private class DllNode {
        int key;
        int value;
        DllNode next;
        DllNode prev;

        DllNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, DllNode> map;
    private DllNode head;
    private DllNode tail;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.size = 0;
        this.head = null;
        this.tail = null;
    }


    public int get(int key) {
        if(map.containsKey(key)){
            DllNode node = map.get(key);
            // 1. remove this node reference from the list
            removeNode(node);

            // 2. insert this node reference to the end of the list
            addLastNode(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) { // update this node  value in the list and move to front
            DllNode node = map.get(key);

            // remove this node from front
            removeNode(node);

            // modify node value
            node.value = value;

            // add this node to the last
            addLastNode(node);
        } else {
            if(this.size < capacity) {
                DllNode node = addLast(key, value);
                map.put(key, node);
            } else { // Remove Least recently used node and add new node to the last of the list
                // remove this node from map
                map.remove(this.head.key);

                // remove first node -> head node
                removeNode(this.head);

                // Insert new data to the last of the list
                DllNode node = addLast(key, value);

                // update map entries
                map.put(key, node);
            }
        }
    }

    private DllNode addLast(int key, int value) {
        DllNode node = new DllNode(key, value);
        return addLastNode(node);
    }

    private DllNode addLastNode(DllNode node) {
        if (this.size == 0) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = tail;

            this.tail = node;
        }
        this.size++;
        return node;
    }

    private int removeNode(DllNode node) {
        if (node.prev == null && node.next == null) {
            this.head = this.tail = null;
        } else if (node.prev == null) { // we need to remove head node
            this.head = node.next;
            head.prev = null;
            node.next = null;
        } else if (node.next == null) {
            DllNode prevNode = node.prev;
            prevNode.next = null;
            node.prev = null;
            this.tail = prevNode;
        } else {
            DllNode prevNode = node.prev;
            DllNode forw = node.next;
            prevNode.next = forw;
            forw.prev = prevNode;

            node.next = node.prev = null;
        }

        this.size--;
        return node.value;
    }
}
