import java.util.Scanner;

public class bilanganprima {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan bilangan bulat positif: ");
            int bilangan = scanner.nextInt();

            boolean isPrima = true;

            for (int i = 2; i <= Math.sqrt(bilangan); i++) {
                if (bilangan % i == 0) {
                    isPrima = false;
                    break;
                }
            }

            if (isPrima) {
                System.out.println(bilangan + " adalah bilangan prima");
            } else {
                System.out.println(bilangan + " bukan bilangan prima");
            }
        }
    }
}