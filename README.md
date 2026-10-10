# Array de primitivos x array de objetos em Java

## Qual é a diferença?

Os dois parecem iguais na hora de escrever, mas funcionam de um jeito diferente por dentro.

No array de primitivos (`int[]`, `double[]`), cada posição guarda o **valor mesmo**. Se eu faço `notas[0] = 8.5`, o 8.5 fica guardado ali dentro.

No array de objetos (`Aluno[]`, `Produto[]`), cada posição não guarda o objeto em si, e sim uma **referência**, que é tipo um endereço dizendo onde o objeto está na memória.

Uma comparação que me ajudou a entender: o array de primitivos é uma gaveta com as coisas dentro. O array de objetos é uma gaveta com bilhetinhos dizendo onde cada coisa foi guardada. Se o bilhete está em branco, não tem nada para pegar.

## a) Como a memória é alocada em cada caso?

**Array de primitivos**

```java
int[] idades = new int[3];
```

O Java separa um espaço na memória para os 3 valores e já deixa todos preenchidos com um valor padrão: `0` para `int`, `0.0` para `double` e `false` para `boolean`. Por isso eu já posso usar `idades[0]` logo depois de criar, sem problema nenhum.

```
idades -> [ 0 | 0 | 0 ]
```

**Array de objetos**

```java
Aluno[] alunos = new Aluno[3];
```

Aqui o Java só cria o array com 3 espaços para referências. Os alunos **não são criados** nesse momento, e todas as posições começam com `null` (que quer dizer "não aponta para nada").

```
alunos -> [ null | null | null ]
```

Cada aluno precisa ser criado separadamente com `new`:

```java
alunos[0] = new Aluno("Ana", "001");
alunos[1] = new Aluno("Bruno", "002");
```

Só depois disso as posições passam a apontar para objetos de verdade. Os objetos ficam guardados em outro lugar da memória, e o array só guarda o endereço deles.

## b) Quais cuidados devo ter ao acessar um array de objetos?

**1. O `null` (o mais importante)**

Se eu tentar usar uma posição que ainda está `null`, o programa quebra com o erro `NullPointerException`:

```java
Aluno[] alunos = new Aluno[3];
System.out.println(alunos[0].getNome()); // erro!
```

Isso acontece porque a posição 0 existe, mas está vazia. Para evitar, eu preciso criar o objeto antes de usar, ou então testar antes: `if (alunos[i] != null)`.

**2. Percorrer só até onde tem objeto**

Se o array tem 30 posições mas só 5 alunos foram adicionados, não posso fazer o `for` ir até `alunos.length`, porque ele vai chegar nas posições vazias e dar erro. Por isso, na classe `Turma`, eu usei um contador (`qtdalunos`) e o `for` vai só até ele.

**3. Criar o array não cria os objetos**

Foi a pegadinha que eu tinha entendido errado no começo: `new Aluno[30]` não cria 30 alunos, só cria 30 espaços vazios. Cada aluno precisa do seu `new`.

**4. Não passar do tamanho**

Isso vale para os dois tipos de array. Num array de tamanho 3, as posições são 0, 1 e 2. Se eu tentar acessar a posição 3, dá o erro `ArrayIndexOutOfBoundsException`.

**5. Copiar o array não copia os objetos**

Como o array guarda só as referências, se eu copiar o array, os dois arrays passam a apontar para os **mesmos** objetos. Aí, se eu mudar um aluno por um array, a mudança aparece no outro também.

## Resumindo

- **O que fica em cada posição:** no array de primitivos fica o valor; no array de objetos fica a referência (o endereço) do objeto.
- **Valor inicial:** no array de primitivos é `0`, `0.0` ou `false`; no array de objetos é `null`.
- **Erro mais comum:** no array de primitivos é passar do tamanho do array; no array de objetos é o `NullPointerException`.

O principal que eu levo disso: com array de objetos, sempre conferir se a posição não está `null` antes de usar.