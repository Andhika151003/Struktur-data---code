import java.util.Scanner;

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

class Node {
    Barang data;
    Node next;

    Node(Barang data) {
        this.data = data;
        next = null;
    }
}

public class BarangStack {
    Node top; 
    Scanner inp = new Scanner(System.in);

    public void push(Barang data) {
        Node newNode = new Node(data);
        if (top == null) {   
            top = newNode;
        } else {   
            newNode.next = top;
            top = newNode;
        }
        System.out.println("PUSH " + data.info());
    }

    public void pop() {
        if (top == null) { 
            System.out.println("Stack is empty!");
            return;
        } else {
            Node node = top;
            top = top.next;
            node.next = null; 
            System.out.println("POP " + node.data.info());
        }
    }

    public void delete(int id) {
        if (top == null) {   
            System.out.println("Stack is empty!");
            return;
        }

        
        if (top.data.getId() == id) {
            top = top.next;
            System.out.println("DELETE : " + id);
            return;
        }

        Node current = top;
        Node prev = null;

        
        while (current != null && current.data.getId() != id) {
            prev = current;
            current = current.next;
        }

        
        if (current == null) {
            System.out.println("DELETE : " + id + " NOT FOUND");
            return;
        }

        
        prev.next = current.next;
        System.out.println("DELETE : " + id);
    }

    public void print() {
        if (top == null) { 
            System.out.println("Stack is empty!");
            return;
        } else {
            Node current = top;
            System.out.print("Stack: ");
            
            while (current != null) {
                System.out.print(current.data.info() + " | ");
                current = current.next;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        BarangStack bs = new BarangStack();
        bs.runThis();
    }

    void runThis() {
        push(new Barang(1, "Buku", 20));
        push(new Barang(2, "Pensil", 50));
        push(new Barang(3, "Penghapus", 30));
        print();
        pop();
        print();
        delete(1);
        print();
        delete(5); 
        print();
    }
}
