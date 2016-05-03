package entity;


public class Node {
    private Node[] array = new Node[26];
    private boolean isLeaf;
    private boolean processed;
    private int index;

    public Node() {
    }

    public Node(int index) {
        this.index = index;
    }

    public Node[] getArray() {
        return this.array;
    }

    public void setArray(Node[] array) {
        this.array = array;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

}