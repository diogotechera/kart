# Kart Reader

Uma pequena aplicação que lê os logs de uma corrida de Kart em um formato e mostra o resulta no Syslog usando Kotlin, Spring Boot para a aplicação e Spock e Groovy para testes

### Pré-requisitos

* Java Versão 1.8 ou superior

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
* O formato do arquivo tem que ser extritamente o seguinte:
```
HH:mm:ss.SSS      COD_PILOTO – NOME_PILOTO            INT(1-4)		 MM:ss.SSS          {DOUBLE}
```
* O arquivo que vai ser processado é o result.txt, na raiz do projeto
