import java.util.Scanner;

public class bilanganbulat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bilPositif = 0, bilNegatif = 0;
        int bilangan;

        System.out.println("Masukkan serangkaian bilangan bulat (akhiri dengan 0):");

        while (true) {
            bilangan = scanner.nextInt();
            if (bilangan == 0) {
                break;
            }
            if (bilangan > 0) {
                bilPositif++;
            } else if (bilangan < 0) {
                bilNegatif++;
            }
        }

        System.out.println(bilNegatif + " " + bilPositif + " " + bandingkanJumlah(bilNegatif, bilPositif));

        scanner.close();
    }

    public static String bandingkanJumlah(int negatif, int positif) {
        if (negatif > positif) {
            return "negatif";
        } else if (positif > negatif) {
            return "positif";
        } else {
            return "imbang";
        }
    }
}