package dsa.catalogueOrder.foundation.HashMapAndHeap;

import java.util.ArrayList;
import java.util.LinkedList;

public class GenericHashMap {
    public static class HashMap<K, V> {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<HMNode>[] buckets; // N = buckets.length

        public HashMap() {
            initbuckets(4); // initial capacity is 4
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            return Math.abs(key.hashCode()) % buckets.length;
        }

        private int getIndexWithinBucket(K key, int bucketIndex) {
            int dataIndex = 0;
            for (HMNode node : buckets[bucketIndex]) {
                if (node.key.equals(key)) {
                    return dataIndex;
                } else {
                    dataIndex++;
                }
            }
            return -1;
        }

        public void put(K key, V value) throws Exception {
            int bucketIndex = hashFunction(key);
            int dataIndex = getIndexWithinBucket(key, bucketIndex);

            if (dataIndex == -1) { // insert new node in this bucket
                buckets[bucketIndex].add(new HMNode(key, value));
                this.size++;
            } else { // update existing node
                HMNode existingNode = buckets[bucketIndex].get(dataIndex);
                existingNode.value = value;
            }

            double lambda = (this.size * 1.0) / buckets.length;
            if (lambda > 2.0) {
                rehash();
            }
        }

        private void rehash() throws Exception {
            LinkedList<HMNode>[] oldBucketArray = buckets;
            this.size = 0;

            initbuckets(oldBucketArray.length * 2);
            for (int i = 0; i < oldBucketArray.length; i++) {
                for (HMNode node : oldBucketArray[i]) {
                    put(node.key, node.value);
                }
            }
        }

        public V get(K key) throws Exception {
            int bucketIndex = hashFunction(key);
            int dataIndex = getIndexWithinBucket(key, bucketIndex);

            if (dataIndex == -1) {
                return null;
            } else {
                HMNode node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            }
        }

        public boolean containsKey(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = getIndexWithinBucket(key, bucketIndex);
            if (dataIndex == -1) {
                return false;
            } else {
                return true;
            }
        }

        public V remove(K key) throws Exception {
            int bucketIndex = hashFunction(key);
            int dataIndex = getIndexWithinBucket(key, bucketIndex);
            if (dataIndex == -1) {
                return null;
            } else {
                HMNode node = buckets[bucketIndex].remove(dataIndex);
                this.size--;
                return node.value;
            }
        }

        public ArrayList<K> keyset() throws Exception {
            ArrayList<K> keyList = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                for (HMNode node : buckets[i]) {
                    keyList.add(node.key);
                }
            }
            return keyList;
        }

        public int size() {
            return this.size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node : buckets[bi]) {
                    System.out.print(node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }
}
