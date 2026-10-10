package Model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos alunos tem a turma? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // limpa o Enter que sobrou

        Turma turma = new Turma(quantidade);

        for (int i = 0; i < quantidade; i++) {
            System.out.println();
            System.out.println("Aluno " + (i + 1));

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine();

            Aluno aluno = new Aluno(nome, matricula);

            System.out.print("Quantas notas deseja cadastrar (máximo 4)? ");
            int qtdNotas = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < qtdNotas; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                double nota = scanner.nextDouble();
                scanner.nextLine();
                aluno.cadastrar_notas(nota);
            }

            turma.adicionarAluno(aluno);
        }

        System.out.println();
        turma.listarAprovados();
        System.out.println();
        turma.listarReprovados();

        scanner.close();
    }
}
