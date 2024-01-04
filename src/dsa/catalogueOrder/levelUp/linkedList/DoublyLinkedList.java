package dsa.catalogueOrder.levelUp.linkedList;

public class DoublyLinkedList {
    private static class DoublyLinkedListInternal {
        private class Node {
            int data = 0;
            Node prev = null;
            Node next = null;

            Node(int data) {
                this.data = data;
            }
        }

        private Node head = null;
        private Node tail = null;
        private int size = 0;

        public int size() {
            return this.size();
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public void addFirst(int val) {
            Node node = new Node(val);
            addFirstNode(node);
        }

        private void addFirstNode(Node node) {
            if (this.size == 0) {
                this.head = this.tail = node;
            } else {
                node.next = this.head;
                this.head.prev = node;
                this.head = node;
            }
            this.size++;
        }

        public void addLast(int val) {
            Node node = new Node(val);
            addLastNode(node);
        }

        private void addLastNode(Node node) {
            if (this.size == 0) {
                this.head = this.tail = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
                this.tail = this.tail.next;
            }
            this.size++;
        }

        public int removeFirst() {
            if (this.size == 0) {
                System.out.print("ListIsEmpty: ");
                return -1;
            } else {
                Node node = removeFirstNode();
                return node.data;
            }
        }

        private Node removeFirstNode() {
            Node node = this.head;
            if (this.size == 1) {
                this.head = this.tail = null;
            } else {
                Node forw = this.head.next;
                this.head.next = null;
                forw.prev = null;
                this.head = forw;
            }

            this.size--;
            return node;
        }

        public int removeLast() {
            if (size == 0) {
                System.out.print("ListIsEmpty: ");
                return -1;
            } else {
                Node node = removeLastNode();
                return node.data;
            }
        }

        private Node removeLastNode() {
            Node node = this.tail;
            if (this.size == 1) {
                this.head = this.tail = null;
            } else {
                Node prev = this.tail.prev;
                prev.next = null;
                this.tail = prev;
            }

            this.size--;
            return node;
        }

        public int getFirst() {
            if (size == 0) {
                System.out.print("ListIsEmpty: ");
                return -1;
            }
            return this.head.data;
        }

        public int getLast() {
            if (size == 0) {
                System.out.print("ListIsEmpty: ");
                return -1;
            }

            return this.tail.data;
        }

        public int getAt(int index) {
            if (index < 0 || index >= size) {
                System.out.print("IndexIsInValid: ");
                return -1;
            } else if (size == 0) {
                System.out.print("ListIsEmpty: ");
                return -1;
            }

            Node node = getNodeAt(index);
            return node.data;
        }

        private Node getNodeAt(int index) {
            Node temp = head;
            int ctr = 0;
            while (ctr < index) {
                ctr++;
                temp = temp.next;
            }
            return temp;
        }

        public void addAt(int index, int data) {
            if (index < 0 || index > this.size)
                System.out.println("IndexIsInValid: -1");
            else {
                Node node = new Node(data);
                addNodeAt(index, node);
            }
        }

        private void addNodeAt(int index, Node node) {
            if (index == 0) addFirstNode(node);
            else if (index == this.size) addLastNode(node);
            else {
                Node forward = getNodeAt(index);
                Node prev = forward.prev;

                node.next = forward;
                node.prev = prev;

                forward.prev = node;
                prev.next = node;
                this.size++;
            }
        }

        public int removeAt(int index) {
            if (this.size == 0) {
                System.out.print("ListIsEmpty: ");
                return -1;
            } else if (index < 0 || index >= this.size) {
                System.out.print("IndexIsInValid: ");
                return -1;
            } else {
                Node removedNode = removeNodeAt(index);
                return removedNode.data;
            }
        }

        private Node removeNodeAt(int index) {
            if (index == 0) {
                return removeFirstNode();
            } else if (index == this.size - 1) {
                return removeLastNode();
            } else {
                Node nodeToBeRemoved = getNodeAt(index);
                nodeToBeRemoved.prev.next = nodeToBeRemoved.next;
                nodeToBeRemoved.next.prev = nodeToBeRemoved.prev;
                this.size--;
                return nodeToBeRemoved;
            }
        }

        public void addBefore(Node refNode, int data) {
            Node node = new Node(data);
            addBefore(refNode, node);
        }

        private void addBefore(Node refNode, Node node) {
            Node prevNode = refNode.prev;

            node.next = refNode;
            refNode.prev = node;

            if (prevNode == null) { // adding at the start
                this.head = node;
            } else {
                prevNode.next = node;
                node.prev = prevNode;
            }
            this.size++;
        }

        public void addAfter(Node refNode, int data) {
            Node node = new Node(data);
            addAfterNode(refNode, node);
        }

        private void addAfterNode(Node refNode, Node node) {
            Node forw = refNode.next;

            refNode.next = node;
            node.prev = refNode;

            if (forw == null) { // adding at tail
                this.tail = node;
            } else {
                node.next = forw;
                forw.prev = node;
            }
            this.size++;
        }

        public int removeAfter(Node refNode) {
            if (refNode.next == null) {
                System.out.println("LocationIsInvalid: ");
                return -1;
            }
            return removeAfterNode(refNode).data;
        }

        private Node removeAfterNode(Node refNode) {
            Node forw = refNode.next;
            if (forw.next == null) { // we are deleting the tail
                forw.prev = null;
                refNode.next = null;
                this.tail = refNode;
            } else {
                refNode.next = forw.next;
                forw.next.prev = forw.prev;

                forw.next = forw.prev = null;
            }
            this.size--;
            return forw;
        }

        public int removeBefore(Node refNode) {
            if (refNode.prev == null) {
                System.out.print("LocationIsInvalid: ");
                return -1;
            }
            return removeBeforeNode(refNode).data;
        }

        private Node removeBeforeNode(Node refNode) {
            Node prevNode = refNode.prev;
            if (prevNode.prev == null) {
                refNode.prev = prevNode.next = null;
                this.head = refNode;
            } else {
                refNode.prev = prevNode.prev;
                prevNode.prev.next = refNode;

                prevNode.next = prevNode.prev = null;
            }
            this.size--;
            return prevNode;
        }

        public void displayForw() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");

            Node curr = this.head;
            while (curr != null) {
                sb.append(curr.data);

                if (curr.next != null) sb.append(", ");

                curr = curr.next;
            }

            sb.append("]");
            System.out.println(sb.toString());
        }

        public void displayBack() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");

            Node curr = this.tail;
            while (curr != null) {
                sb.append(curr.data);

                if (curr.prev != null) sb.append(", ");

                curr = curr.prev;
            }

            sb.append("]");
            System.out.println(sb.toString());
        }

        // remove given node
        public int removeNode(Node refNode) {
            if (refNode.next == null && refNode.prev == null) {
                this.head = this.tail = null;
            } else if (refNode.prev == null) {
                Node forwNode = refNode.next;
                refNode.next = null;
                this.head = forwNode;
            } else if (refNode.next == null) {
                Node prevNode = refNode.prev;
                refNode = null;
                this.tail = prevNode;
            } else {
                Node prevNode = refNode.prev;
                Node forwNode = refNode.next;

                prevNode.next = forwNode;
                forwNode.prev = prevNode;

                refNode.prev = refNode.next = null;
            }

            this.size--;
            return refNode.data;
        }

    }

    public static void main(String[] args) {
        DoublyLinkedListInternal dll = new DoublyLinkedListInternal();
    }

}
