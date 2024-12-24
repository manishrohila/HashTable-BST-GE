public class BinarySearchTree<K extends Comparable<K>> {
    private MyBinaryNode<K> root;

    public void add(K key) {
        this.root = this.addRecursively(root, key);
    }

    private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key) {
        if (current == null) {
            return new MyBinaryNode<>(key);
        }

        int compareResult = key.compareTo(current.getKey());
        if (compareResult < 0) {
            current.setLeft(addRecursively(current.getLeft(), key));
        } else if (compareResult > 0) {
            current.setRight(addRecursively(current.getRight(), key));
        }
        return current;
    }

    public int getSize() {
        return this.getSizeRecursively(root);
    }

    private int getSizeRecursively(MyBinaryNode<K> current) {
        return (current == null) ? 0 : 1 + getSizeRecursively(current.getLeft()) + getSizeRecursively(current.getRight());
    }

    public boolean search(K key) {
        return this.searchRecursively(root, key);
    }

    private boolean searchRecursively(MyBinaryNode<K> current, K key) {
        if (current == null) {
            return false;
        }

        int compareResult = key.compareTo(current.getKey());
        if (compareResult == 0) {
            return true;
        }
        return (compareResult < 0) ? searchRecursively(current.getLeft(), key) : searchRecursively(current.getRight(), key);
    }

    public void display() {
        this.inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(MyBinaryNode<K> node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getKey() + " ");
            inOrderTraversal(node.getRight());
        }
    }
}
