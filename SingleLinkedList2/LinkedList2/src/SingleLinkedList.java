import java.io.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class SingleLinkedList {
    Node head; 

    
    public int insert(int data) {
        Node nn = new Node(data); 
        Node current = head;

        if (current == null) {
            nn.next = null;
            head = nn;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = nn;
        }

        System.out.println("Node baru " + data + " ditambahkan");
        return 0;
    }

    
    public void insertSorted(int data) {
        Node nn = new Node(data); 
        Node current = head;

        
        if (head == null || head.data >= nn.data) {
            nn.next = head;
            head = nn;
        } else {
            
            while (current.next != null && current.next.data < nn.data) {
                current = current.next;
            }
            nn.next = current.next;
            current.next = nn;
        }

        System.out.println("Node baru " + data + " ditambahkan");
    }

    
    public int delete(int data) {
        
        if (head == null) {
            System.out.println("List kosong");
            return 0;
        } else {
            
            if (head.data == data) {
                head = head.next;
                System.out.println("Node " + data + " telah dihapus");
                return 0;
            } else {
                
                Node current = head;
                Node prec = head;

                while (current != null) {
                    if (current.data == data) {
                        prec.next = current.next;
                        current.next = null;
                        System.out.println("Node " + data + " telah dihapus");
                        return 0;
                    }
                    prec = current;
                    current = current.next;
                }
            }
        }

        System.out.println("Node " + data + " tidak ditemukan");
        return 0;
    }
   
    public void printList() {
        Node current = head;
        System.out.print("Single LinkedList: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.runThis();
        
        
    }

    public void runThis() {
        System.out.println("=== Deret tidak terurut ===");
        insert(5);
        insert(1);
        insert(3);
        insert(2);
        insert(7);
        insert(6);
        insert(9);
        insert(8);
        printList(); 

        
        System.out.println("\n=== Deret terurut ===");
        head = null; 
        insertSorted(5);
        insertSorted(1);
        insertSorted(3);
        insertSorted(2);
        insertSorted(7);
        insertSorted(6);
        insertSorted(9);
        insertSorted(8);
        printList(); 

        
        System.out.println("\n=== Penghapusan data ===");
        delete(5); 
        printList(); 

        delete(1); 
        printList(); 

        delete(9); 
        printList(); 

        delete(99); 
        printList(); 
    }

}   