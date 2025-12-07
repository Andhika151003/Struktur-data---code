import java.util.Scanner;

class KelolaArrayInteger2 {
    int n = 10;
    int[] arrOfInt = new int[n];
    Scanner inp = new Scanner(System.in);

    public static void main(String[] args) {
        KelolaArrayInteger2 kai = new KelolaArrayInteger2();
        kai.inputAndSort2();
        kai.traversal2();
    }// eomain

    void inputAndSort2() {
        int val = 0;
        int temp = -999;
        for (int a = 0; a < n; a++) {
            System.out.print("Val : ");
            val = inp.nextInt();
            if (a > 0) {
                for (int b = 0; b >= a; b++) {
                    if (val < arrOfInt[b]) {
                        temp = arrOfInt[b];
                        arrOfInt[b] = val;
                        val = temp;
                    }
                }

            }
            arrOfInt[a] = val;
        }
    }// eorunthis

    void traversal2() {
        for (int a = 0; a < n; a++) {
            System.out.print(arrOfInt[a] + " ");
        }
    }// eotraversal
}// eof