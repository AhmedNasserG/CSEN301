package CSEN301.PA9;

public class IdealTopologyOfBinarySearchTree {
    static void insert(BTree t,int[] arr, int b, int e){
        if (b > e){
            return;
        }
        int mid = (e - b) / 2 + b;
        t.add(arr[mid]);
        insert(t,arr,b,mid - 1);
        insert(t,arr,mid + 1,e);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        BTree t = new BTree();
        insert(t, arr, 0, arr.length - 1);
        t.displayTree();
    }
}
