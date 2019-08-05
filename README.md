# Kart Reader

Uma pequena aplicação que lê os logs de uma corrida de Kart em um formato e mostra o resulta no Syslog usando Kotlin, Spring Boot para a aplicação e Spock e Groovy para testes

### Pré-requisitos

* Java Versão 1.8 ou superior

### Tecnologias usadas

* [Kotlin](https://kotlinlang.org/) 1.2.71
* [Spring Boot](https://spring.io/projects/spring-boot) 2.1.6
* [Groovy](https://groovy-lang.org/) 2.4.9
* [Spock](http://spockframework.org/) 1.1

### Build

Para executar os testes e gerar o jar, apenas executar o seguinte comando na raiz do projeto:

```bash
  ./gradlew build
```

Para rodar, apenas executar o seguinte comando(ele usa o Gradle embedded para executar):
```bash
 ./gradlew bootRun
```


### Premissas

* A ideia foi usar o mínimo de frameworks possíveis, para depender apenas dos recursos da linguagem(Kotlin e Java), usando apenas um Spring Boot para uma simples Injeção de Dependência
* Foi escolhido o Spock, pois é um framework de teste que se suporta no BDD, para usar o máximo dos testes como documentação do projeto
* O arquivo que vai ser processado é o result.txt, na raiz do projeto
* O formato do arquivo tem que ser extritamente o seguinte:
```
HH:mm:ss.SSS      COD_PILOTO – NOME_PILOTO            INT(1-4)		 MM:ss.SSS          {DOUBLE}
```
* Quando a linha não segue o padrão, ela é ignorada e o processamento do arquivo continua
* Quando a linha segue o padrão, mas há inconsistência nos dados (Data inválida, número de voltas duplicados, mais voltas do que o máximo etc), o processamento é interrompido

