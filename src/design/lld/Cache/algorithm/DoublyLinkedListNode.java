package design.lld.Cache.algorithm;

public class DoublyLinkedListNode<VALUE> {
    VALUE value;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode(VALUE value) {
        this.value = value;
        this.prev = this.next = null;
    }

    public DoublyLinkedListNode(VALUE value, DoublyLinkedListNode prev, DoublyLinkedListNode next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        return "DoublyLinkedListNode{" +
                "value=" + value +
                '}';
    }
}
