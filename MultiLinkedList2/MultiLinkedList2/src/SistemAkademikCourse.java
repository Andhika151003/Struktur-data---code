class SistemAkademikCourse {
    SLLMahasiswa mahasiswa = null;
    SLLKelas kelas = null;
    SLLCourse course = null;

    public static void main(String[] args) {
        SistemAkademikCourse sa = new SistemAkademikCourse();
        sa.runThis();
    }

    void runThis() {
        // dibuat 3 buah list untuk menampung masing-masing struktur data
        kelas = new SLLKelas();
        mahasiswa = new SLLMahasiswa();
        course = new SLLCourse();

        System.out.println("Penambahan kelas");
        prosedurTambahKelas(1, "SE-07-01");
        prosedurTambahKelas(2, "SE-07-02");
        prosedurTambahKelas(3, "SE-07-03");
        prosedurTambahKelas(4, "SE-07-04");
        prosedurShowAllKelas();
        System.out.println("\n\n\n\n");

        System.out.println("Penambahan Mahasiswa dan Set Kelas");
        prosedurTambahMahasiswa(1, "Karno");
        prosedurSetKelas(1, 1);
        prosedurTambahMahasiswa(2, "Harto");
        prosedurSetKelas(2, 2);
        prosedurTambahMahasiswa(3, "Habi");
        prosedurSetKelas(3, 3);
        prosedurTambahMahasiswa(4, "Wahid");
        prosedurSetKelas(4, 4);
        prosedurTambahMahasiswa(5, "Mega");
        prosedurSetKelas(5, 1);
        prosedurTambahMahasiswa(6, "Susilo");
        prosedurSetKelas(6, 2);
        prosedurTambahMahasiswa(7, "Joko");
        prosedurTambahMahasiswa(8, "Bowo");
        prosedurShowAllMahasiswa();

        System.out.println("\n\n\n\n");
        System.out.println("Penambahan Mata Kuliah");
        prosedurTambahCourse(1, "CCK01", 3);
        prosedurTambahCourse(2, "CCK02", 2);
        prosedurTambahCourse(3, "CCK03", 4);
        prosedurTambahCourse(4, "CCK04", 3);
        prosedurShowAllCourse();

        System.out.println("\n\n\n\n");
        System.out.println("KRS");
        prosedurSetCourseMahasiswa(1, 1);
        prosedurSetCourseMahasiswa(1, 2);
        prosedurSetCourseMahasiswa(2, 1);
        System.out.println("Melihat data pengambilan course");
        prosedurViewCourseMahasiswa(1);
        prosedurViewCourseMahasiswa(2);

        System.out.println("\n\n\n\n");
        System.out.println("Perubahan nama Mata Kuliah");
        prosedurGantiNamaMK(1, "Nama Course Baru");
        System.out.println("Melihat data pengambilan course");
        prosedurViewCourseMahasiswa(1);
        prosedurViewCourseMahasiswa(2);
        prosedurShowAllCourse();

    }

    void prosedurTambahCourse(int id, String nama, int credit) {
        System.out.println("Prosedur pembuatan course baru " + nama);
        course.insert(new Course(id, nama, credit));
    }

    void prosedurTambahKelas(int id, String nama) {
        System.out.println("Prosedur pembuatan kelas baru " + nama);
        kelas.insert(new Kelas(id, nama));
    }

    void prosedurTambahMahasiswa(int nim, String nama) {
        System.out.println("Prosedur penerimaan mahasiswa baru baru " + nama);
        mahasiswa.insert(new Mahasiswa(nim, nama));
    }

    void prosedurShowAllCourse() {
        System.out.println("Prosedur Melihat data seluruh course");
        course.printList();
    }

    void prosedurShowAllMahasiswa() {
        System.out.println("Prosedur Melihat data seluruh mahasiswa");
        mahasiswa.printList();
    }

    void prosedurShowAllKelas() {
        System.out.println("Prosedur Melihat data seluruh Kelas");
        kelas.printList();
    }

    void prosedurSetKelas(int idMahasiswa, int idKelas) {
        System.out.println("Prosedur pemetakan mahasiswa ke kelas");
        NodeKelas k = kelas.search(idKelas);
        NodeMahasiswa m = mahasiswa.search(idMahasiswa);

        if ((m.data != null) && (k.data != null)) {
            mahasiswa.setKelas(m, k);
            System.out.println("Data kelas dan mahasiswa ditemukan dan telah diset");
        } else {
            System.out.println("List kosong");
        }
    }

    void prosedurSetCourseMahasiswa(int idMahasiswa, int idCourse) {
        System.out.println("Prosedur pemetakan mahasiswa ke course");
        NodeCourse c = course.search(idCourse);
        NodeMahasiswa m = mahasiswa.search(idMahasiswa);

        if ((m.data != null) && (c.data != null)) {
            mahasiswa.setCourse(m, c);
            System.out.println("Data mahasiswa dan course ditemukan dan telah diset");
        } else {
            System.out.println("List kosong");
        }
    }

    void prosedurViewCourseMahasiswa(int idMahasiswa) {
        System.out.println("Prosedur Daftar pengambilan SKS Mahasiswa");
        NodeMahasiswa c = mahasiswa.search(idMahasiswa);
        if (c == null) {
            System.out.println("Data mahasiswa tidak ditemukan");
        } else {
            c.data.daftarCourse();
        }
    }

    void prosedurGantiNamaMK(int idCourse, String namaBaru) {
        System.out.println("Prosedur ganti nama course");
        NodeCourse c = course.search(idCourse);
        if (c == null) {
            System.out.println("Data course tidak ditemukan");
        } else {
            c.data.setNama(namaBaru);
        }
    }
}

