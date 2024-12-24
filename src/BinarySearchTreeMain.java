public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // UC1: Add nodes 56, 30, 70
        bst.add(56);
        bst.add(30);
        bst.add(70);
        System.out.println("UC1: Binary Search Tree after adding 56, 30, and 70:");
        bst.display();

        // UC2: Add more nodes to create the tree shown in the figure
        bst.add(22);
        bst.add(40);
        bst.add(11);
        bst.add(3);
        bst.add(16);
        bst.add(60);
        bst.add(95);
        bst.add(65);
        bst.add(63);
        bst.add(67);

        System.out.println("\nUC2: Binary Search Tree after adding more nodes:");
        bst.display();
        System.out.println("Size of the tree: " + bst.getSize());

        // UC3: Search for 63
        boolean isFound = bst.search(63);
        System.out.println("\nUC3: Search for 63: " + (isFound ? "Found" : "Not Found"));
    }
}