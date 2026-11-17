# Relatório – Aula 10 DevOps (GitHub Actions + Maven + JUnit 5)

## Estrutura do repositório

```
Aula10Devops/
├── .github/workflows/testes.yml        -> pipeline do GitHub Actions
├── exercicio1-imc/
│   ├── pom.xml
│   └── src/
│       ├── main/java/com/senai/CalcIMC.java
│       └── test/java/com/senai/CalcIMCTest.java
└── exercicio2-potencia/
    ├── pom.xml
    └── src/
        ├── main/java/com/senai/CalcPotencia.java
        └── test/java/com/senai/CalcPotenciaTest.java
```

O workflow usa uma `matrix` para executar `mvn test` nos dois projetos a cada
push, pull request ou execução manual (`workflow_dispatch`).

---

## Exercício 1 – Cálculo do IMC

Fórmula: `IMC = peso / (altura * altura)`

```java
public double calcularIMC(double peso, double altura) {
    return peso / (altura * altura);
}
```

| Teste | Entrada | Esperado |
|---|---|---|
| testarIMCPesoNormal | 70 kg, 1,75 m | 22,86 |
| testarIMCSobrepeso | 90 kg, 1,80 m | 27,78 |

Como o resultado é `double`, usamos `assertEquals(esperado, resultado, delta)`
com tolerância de 0,01.

**Print – testes locais (`mvn test`):**

> _inserir print_

**Print – execução no GitHub Actions:**

> _inserir print_

---

## Exercício 2 – Potência elétrica

Fórmula: `P = V x I`

```java
public double calcularPotencia(double tensao, double corrente) {
    return tensao * corrente;
}
```

| Teste | Entrada | Esperado |
|---|---|---|
| testarPotencia220V | 220 V, 5 A | 1100 W |
| testarPotencia127V | 127 V, 2,5 A | 317,5 W |

**Print – testes locais (`mvn test`):**

> _inserir print_

**Print – execução no GitHub Actions:**

> _inserir print_

---

## Perguntas

**a) Qual comando para limpar o build do projeto?**

`mvn clean` – apaga a pasta `target/`, removendo as classes compiladas e os
pacotes gerados.

**b) Qual comando para executar o teste com Maven?**

`mvn test` – compila o projeto e executa os testes de `src/test/java` com o
plugin Surefire. Também é comum usar `mvn clean test` para limpar antes de testar.

**c) Por que os testes unitários devem ser utilizados antes dos testes E2E?**

- São rápidos (milissegundos) e baratos, então dão retorno imediato a cada push.
- Testam uma unidade isolada (um método ou uma classe); quando falham, o erro é
  fácil de localizar.
- Não dependem de banco de dados, rede, navegador ou ambiente implantado, por
  isso são estáveis.
- Seguindo a pirâmide de testes, são a base: se a lógica básica já está errada,
  não faz sentido gastar tempo e recursos subindo o sistema inteiro para os
  testes E2E, que são lentos, caros e mais frágeis.

**d) Qual a diferença de um projeto Maven e um projeto Spring Boot?**

- **Maven** é uma ferramenta de build e de gerenciamento de dependências. Ela
  define a estrutura de pastas (`src/main`, `src/test`), o `pom.xml` e o ciclo
  de vida (`compile`, `test`, `package`…). Um projeto Maven pode ser qualquer
  aplicação Java, como a calculadora desta aula.
- **Spring Boot** é um framework para criar aplicações (APIs REST, web,
  microsserviços). Ele traz configuração automática, servidor embutido (Tomcat)
  e "starters" de dependências. Um projeto Spring Boot normalmente **usa** o
  Maven (ou o Gradle) para o build, com o `spring-boot-starter-parent` no
  `pom.xml`.
- Em resumo: o Maven é *como* o projeto é construído; o Spring Boot é *o que* a
  aplicação usa para funcionar.
