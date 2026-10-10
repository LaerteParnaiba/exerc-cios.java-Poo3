import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
            int[] vet = new int[6];
            System.out.println("digite 6 numeros inteiros (1 até 60)");

            for(int i=0;i<vet.length;i++){
                int valor = sc.nextInt();
                vet[i] = valor;
            }
           int cont = 0 ;
             for(int i = 0; i<vet.length; i++){
                 for(int j=0;j<vet.length;j++){
                     if(vet[i]==vet[j]){
                         cont++;
                     }
                 }
                 if(cont>1){
                     System.out.println("Ha numeros repetidos");
                     return;
                 }
                   cont=0;
             }
        // ordena em ordem crescente
        for (int i = 0; i < vet.length - 1; i++) {
            for (int j = 0; j < vet.length - 1 - i; j++) {
                if (vet[j] > vet[j + 1]) {
                    int aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }

        // imprime
        System.out.println("Numeros em ordem crescente:");
        for (int i = 0; i < vet.length; i++) {
            System.out.println(vet[i]);
        }

        sc.close();


    }

}
