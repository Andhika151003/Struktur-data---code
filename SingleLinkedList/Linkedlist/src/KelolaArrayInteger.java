import java.util.Scanner;

class KelolaArrayInteger {
    int n = 10;
    int[] arrOfInt = new int[n];
    Scanner inp = new Scanner(System.in);

    public static void main(String[] args) {
        KelolaArrayInteger kai = new KelolaArrayInteger();
        kai.inputAndSort();
        kai.traversal();
    }// eomain

    void inputAndSort() {
        int val = 0;
        int temp = -999;
        for (int a = 0; a < n; a++) {
            System.out.print("Val : ");
            val = inp.nextInt();
            if (a > 0) {
                for (int b = 0; b <= a; b++) {
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

    void traversal() {
        for (int a = 0; a < n; a++) {
            System.out.print(arrOfInt[a] + " ");
        }
    }// eotraversal
}// eof