import java.util.Scanner;

public class bilangangenap {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int bilGenap = 0, bilTerbesar = 0, bilanganPositif;

            System.out.println("Masukkan serangkaian bilangan Genap positif (akhiri dengan 0):");

            while (true) {
                bilanganPositif = scanner.nextInt();
                if (bilanganPositif == 0) {
                    break;
                } 
                if (bilanganPositif %2 == 0) {
                    bilGenap++;
                    if(bilanganPositif > bilTerbesar) {
                        bilTerbesar = bilanganPositif;
                    }
                }
            }
            System.out.println("Jumlah bilangan genap: " + bilGenap);
            System.out.println("Bilangan genap terbesar: " + bilTerbesar);
        }
    }
}
