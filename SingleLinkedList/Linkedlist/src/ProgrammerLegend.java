import java.util.Scanner;

public class ProgrammerLegend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah programmer: ");
        int jumlahProgrammer = scanner.nextInt();

        for (int i = 1; i <= jumlahProgrammer; i++) {
            System.out.println("Programmer ke-" + i);
            System.out.print("Masukkan logicalPower: ");
            int logicalPower = scanner.nextInt();
            System.out.print("Masukkan bugTracingPower: ");
            int bugTracingPower = scanner.nextInt();
            System.out.print("Masukkan endurancePower: ");
            int endurancePower = scanner.nextInt();

            double totalKekuatan = hitungTotalKekuatan(logicalPower, bugTracingPower, endurancePower);
            System.out.println("Total coding power Programmer " + i + ": " + totalKekuatan);
        }

        scanner.close();
    }

    public static double hitungTotalKekuatan(int logicalPower, int bugTracingPower, int endurancePower) {
        double totalKekuatan = (2 * logicalPower) + (3 * bugTracingPower) - (0.5 * endurancePower);
        return totalKekuatan;
    }
}