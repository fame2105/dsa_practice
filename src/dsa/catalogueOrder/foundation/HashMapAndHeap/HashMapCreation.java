package dsa.catalogueOrder.foundation.HashMapAndHeap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCreation {
    static class MyHashMap {
         class Node {
             String key;
             int val;
            public Node(String key, int val) {
                this.key = key;
                this.val = val;
            }
             @Override
             public String toString() {
                 return "Node{" +
                         "key='" + key + '\'' +
                         ", val=" + val +
                         '}';
             }
         }
         public int size = 0;
        private LinkedList<Node>[] buckets;
        public MyHashMap() {
            init(4);
        }
        private void init(int capacity) {
            buckets = new LinkedList[capacity]; // default value is null at every array index
            for (int i = 0; i < capacity; i++) {
                buckets[i] = new LinkedList<>();
            }
            this.size = 0;
        }
        public void put(String key, int value) {
            int bucketIndex = hash(key);

            // check if it is already present or not
            int dataIndex = searchInBucket(key, bucketIndex);

            if(dataIndex == -1) { // not present -> insert
                buckets[bucketIndex].addLast(new Node(key, value));
                this.size++;
            } else { // key already present in map -> override with new value
                buckets[bucketIndex].get(dataIndex).val = value;
            }
        }

        private int searchInBucket(String key, int bucketIndex) {
            int dataIndex = -1;
            for(Node node : buckets[bucketIndex]) {
                dataIndex++;
                if(node.key.equals(key) == true) {
                    return dataIndex;
                }
            }
            return dataIndex;
        }

        private int hash(String key) {
            int bi = Math.abs(key.hashCode()) % buckets.length;
            return bi;
        }

        public int remove(String key) {
            int bucketIndex = hash(key);

            int dataIndex = searchInBucket(key, bucketIndex);
            if(dataIndex == -1) {
                return -1;
            } else {
                Node rem = buckets[bucketIndex].remove(dataIndex);
                this.size--;
                return rem.val;
            }
        }

        public int get(String key) {
            int bucketIndex = hash(key);

            int dataIndex = searchInBucket(key, bucketIndex);
            if(dataIndex == -1) {
                return -1;
            }
            else {
                Node rem = buckets[bucketIndex].get(dataIndex);
                return rem.val;
            }
        }
        public boolean containsKey(String key) {
            int bucketIndex = hash(key);

            int dataIndex = searchInBucket(key, bucketIndex);
            if(dataIndex == -1) {
                return false;
            } else {
                return true;
            }
        }
        public ArrayList<String> keySet() {
            ArrayList<String> list = new ArrayList<>();

            for(int bi = 0; bi < buckets.length; bi++) {
                for(Node node : buckets[bi]) {
                    list.add(node.key);
                }
            }
            return list;
        }

        public int size() {
            return this.size;
        }
        public void display() {
            for(int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket no: " + bi + " Size of this bucket is : " + buckets[bi].size() + " ");
                for(Node node : buckets[bi]) {
                    System.out.println(node.toString() + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        map.put("India", 1);
        map.put("Pakistan", 2);
        map.put("USA", 3);
        map.put("Australia", 4);
        map.put("Nepal", 5);
        map.put("Japan", 6);

        map.display();
        System.out.println(map.size);
    }


}
