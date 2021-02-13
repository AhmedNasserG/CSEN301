package CSEN301.PA10;

import CSEN301.PA4.StackObj;
import CSEN301.PA7.LinkList;

import java.util.Stack;

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

    void printLevel(int n) {
        printLevel(n, root);
    }

    void printLevel(int n, Node current) {
        if (current == null) {
            return;
        }
        if (n == 0) {
            System.out.print(current.data + " ");

        }
        printLevel(n - 1, current.left);
        printLevel(n - 1, current.right);
    }

    void breadthTraversal() {
        breadthTraversal(root);
    }

    void breadthTraversal(Node current) {
        if (current == null) {
            return;
        }
        if (current == root) {
            System.out.print(current.data + " ");
        }
        if (current.left != null)
            System.out.print(current.left.data + " ");
        if (current.right != null)
            System.out.print(current.right.data + " ");
        breadthTraversal(current.left);
        breadthTraversal(current.right);
    }

    String descendingOrder() {
        return descendingOrder(root);
    }

    String descendingOrder(Node current) {
        if (current == null) {
            return "";
        }
        return descendingOrder(current.right) + " " + current.data + " " + descendingOrder(current.left);
    }

    void printRange(int lowerBound, int upperBound) {
        printRange(lowerBound, upperBound, root);
    }

    void printRange(int lowerBound, int upperBound, Node current) {
        if (current == null) {
            return;
        }
        if (current.data.compareTo(lowerBound) > 0 && current.data.compareTo(upperBound) < 0) {
            System.out.println(current.data + " ");
        }
        if (current.data.compareTo(lowerBound) > 0) {
            printRange(lowerBound, upperBound, current.left);
        }
        if (current.data.compareTo(upperBound) < 0) {
            printRange(lowerBound, upperBound, current.right);
        }
    }

    void preorderIter() {
        Stack s = new Stack();
        if (root != null)
            s.push(root);
        while (!s.isEmpty()) {
            Node temp = (Node) s.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                s.push(temp.right);
            }
            if (temp.left != null) {
                s.push(temp.left);
            }
        }
    }

    LinkList path(Comparable key) {
        return path(key, root);
    }

    LinkList path(Comparable key, Node current) {
        if (current == null) {
            return null;
        }
        if (current.data.compareTo(key) == 0) {
            LinkList l = new LinkList();
            l.insertLast(current.data);
            return l;
        }
        LinkList left = path(key, current.left);
        if (left != null) {
            left.insertFirst(current.data);
            return left;
        }
        LinkList right = path(key, current.right);
        if (right != null) {
            right.insertFirst(current.data);
            return right;
        }

        return null;
    }

    int heightRec() {
        return heightRec(root);
    }

    int heightRec(Node current) {
        if (current == null) {
            return -1;
        }
        return 1 + Math.max(heightRec(current.left), heightRec(current.right));
    }

    int heightItr() {
        if (root == null) {
            return -1;
        }
        int count = 0;
        LinkList levelA = new LinkList();
        LinkList levelB = new LinkList();
        levelA.insertFirst(root);

        while (!levelA.isEmpty()) {
            Node temp = (Node) levelA.removeFirst();
            if (temp.left != null) {
                levelB.insertFirst(temp.left);
            }
            if (temp.right != null) {
                levelB.insertFirst(temp.right);
            }
            if (levelA.isEmpty() && !levelB.isEmpty()) {
                count++;
                while (!levelB.isEmpty()) {
                    levelA.insertFirst(levelB.removeFirst());
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BTree t = new BTree();
        t.add(4);
        t.add(2);
        t.add(3);
        t.add(1);
        t.add(6);
        t.add(5);
        t.add(7);
        t.displayTree();
        LinkList l = t.path(1);
        System.out.println(l);

    }

}