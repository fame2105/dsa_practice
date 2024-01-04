package dsa.catalogueOrder.foundation.genericTree;

import java.util.ArrayList;

// GenericTreeNode
public class GTNode<T> {
    public T data;
    public ArrayList<GTNode> children;

    public GTNode() {
        this.data = null;
        this.children = new ArrayList<>();
    }

    public GTNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

}
