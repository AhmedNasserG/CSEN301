package CSEN301.PA9;

class Node {

    public Comparable data;
    public Node left, right;

    public Node(Comparable data) {
        this(data, null, null);
    }

    public Node(Comparable data, Node left, Node right) {

        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BTree {
    private Node root;

    public BTree() {
        root = null;
    }


    public void add(Comparable key) {
        Node current = root, parent = null;
        while (current != null) {
            if (key.compareTo(current.data) < 0) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }

        if (parent == null)
            root = new Node(key);

        else {
            if (key.compareTo(parent.data) < 0)
                parent.left = new Node(key);

            else
                parent.right = new Node(key);
        }
    }

    public boolean delete(Comparable key) {
        if (root == null)
            return false;
        Node current = root;
        Node parent = root;
        boolean right = true;
        // searching for the node to be deleted
        while (key.compareTo(current.data) != 0) {
            if (key.compareTo(current.data) < 0) {
                right = false;
                parent = current;
                current = current.left;
            } else {
                right = true;
                parent = current;
                current = current.right;
            }
            if (current == null)
                return false;
        }

        Node substitute = null;
        //  case 1: Node to be deleted has no children
        if (current.left == null && current.right == null)
            substitute = null;

            //  case 2: Node to be deleted has one child
        else if (current.left == null)
            substitute = current.right;
        else if (current.right == null)
            substitute = current.left;
        else // case 3: Node to be deleted has two children
        {
            Node successor = current.right;
            Node successorParent = current;
            //  searching for the inorder successor of the node to be deleted
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            substitute = successor;
            if (successorParent == current) {
                if (successor.right == null)
                    successorParent.right = null;
                else
                    successorParent.right = successor.right;
            } else {
                if (successor.right == null)
                    successorParent.left = null;
                else
                    successorParent.left = successor.right;
            }
            successor.right = current.right;
            successor.left = current.left;
            substitute = successor;
        } // case 3 done
        if (current == root) // Replacing the deleted node
            root = substitute;
        else if (right)
            parent.right = substitute;
        else
            parent.left = substitute;
        return true;

    }

    public void displayTree() {
        java.util.Stack<Node> globalStack = new java.util.Stack<Node>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while (isRowEmpty == false) {
            java.util.Stack<Node> localStack = new java.util.Stack<Node>();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (globalStack.isEmpty() == false) {
                Node temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.left);
                    localStack.push(temp.right);

                    if (temp.left != null ||
                            temp.right != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }  // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }  // end while isRowEmpty is false
        System.out.println(
                "......................................................");
    }

    public Comparable maxKey() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public Comparable maxKeyOfBTree() {
        return maxKeyOfBTreeHelper(root, -1);
    }

    int maxKeyOfBTreeHelper(Node current, int max) {
        if (current == null) {
            return -1;
        }
        if (current.data.compareTo(max) > 0) {
            max = (int) current.data;
        }
        max = Math.max(max, maxKeyOfBTreeHelper(current.left, max));
        max = Math.max(max, maxKeyOfBTreeHelper(current.right, max));
        return max;
    }

    public int size() {
        return sizeHelper(root);
    }

    int sizeHelper(Node current) {
        if (current == null) {
            return 0;
        }
        return 1 + sizeHelper(current.right) + sizeHelper(current.left);
    }

    public int numLeaves() {
        return numLeavesHelper(root);
    }

    int numLeavesHelper(Node current) {
        if (current == null) {
            return 0;
        }
        if (current.left == null && current.right == null) {
            return 1;
        }
        return numLeavesHelper(current.left) + numLeavesHelper(current.right);
    }

    public int sum() {
        return sumHelper(root);
    }

    int sumHelper(Node current) {
        if (current == null) {
            return 0;
        }
        return (int) (current.data) + sumHelper(current.left) + sumHelper(current.right);
    }
    // Wrong answer isBST check your    LeetCode answers using range and previous
    public boolean isBST() {
        return isBSTHelper(root);
    }

    boolean isBSTHelper(Node current) {
        if (current == null) {
            return true;
        }
        if (current.right != null && current.right.data.compareTo(current.data) < 0) {
            return false;
        }
        if (current.left != null && current.left.data.compareTo(current.data) > 0) {
            return false;
        }
        return isBSTHelper(current.right) && isBSTHelper(current.left);
    }

    public int numLeftChildNodes() {
        return numLeftChildNodes(root);
    }

    int numLeftChildNodes(Node current) {
        if (current == null) {
            return 0;
        }
        if (current.right == null && current.left != null) {
            return 1 + numLeftChildNodes(current.left);
        }
        return numLeftChildNodes(current.left) + numLeftChildNodes(current.right);
    }

    public int countOccur(Comparable key) {
        return countOccur(key, root);
    }

    int countOccur(Comparable key, Node current) {
        if (current == null) {
            return 0;
        }
        if (current.data.compareTo(key) == 0) {
            return 1 + countOccur(key, current.right) + countOccur(key, current.left);
        }
        return countOccur(key, current.right) + countOccur(key, current.left);
    }

    public boolean hasDups(Comparable key) {
        return countOccur(key) > 1;
    }

    public void mirror() {
        mirror(root);
    }

    void mirror(Node current) {
        if (current == null) {
            return;
        }
        Node temp = current.left;
        current.left = current.right;
        current.right = temp;
        mirror(current.left);
        mirror(current.right);
    }

    public String oddNodes() {
        return oddNodes(root);
    }

    String oddNodes(Node current) {
        if (current == null) {
            return "";
        }
        if ((int) current.data % 2 == 1) {
            return (int) current.data + " " + oddNodes(current.right) + oddNodes(current.left);
        }
        return oddNodes(current.right) + oddNodes(current.left);

    }

    int level(Comparable key) {
        return level(key, root);
    }

    int level(Comparable key, Node current) {
        if (current == null){
            return -1;
        }
        if (current.data.compareTo(key) == 0){
            return 0;
        }
        int r = level(key, current.right);
        int l = level(key, current.left);
        if (r != -1){
            return 1 + r;
        }
        if (l != -1){
            return 1 + l;
        }
        return -1;
    }

    public BTree doubleValues(){
        BTree t = new BTree();
        t.root = doubleValues(root);
        return t;
    }
    Node doubleValues(Node current){
        if (current == null){
            return null;
        }
        current.data = 2 * (int)current.data;
        current.right = doubleValues(current.right);
        current.left = doubleValues(current.left);
        return current;
    }
    public boolean equal(BTree t2){
        return equal(root, t2.root);
    }
    boolean equal(Node c1, Node c2){
        if (c1 == null && c2 == null){
            return true;
        }
        if (c1 == null || c2 == null){
            return false;
        }
        if (c1.data.compareTo(c2.data) != 0){
            return false;
        }
        return equal(c1.left,c2.left) && equal(c1.right,c2.right);
    }

    private boolean isBST(Node node)
    {
//an empty tree is trivially a binary search tree
        if (node==null)
            return true;
        if (node.left!=null && maxValue(node.left).compareTo(node.data)>0)
            return false;
        if (node.right!=null && minValue(node.right).compareTo(node.data)<=0)
            return false;
        return isBST(node.left) && isBST(node.right);
    }
    public Comparable minValue(Node node)
    {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return(current.data);
    }
    public Comparable maxValue(Node node)
    {
        Node current = node;
        while (current.right != null)
            current = current.right;
        return(current.data);
    }

    public static void main(String[] args) {
        BTree t = new BTree();
        t.add(2);
        t.add(1);
        t.add(3);
        t.add(0);
        t.add(4);
        t.displayTree();
        System.out.println(t.isBST(t.root));
//        t = t.doubleValues();
//        t.displayTree();
//        System.out.println(t.level(0));
    }
}