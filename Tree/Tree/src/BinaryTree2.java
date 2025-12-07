// Node Class
class Node {
    Mahasiswa mahasiswa;
    Node left, right;

    public Node(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
        left = right = null;
    }
}

class Mahasiswa {
    int nim;
    String nama;

    public Mahasiswa(int nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public int getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String toString() {
        return (nim + " " + nama);
    }
}

public class BinaryTree2 {
    Node root;

    public static void main(String[] args) {
        BinaryTree2 tree = new BinaryTree2();
        
        // Memasukkan data mahasiswa
        tree.insert(new Mahasiswa(1201230001, "Bobi"));
        tree.insert(new Mahasiswa(1201230006, "Kina"));
        tree.insert(new Mahasiswa(1201230003, "Marina"));
        tree.insert(new Mahasiswa(1201230007, "Dorabela"));
        tree.insert(new Mahasiswa(1201230005, "Eve"));
        tree.dataShow();
    }

    public BinaryTree2() {
        root = null;
    }

    public void insert(Mahasiswa mahasiswa) {
        root = insertRecord(root, mahasiswa);
    }

    private Node insertRecord(Node root, Mahasiswa mahasiswa) {
        if (root == null) {
            root = new Node(mahasiswa);
            return root;
        }
        if (mahasiswa.getNim() < root.mahasiswa.getNim())
            root.left = insertRecord(root.left, mahasiswa);
        else if (mahasiswa.getNim() > root.mahasiswa.getNim())
            root.right = insertRecord(root.right, mahasiswa);
        return root;
    }

    public void dataShow() {
        System.out.print("inorder  : ");
        inorderRec(root);
        System.out.println();
        System.out.print("Preorder : ");
        preorderTraversal(root);
        System.out.println();
        System.out.print("Postorder : ");
        postorderTraversal(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.mahasiswa + " | ");
            inorderRec(root.right);
        }
    }

    void preorderTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.mahasiswa + " | ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    void postorderTraversal(Node node) {
        if (node == null)
            return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.mahasiswa + " | ");
    }

    public boolean search(int nim) {
        return searchRec(root, nim);
    }

    private boolean searchRec(Node root, int nim) {
        if (root == null)
            return false;
        if (root.mahasiswa.getNim() == nim)
            return true;
        if (nim < root.mahasiswa.getNim())
            return searchRec(root.left, nim);
        else
            return searchRec(root.right, nim);
    }

    public Mahasiswa findMin() {
        return findMinRec(root);
    }

    private Mahasiswa findMinRec(Node root) {
        if (root == null)
            throw new IllegalStateException("Empty Tree");
        
        if (root.left == null)
            return root.mahasiswa;
        
        return findMinRec(root.left);
    }
}