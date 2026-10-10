package Model;



public class Aluno {
    private  String nome;
    private String  matricula;
    private  double notas[];
    private int qtdnotas;



    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = new double[4];
        this.qtdnotas = 0;





    }


     public void cadastrar_notas(double nota){
          if(qtdnotas<notas.length){
              notas[qtdnotas]=nota;
              qtdnotas++;
        }
          else{
              System.out.println("Todas as notas ja estao cadastradas");
          }

    }

     public  double calcular_media(){
         if(qtdnotas==0){
             return 0;
         }
        double soma = 0;
        for(int i=0; i<qtdnotas;i++){
            soma = soma+notas[i];

        }

         return soma/qtdnotas;
     }

      public  boolean estaAprovado(){
        double media = calcular_media();
        return media>=7;

    }

    public String getNome() {
        return nome;
    }
}




