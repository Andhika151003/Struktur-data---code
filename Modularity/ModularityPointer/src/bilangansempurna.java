import java.util.Scanner;

public class bilangansempurna {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan bilangan bulat positif: ");
            int bilangan = scanner.nextInt();

            int jumlahPembagi = 1; 

            for (int i = 2; i <= bilangan / 2; i++) {
                if (bilangan % i == 0) {
                    jumlahPembagi += i;
                }
            }

            if (jumlahPembagi == bilangan) {
                System.out.println(bilangan + " adalah bilangan sempurna");
            } else {
                System.out.println(bilangan + " adalah bilangan tidak sempurna");
            }
        }
    }
}