package dsa.catalogueOrder.levelUp.trees.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class IterableGenericTree {

    public static void main(String[] args) {

        Integer[] data = new Integer[]{10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null, null, 40, 100, null, null, null};

        GenericTree genericTree = new GenericTree(data);
//        genericTree.

        for (Integer i : genericTree) {
            System.out.println(i);
        }
    }

    private static class GenericTree implements Iterable<Integer> {

        private class Node {
            public int data;
            public ArrayList<Node> children;

            public Node(int data) {
                this.data = data;
                this.children = new ArrayList<>();
            }
        }

        Node root = null;

        private GenericTree(Integer[] data) {
            construct(data);
        }

        private void construct(Integer[] data) {
            if (data.length == 0) return;
            Stack<Node> st = new Stack<>();
            st.push(new Node(data[0]));
            for (int i = 0; i < data.length; i++) {
                if (data[i] != null) {
                    Node newNode = new Node(data[1]);

                    if (st.isEmpty()) {
                        root = newNode;
                    } else {
                        st.peek().children.add(newNode);
                    }
                    st.add(newNode);
                } else st.pop();
            }
        }

        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        private class GenericTreeIterator implements Iterator<Integer> {

            private Integer nVal = null;

            public GenericTreeIterator() {
                this.nVal = next();
            }

            @Override
            public boolean hasNext() {
                if (nVal == null) {
                    return false;
                } else {
                    return true;
                }
            }

            private class Pair {
                Node node;
                int state;

                public Pair(Node node, int state) {
                    this.node = node;
                    this.state = state;
                }
            }

            @Override
            public Integer next() {
                return null;
            }


        }
    }
}
