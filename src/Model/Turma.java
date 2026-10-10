package Model;

public class Turma {
    private Aluno alunos[];
    private int qtdalunos;


    public Turma( int capacidade) {
        this.alunos = new Aluno[capacidade];
        this.qtdalunos = qtdalunos = 0;
    }

    public void adicionarAluno(Aluno aluno) {
        if (qtdalunos < alunos.length) {
            alunos[qtdalunos] = aluno;
            qtdalunos++;
        } else {
            System.out.println("A turma está cheia");
        }
    }

    public void listarAprovados() {
        System.out.println("Alunos aprovados:");
        for (int i = 0; i < qtdalunos; i++) {
            if (alunos[i].estaAprovado()) {
                System.out.println(alunos[i].getNome());
            }
        }
    }

    public void listarReprovados() {
        System.out.println("Alunos reprovados:");
        for (int i = 0; i < qtdalunos; i++) {
            if (!alunos[i].estaAprovado()) {
                System.out.println(alunos[i].getNome());
            }
        }
    }
}


