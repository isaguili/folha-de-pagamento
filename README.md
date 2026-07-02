# Folha de Pagamento
![Status](https://img.shields.io/badge/status-concluído-brightgreen)

Projeto desenvolvido como avaliação da disciplina de **Algoritmos e Programação** do curso de **Análise e Desenvolvimento de Sistemas**, com o objetivo de aplicar conceitos fundamentais de programação e modelagem de sistemas utilizando Java.

Além dos requisitos acadêmicos propostos, o projeto também incorporou estudos independentes sobre **JavaFX**, explorando o desenvolvimento de interfaces gráficas desktop e interação entre componentes visuais e regras de negócio.

Durante o desenvolvimento foram trabalhados conceitos relacionados à **lógica de programação, Programação Orientada a Objetos, estruturação de algoritmos, modelagem de classes e construção de interfaces gráficas**.

##  Funcionalidades

-  Cadastro de funcionários.
-  Suporte a diferentes tipos de funcionários.
-  Cálculo automático da folha de pagamento.
-  Geração automática de matrícula dos funcionários.
-  Listagem dos funcionários cadastrados.
-  Aplicação de regras de negócio específicas para cada categoria de funcionário.

## Tecnologias

<p align="left">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/JavaFX-0D96F6?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/POO-1E90FF?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white"/>
</p>

## Principais aprendizados

Durante o desenvolvimento deste projeto foram praticados os seguintes conceitos:

- Programação Orientada a Objetos (POO).
- Herança e polimorfismo.
- Encapsulamento.
- Organização do projeto em camadas.
- Separação entre regras de negócio e interface.
- Estruturação de aplicações Java utilizando JavaFX.
- Manipulação de coleções para gerenciamento dos funcionários.

##  Estrutura do Projeto

```text
folha-de-pagamento/
├── src/
│   ├── java/
│   │   └── com/template/
│   │       ├── model/             # Classes de domínio
│   │       ├── repository/        # Armazenamento dos funcionários
│   │       ├── service/           # Regras de negócio
│   │       └── view/              # Interface da aplicação
│   │           ├── Main.java
│   │           └── MainController.java
│   └── resources/                 # Recursos da aplicação
├── .gitignore
└── README.md
```

---

## Arquitetura

A aplicação foi organizada em camadas, seguindo o princípio da **separação de responsabilidades**.

- **model:** representa as entidades da aplicação e suas especializações.
- **repository:** responsável pelo gerenciamento dos funcionários cadastrados.
- **service:** implementa as regras de negócio, como cálculo da folha de pagamento e geração de matrícula.
- **view:** contém a interface da aplicação desenvolvida com JavaFX.
- **resources:** armazena os recursos utilizados pela interface.

## Como executar

1. Clone o repositório:

```bash
git clone https://github.com/isaguili/folha-de-pagamento.git
```

2. Acesse a pasta do projeto:

```bash
cd folha-de-pagamento
```

3. Abra o projeto em uma IDE compatível
> Projeto desenvolvido no IntelliJ IDEA

4. Execute a aplicação:

> Execute a classe:

```text
Main.java
```

A aplicação JavaFX será iniciada automaticamente.

> **Pré-requisitos**
>
> - Java JDK 21 ou superior.
> - JavaFX SDK configurado na IDE.