class Mahasiswa {
    private int id;
    private String nama;
    private NodeKelas kelas;
    private SLLCourse courseMahasiswa;

    /*
     * NodeKelas digunakan untuk menyimpan informasi mahasiswa tersebut dipetakan ke
     * kelas tertentu
     */
    public Mahasiswa(int id, String nama) {
        this.id = id;
        this.nama = nama;
        courseMahasiswa = new SLLCourse();
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setKelas(NodeKelas kelas) {
        this.kelas = kelas;
    }

    public void setCourse(NodeCourse course) {
        courseMahasiswa.insert(course.data);
    }

    public NodeKelas getKelas() {
        return kelas;
    }

    public void daftarCourse() {
        courseMahasiswa.printListMahasiswa();
    }

    public String toString() {
        if (kelas == null) {
            return id + " " + nama;
        } else {
            return id + " " + nama + " " + kelas.toString();
        }
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

    public String toString() {
        return id + " " + nama;
    }
}

class Course {
    private int id;
    private String nama;
    private int credit;

    public Course(int id, String nama, int credit) {
        this.id = id;
        this.nama = nama;
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getCredit() {
        return credit;
    }

    public String toString() {
        return id + " " + nama + " " + credit + " sks";
    }
}

class NodeKelas {
    Kelas data;
    NodeKelas next;

    NodeKelas(Kelas data) {
        this.data = data;
        next = null;
    }

    public String toString() {
        return data.toString();
    }
}

class NodeMahasiswa {
    Mahasiswa data;
    NodeMahasiswa next;

    NodeMahasiswa(Mahasiswa data) {
        this.data = data;
        next = null;
    }

    public String toString() {
        return data.toString();
    }
}

class NodeCourse {
    Course data;
    NodeCourse next;

    NodeCourse(Course data) {
        this.data = data;
        this.next = null;
    }

    public String toString() {
        return data.toString();
    }

}

class SLLKelas {
    NodeKelas head; // head of list

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
        } else {
            if (current.data.getId() == id) {
                return head;
            } else {
                boolean found = false;
                while (current != null) {
                    if (current.data.getId() == id) {
                        return current;
                    }
                    current = current.next;
                }
            }
        }
        return null;
    }

    public void printList() {
        NodeKelas current = head;
        while (current.next != null) {
            System.out.println(current.data.toString() + " ");
            current = current.next;
        }
    }
}

class SLLMahasiswa {
    NodeMahasiswa head; // head of list

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

    public NodeMahasiswa search(int id) {
        NodeMahasiswa current = head;
        while (current != null) {
            if (current.data.getId() == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void setKelas(NodeMahasiswa mahasiswa, NodeKelas kelas) {
        mahasiswa.data.setKelas(kelas);
        System.out.println(mahasiswa.data.getNama() + " dipetakan ke kelas " + kelas.toString());
    }

    public void setCourse(NodeMahasiswa mahasiswa, NodeCourse course) {
        mahasiswa.data.setCourse(course);
        System.out.println(mahasiswa.data.getNama() + " mengambil mata kuliah " + course.toString());
    }

    public void printList() {
        NodeMahasiswa current = head;
        while (current != null) {
            System.out.println(current.data.toString() + " ");
            current = current.next;
        }
    }
}

class SLLCourse {
    NodeCourse head; // head of list

    public int insert(Course data) {
        NodeCourse nn = new NodeCourse(data);
        NodeCourse current = head;

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

    public NodeCourse search(int id) {
        NodeCourse current = head;
        while (current.next != null) {
            if (current.data.getId() == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void printList() {
        NodeCourse current = head;
        while (current != null) {
            System.out.println(current.data.toString() + " ");
            current = current.next;
        }
    }

    public void printListMahasiswa() {
        NodeCourse current = head;
        int total = 0; // menyimpan total sks
        while (current != null) {
            System.out.println(current.data.toString() + " ");
            total = total + current.data.getCredit();
            current = current.next;
        }
        System.out.println("Total SKS : " + total + " SKS");
    }
}
