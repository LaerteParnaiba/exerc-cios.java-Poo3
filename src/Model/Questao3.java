

package Model;
import  java.util.Scanner;
public class Questao3 {
    public  static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
         System.out.println("Digite um numero inteiro");
        int n = sc.nextInt();
        int a = 1;
        int b = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.print(a - 1);
            } else {
                System.out.print(a);
                int prox = a + b;

                a = b;
                b = prox;
            }


        }
    }

}
