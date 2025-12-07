import java.io.*;
import java.util.Scanner;

class Node {
    Barang data;
    Node next;
    Node prev;

    Node(Barang d) {
        data = d;
        next = null;
        prev = null;
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

    public String info() {
        return id + " " + nama + " " + stok;
    }
}

public class BarangList {
    Node head; 
    Node tail; 

    Scanner inp = new Scanner(System.in);

    public void insertEnd(Barang data) {
        Node nn = new Node(data);
        if (tail == null) {
            head = tail = nn;
        } else {
            tail.next = nn;
            nn.prev = tail;
            tail = nn;
        }
        System.out.println("Node baru " + data.info() + " di posisi belakang");
    }

    public void insertFirst(Barang data) {
        Node nn = new Node(data);
        if (head == null) {
            head = tail = nn;
        } else {
            head.prev = nn;
            nn.next = head;
            head = nn;
        }
        System.out.println("Node baru " + data.info() + " di posisi depan");
    }

    public void insertSorted(Barang data) {
        Node newNode = new Node(data);

        // Kasus 1: Jika list kosong
        if (head == null) {
            head = tail = newNode;
            System.out.println("Node baru " + data.info() + " paling depan");
            return;
        }

        // Kasus 2: Jika new node adalah angka paling kecil
        if (data.getId() <= head.data.getId()) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            System.out.println("Node baru " + data.info() + " paling depan");
            return;
        }

        // Kasus 3: Jika new node angka paling besar
        if (data.getId() >= tail.data.getId()) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            System.out.println("Node baru " + data.info() + " paling belakang");
            return;
        }

        // Kasus 4: Di antara head dan tail
        Node current = head;
        while (current != null && current.data.getId() < data.getId()) {
            current = current.next;
        }

        // Insert the node before the current node
        newNode.next = current;
        newNode.prev = current.prev;

        if (current.prev != null) {
            current.prev.next = newNode;
        }
        current.prev = newNode;

        System.out.println("Node baru " + data.info() + " di tengah");
    }

    public void delete(Barang data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;

        // Case 1: Delete the head node
        if (head.data.getId() == data.getId()) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // Jika list menjadi kosong
            }
            return;
        }

        // Traverse to find the node to delete
        while (current != null && current.data.getId() != data.getId()) {
            current = current.next;
        }

        // Case 2: Node not found
        if (current == null) {
            System.out.println("Node " + data.info() + " tidak ditemukan.");
            return;
        }

        // Case 3: Delete a middle node or tail
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev; // Jika node yang dihapus adalah tail
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }
    }

        /* Print the list backward */
    public void printListBackward() {
        Node current = tail; // Mulai dari tail
    
        System.out.print("Double LinkedList Backward: ");
    
        while (current != null) {
            System.out.print(current.data.info() + " ");
            current = current.next;
        }

        System.out.println();
    }

    /* Print the list forward */
    public void printListForward() {
        Node current = head; // Mulai dari head

        System.out.print("Double LinkedList Forward: ");

        while (current != null) {
            System.out.print(current.data.info() + " ");
            current = current.prev;
        }

        System.out.println();
    }


    /* Cetak list */
    public void printList() {
        System.out.println("List dari depan:");
        printListForward();
        System.out.println("List dari belakang:");
        printListBackward();
    }

    /* Main method */
    public static void main(String[] args) {
        BarangList bl = new BarangList();
        bl.runThis();
    }

    /* Run various operations */
    void runThis() {
        // INSERT BIASA
        insertFirst(new Barang(1, "Barang A", 10));
        insertEnd(new Barang(5, "Barang B", 20));
        insertEnd(new Barang(3, "Barang C", 15));
        insertFirst(new Barang(2, "Barang D", 25));
        insertFirst(new Barang(7, "Barang E", 5));
        insertEnd(new Barang(6, "Barang F", 30));
        insertFirst(new Barang(9, "Barang G", 12));
        insertEnd(new Barang(8, "Barang H", 8));
        printList();

        // DELETE nodes
        delete(new Barang(6, "Barang F", 30));
        printList();

        delete(new Barang(1, "Barang A", 10));
        printList();

        delete(new Barang(9, "Barang G", 12));
        printList();
    }
}