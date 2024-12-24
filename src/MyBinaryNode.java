public class MyBinaryNode<K extends Comparable<K>> implements INode<K> {
    private K key;
    private MyBinaryNode<K> left;
    private MyBinaryNode<K> right;

    public MyBinaryNode(K key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public MyBinaryNode<K> getLeft() {
        return left;
    }

    public void setLeft(MyBinaryNode<K> left) {
        this.left = left;
    }

    public MyBinaryNode<K> getRight() {
        return right;
    }

    public void setRight(MyBinaryNode<K> right) {
        this.right = right;
    }
}