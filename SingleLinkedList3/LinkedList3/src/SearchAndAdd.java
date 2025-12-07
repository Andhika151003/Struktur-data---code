import java.io.*;

class Node1 {
    Barang1 data;
    Node1 next;

    Node1(Barang1 b) {
        data = b;
        next = null;
    }
}

class Barang1 {
    private int id;
    private String nama;
    private int stok;

    public Barang1(int id, String nama, int stok) {
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

    public String getNama() {
        return nama;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String info() {
        return id + " " + nama + " " + stok;
    }
}

public class SearchAndAdd {
    Node1 head;

    
    public void printList() {
        Node1 current = head;
        while (current != null) {
            System.out.println(current.data.info());
            current = current.next;
        }
    }

    
    public void insert(Barang1 data) {
        Node1 nn = new Node1(data);
        Node1 current = head;

        if (current == null) {
            head = nn;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = nn;
        }

        System.out.println("Node1 baru " + data.info() + " ditambahkan");
    }

    
    public void searchByNamaAndStok(String nama, int stok) {
        Node1 current = head;
        boolean found = false;
        
        while (current != null) {
            if (current.data.getNama().equals(nama) && current.data.getStok() == stok) {
                System.out.println("Barang ditemukan: " + current.data.info());
                found = true;
                break;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Barang dengan nama '" + nama + "' dan stok " + stok + " tidak ditemukan.");
        }
    }

    
    public void updateStok(int id, int perubahanStok) {
        Node1 current = head;
        boolean found = false;
    
        while (current != null) {
            if (current.data.getId() == id) {
                int stokBaru = current.data.getStok() + perubahanStok;
                
                
                if (stokBaru < 0) {
                    System.out.println("Stok tidak bisa dikurangi. Stok saat ini: " + current.data.getStok());
                } else {
                    current.data.setStok(stokBaru);
                    System.out.println("Stok barang dengan id " + id + " telah diperbarui. Stok baru: " + stokBaru);
                }
                found = true;
                break;
            }
            current = current.next;
        }
    
        if (!found) {
            System.out.println("Barang dengan id " + id + " tidak ditemukan.");
        }
    }

    
    void runThis() {
        System.out.println("=== Menambahkan data barang ===");
        insert(new Barang1(5, "risol", 55));  
        insert(new Barang1(2, "banana", 22));  
        insert(new Barang1(1, "jeruk", 11));  
        insert(new Barang1(8, "semangka", 88));  
        insert(new Barang1(3, "baju", 33));  
        insert(new Barang1(6, "amplas", 66));  
        insert(new Barang1(7, "oli", 77));  
        insert(new Barang1(10, "marjan", 100));  
        insert(new Barang1(9, "flashdisk", 99));  
        insert(new Barang1(4, "botol", 44)); 
        printList();

        System.out.println("\n=== Mencari barang berdasarkan nama dan stok ===");
        searchByNamaAndStok("banana", 22);  
        searchByNamaAndStok("flashdisk", 99);  

        //jika terdapat pengurangan tanda minus berarti stok dikurangi,dan jika hanya berupa angka berarti bertambah
        System.out.println("\n=== Mengupdate stok barang ===");
        updateStok(5, 10);  
        updateStok(4, -15);  
        //jika stok default nya adalah kurang dari angka yang akan di output kan maka stok tidak bisa dikurangi
        updateStok(2, -50);  
        printList();
    }

    public static void main(String[] args) {
        SearchAndAdd bu = new SearchAndAdd();
        bu.runThis();
    }
}