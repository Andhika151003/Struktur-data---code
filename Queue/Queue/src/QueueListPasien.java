import java.io.*;

class Pasien {
    int noUrut;
    String nama;

    Pasien(int nu, String nama) {
        this.noUrut = nu;
        this.nama = nama;
    }

    String info() {
        return noUrut + " " + nama;
    }

    int getNoUrut() {
        return noUrut;
    }
}

class Node {
    Pasien data;
    Node next;

    Node(Pasien d) {
        data = d;
        next = null;
    }
}

public class QueueListPasien {
    class Node {
        Pasien data;
        Node next;
    
        Node(Pasien d) {
            data = d;
            next = null;
        }
    }

    Node head; // head of list
    Node tail; // tail of list

    /* Tambah antrian */
    public int enqueue(String nama) {
        int noUrut = (head==null) ? 1 : tail.data.getNoUrut() + 1; 
        Pasien pasien = new Pasien(noUrut, nama);
        Node nn = new Node(pasien);

        if (head==null) { 
            head = nn;
            tail = nn;
        } else {
            tail.next = nn;
            tail = nn;
        }

        System.out.println("Pasien baru " + nama + " dengan no urut " + noUrut + " ditambahkan");
        return 0;
    }

    /* Ambil Urutan */
    public int dequeue() {
        if (head == null) {
            System.out.println("Antrian kosong");
            return 0;
        }
        
        Node current = head;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        System.out.println("Pasien dengan no urut " + current.data.getNoUrut() + " diambil dari antrian");
        return 0;
    }

    /* Ambil Antrian Tengah */
    public int ambilAntrianTengah(int noUrut) {
        if (head == null) {
            System.out.println("Antrian kosong");
            return 0;
        }

        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data.getNoUrut() == noUrut) {
                if (current == head) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }

                if (current == tail) {
                    tail = prev;
                }

                System.out.println("Pasien dengan no urut " + noUrut + " diambil dari antrian tengah");
                return 0;
            }

            prev = current;
            current = current.next;
        }

        System.out.println("Pasien dengan no urut " + noUrut + " tidak ditemukan");
        return 0;
    }

    public void printList() {
        Node current = head;
        System.out.println("Daftar antrian:");
        while (current != null) {
            System.out.println(current.data.info());
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        QueueListPasien sll = new QueueListPasien();
        sll.runThis();
    }

    void runThis() {
        enqueue("Gandalf The Grey");
        enqueue("Aragorn");
        enqueue("Legolas");
        enqueue("Gimli");
        enqueue("Boromir");
        enqueue("Frodo Baggins");
        enqueue("Samwise Gamgee");
        enqueue("Meri");
        enqueue("Pippin");
        printList();

        ambilAntrianTengah(5);
        printList();

        dequeue();
        printList();

        enqueue("Gandalf The White");
        printList();
    }
}
