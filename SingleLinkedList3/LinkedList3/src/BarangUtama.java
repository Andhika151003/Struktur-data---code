import java.io.*;

class Node {
    Barang data;
    Node next;

    Node(Barang b) {
        data = b;
        next = null;
    }
}

class Barang {
    private int id;
    private String nama;
    private int stok;

    public Barang(int id, String nama, int stok) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public int getStok() {
        return stok;
    }

    public String info() {
        return id + " " + nama + " " + stok;
    }
}

public class BarangUtama {
    Node head;

    
    public void insert(Barang data) {
        Node nn = new Node(data);
        Node current = head;

        if (current == null) {
            head = nn;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = nn;
        }

        System.out.println("Node baru " + data.info() + " ditambahkan");
    }

    
    public void insertSorted(Barang data) {
        Node nn = new Node(data);
        Node current = head;

        
        if (head == null || head.data.getStok() >= nn.data.getStok()) {
            nn.next = head;
            head = nn;
        } else {
            
            while (current.next != null && current.next.data.getStok() < nn.data.getStok()) {
                current = current.next;
            }
            nn.next = current.next;
            current.next = nn;
        }

        System.out.println("Node baru " + data.info() + " ditambahkan");
    }

    
    public void delete(int id) {
        if (head == null) {
            System.out.println("List kosong");
            return;
        }

        
        if (head.data.getId() == id) {
            head = head.next;
            System.out.println("Node dengan id " + id + " telah dihapus");
            return;
        }

        
        Node current = head;
        Node prec = head;

        while (current != null) {
            if (current.data.getId() == id) {
                prec.next = current.next;
                current.next = null;
                System.out.println("Node dengan id " + id + " telah dihapus");
                return;
            }
            prec = current;
            current = current.next;
        }

        System.out.println("Node dengan id " + id + " tidak ditemukan");
    }

    
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data.info());
            current = current.next;
        }
    }

    
    void runThis() {
        System.out.println("=== Deret tidak terurut ===");
        insert(new Barang(5, "So So", 55));  
        insert(new Barang(2, "Clean", 22));  
        insert(new Barang(1, "So", 11));  
        insert(new Barang(8, "So So Clean", 88));  
        insert(new Barang(3, "So Clean", 33));  
        insert(new Barang(6, "Clean Clean", 66));  
        insert(new Barang(7, "So Clean So Clean", 77));  
        insert(new Barang(10, "Clean So So", 100));  
        insert(new Barang(9, "So Clean Clean", 99));  
        insert(new Barang(4, "Clean So", 44)); 
        printList();

        System.out.println("\n=== Deret terurut ===");
        insertSorted(new Barang(5, "So So", 17));  
        insertSorted(new Barang(2, "Clean", 65));  
        insertSorted(new Barang(1, "So", 15));  
        insertSorted(new Barang(8, "So So Clean", 32));  
        insertSorted(new Barang(3, "So Clean", 41));  
        insertSorted(new Barang(6, "Clean Clean", 100));  
        insertSorted(new Barang(7, "So Clean So Clean", 100));  
        insertSorted(new Barang(10, "Clean So So", 30));  
        insertSorted(new Barang(9, "So Clean Clean", 20));  
        insertSorted(new Barang(4, "Clean So", 10));  
        printList();

        System.out.println("\n=== Penghapusan data ===");
        delete(4);  
        delete(1);  
        delete(10);  
        delete(99);  
        printList();
    }

    public static void main(String[] args) {
        BarangUtama bu = new BarangUtama();
        bu.runThis();
    }
}
