class SistemAkademik{   
    // Terdapat 2 buat Single Linked List untuk menyimpan data masing-masing kelas dan mahasiswa
    SLLMahasiswa mahasiswa = null; 
    SLLKelas kelas = null; 

    public static void main(String[] args) { 
        SistemAkademik sa = new SistemAkademik();
        sa.runThis();
    }

    void runThis(){
        kelas = new SLLKelas(); 
        mahasiswa = new SLLMahasiswa(); 
        
        // 1. Lakukan penambahan kelas
        prosedurTambahKelas(1, "SE-07-01");
        prosedurTambahKelas(2, "SE-07-02");
        prosedurTambahKelas(3, "SE-07-03");
        prosedurTambahKelas(4, "SE-07-04");

        // 2. Tambahkan data mahasiswa
        prosedurTambahMahasiswa(101, "Ahmad");
        prosedurTambahMahasiswa(102, "Bobi");
        prosedurTambahMahasiswa(103, "Caca");
        prosedurTambahMahasiswa(104, "David");
        prosedurTambahMahasiswa(105, "Ela");
        prosedurTambahMahasiswa(106, "Franco");
        prosedurTambahMahasiswa(107, "Gorlock");
        prosedurTambahMahasiswa(108, "Hani");
        prosedurTambahMahasiswa(109, "Iman");
        prosedurTambahMahasiswa(110, "Joko");

        // 3. Petakan setiap mahasiswa ke dalam kelas secara merata
        prosedurSetKelas(101, 1);
        prosedurSetKelas(102, 1);
        prosedurSetKelas(103, 2);
        prosedurSetKelas(104, 2);
        prosedurSetKelas(105, 3);
        prosedurSetKelas(106, 3);
        prosedurSetKelas(107, 4);
        prosedurSetKelas(108, 4);
        prosedurSetKelas(109, 1);
        prosedurSetKelas(110, 2);

        // 4. Tampilkan data seluruh kelas yang telah ditambahkan
        prosedurShowAllKelas();
        
        // Tampilkan data seluruh mahasiswa yang telah dipetakan ke kelas
        prosedurShowAllMahasiswa();
    }

    void prosedurTambahKelas(int id, String nama){
        System.out.println("Prosedur pembuatan kelas baru " + nama);
        kelas.insert(new Kelas(id, nama)); 
    }

    void prosedurTambahMahasiswa(int nim, String nama){
        System.out.println("Prosedur penerimaan mahasiswa baru " + nama);
        mahasiswa.insert(new Mahasiswa(nim, nama)); 
    }

    void prosedurShowAllMahasiswa(){
        System.out.println("Prosedur Melihat data seluruh mahasiswa");
        mahasiswa.printList();
    }

    void prosedurShowAllKelas(){
        System.out.println("Prosedur Melihat data seluruh Kelas");
        kelas.printList();
    }

    void prosedurSetKelas(int idMahasiswa, int idKelas){
        System.out.println("Prosedur pemetakan mahasiswa ke kelas");
        NodeKelas k = kelas.search(idKelas);
        int returnValue = mahasiswa.setKelas(idMahasiswa, k);
        switch (returnValue){
            case 0 : System.out.println("List kosong"); break;
            case 1 : System.out.println("Data ditemukan dan telah diset"); break;
        }
    }
}

class SLLMahasiswa {
    NodeMahasiswa head;

    public int insert(Mahasiswa data) {
        NodeMahasiswa nn = new NodeMahasiswa(data);
        NodeMahasiswa current = head;

        if (current == null) {
            nn.next = null;
            head = nn;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = nn;
        }
        return 1;
    }

    public int setKelas(int nim, NodeKelas k) {
        NodeMahasiswa current = head;

        if (current == null) {
            return 0; // List kosong
        }

        while (current != null) {
            if (current.data.getNim() == nim) {
                current.data.setKelas(k.data); // Set kelas untuk mahasiswa
                return 1; // Data ditemukan dan telah diset
            }
            current = current.next;
        }
        return 0; // Mahasiswa tidak ditemukan
    }

    public void printList() {
        NodeMahasiswa current = head;
        while (current != null) {
            System.out.println(current.data.toString());
            current = current.next;
        }
    }
}

class SLLKelas {
    NodeKelas head;

    public int insert(Kelas data) {
        NodeKelas nn = new NodeKelas(data);
        NodeKelas current = head;

        if (current == null) {
            nn.next = null;
            head = nn;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = nn;
        }
        return 1;
    }

    public NodeKelas search(int id) {
        NodeKelas current = head;
        if (current == null) {
            return null;
        }

        while (current != null) {
            if (current.data.getId() == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void printList() {
        NodeKelas current = head;
        while (current != null) {
            System.out.println(current.data.toString());
            current = current.next;
        }
    }
}

class Mahasiswa {
    private int nim;
    private String nama;
    private Kelas kelas; // Untuk menyimpan kelas yang diambil mahasiswa

    public Mahasiswa(int nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = null; // Awalnya mahasiswa tidak terdaftar di kelas manapun
    }

    public int getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas; // Set kelas ke mahasiswa
    }

    @Override
    public String toString() {
        return nim + " " + nama + (kelas != null ? " - " + kelas.getNama() : " - Belum Terdaftar di Kelas");
    }
}

class Kelas {
    private int id;
    private String nama;

    public Kelas(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public String toString() {
        return id + " " + nama;
    }
}

class NodeMahasiswa {
    Mahasiswa data;
    NodeMahasiswa next;

    public NodeMahasiswa(Mahasiswa data) {
        this.data = data;
        this.next = null;
    }
}

class NodeKelas {
    Kelas data;
    NodeKelas next;

    public NodeKelas(Kelas data) {
        this.data = data;
        this.next = null;
    }
}
