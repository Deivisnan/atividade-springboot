# Atividade Spring Boot

Atividade de Desenvolvimento de Sistemas utilizando Spring Boot.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [O que é Spring Boot?](#o-que-é-spring-boot)
- [Como o Spring Boot Funciona](#como-o-spring-boot-funciona)
- [Estrutura de um Projeto Spring Boot](#estrutura-de-um-projeto-spring-boot)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Como Executar](#como-executar)
- [Conceitos Fundamentais](#conceitos-fundamentais)
- [Exemplos Práticos](#exemplos-práticos)
- [Recursos Adicionais](#recursos-adicionais)

## 🎯 Sobre o Projeto

Este é um projeto educacional desenvolvido para a disciplina de Desenvolvimento de Sistemas, com foco em aprendizado e prática do framework Spring Boot para construção de aplicações Java modernas.

## 🚀 O que é Spring Boot?

Spring Boot é um framework Java baseado no Spring Framework que simplifica drasticamente a criação de aplicações Java standalone e prontas para produção. Ele foi criado para facilitar o desenvolvimento, eliminando grande parte da configuração manual necessária em projetos Spring tradicionais.

### Principais Características:

- **Auto-configuração**: Configura automaticamente sua aplicação com base nas dependências presentes no classpath
- **Servidor Embutido**: Inclui servidores como Tomcat, Jetty ou Undertow, eliminando a necessidade de implantação em servidores externos
- **Starter Dependencies**: Fornece dependências pré-configuradas para facilitar a adição de funcionalidades
- **Production-Ready**: Inclui recursos como métricas, health checks e configurações externalizadas
- **Sem Geração de Código**: Não gera código e não requer configuração XML

## ⚙️ Como o Spring Boot Funciona

### 1. Inicialização da Aplicação

Quando você executa uma aplicação Spring Boot, o processo funciona da seguinte forma:

```
Classe Main (@SpringBootApplication)
    ↓
SpringApplication.run()
    ↓
Configuração Automática
    ↓
Criação do Contexto Spring
    ↓
Inicialização de Beans
    ↓
Servidor Embutido Inicia
    ↓
Aplicação Pronta!
```

### 2. Anotação @SpringBootApplication

Esta anotação é uma combinação de três anotações importantes:

- **@Configuration**: Indica que a classe contém definições de beans
- **@EnableAutoConfiguration**: Habilita a configuração automática do Spring Boot
- **@ComponentScan**: Procura por componentes, configurações e serviços no pacote atual e subpacotes

### 3. Injeção de Dependências

O Spring Boot utiliza o conceito de **Inversão de Controle (IoC)** e **Injeção de Dependências (DI)**:

- O container Spring gerencia o ciclo de vida dos objetos (beans)
- As dependências são injetadas automaticamente onde necessário
- Isso promove código desacoplado e testável

## 📁 Estrutura de um Projeto Spring Boot

Uma estrutura típica de projeto Spring Boot segue este padrão:

```
atividade-springboot/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/exemplo/projeto/
│   │   │       ├── Application.java          # Classe principal
│   │   │       ├── controller/               # Controllers REST
│   │   │       │   └── ExemploController.java
│   │   │       ├── model/                    # Entidades/Modelos
│   │   │       │   └── Exemplo.java
│   │   │       ├── repository/               # Repositórios (acesso a dados)
│   │   │       │   └── ExemploRepository.java
│   │   │       └── service/                  # Lógica de negócio
│   │   │           └── ExemploService.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties        # Configurações
│   │       ├── static/                       # Arquivos estáticos (CSS, JS)
│   │       └── templates/                    # Templates (Thymeleaf, etc)
│   │
│   └── test/
│       └── java/                             # Testes unitários e integração
│
├── pom.xml                                   # Dependências Maven
└── README.md
```

### Explicação das Camadas:

- **Controller**: Recebe requisições HTTP e retorna respostas
- **Service**: Contém a lógica de negócio da aplicação
- **Repository**: Responsável pela persistência de dados
- **Model**: Define as entidades e objetos de domínio

## 🔧 Configuração do Ambiente

### Pré-requisitos:

1. **Java Development Kit (JDK) 17 ou superior**
   ```bash
   # Verificar versão do Java
   java -version
   ```

2. **Maven 3.6+ ou Gradle 7+**
   ```bash
   # Verificar versão do Maven
   mvn -version
   ```

3. **IDE** (opcional, mas recomendado):
   - IntelliJ IDEA
   - Eclipse
   - Visual Studio Code com extensão Java

### Criando um Projeto Spring Boot:

Existem várias formas de criar um projeto:

1. **Spring Initializr** (https://start.spring.io/)
   - Interface web para gerar projetos
   - Escolha dependências, versão do Java, tipo de build (Maven/Gradle)

2. **Via IDE**
   - IntelliJ IDEA e Eclipse têm suporte integrado

3. **Spring Boot CLI**
   ```bash
   spring init --dependencies=web,data-jpa meu-projeto
   ```

## ▶️ Como Executar

### Usando Maven:

```bash
# Compilar o projeto
mvn clean install

# Executar a aplicação
mvn spring-boot:run
```

### Usando Gradle:

```bash
# Compilar o projeto
./gradlew build

# Executar a aplicação
./gradlew bootRun
```

### Executando o JAR:

```bash
# Gerar o JAR executável
mvn package

# Executar
java -jar target/nome-do-projeto-0.0.1-SNAPSHOT.jar
```

A aplicação geralmente inicia na porta 8080: http://localhost:8080

## 💡 Conceitos Fundamentais

### 1. REST Controllers

Controllers que expõem endpoints HTTP:

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @GetMapping
    public List<Usuario> listarTodos() {
        // Retorna lista de usuários
    }
    
    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        // Cria novo usuário
    }
    
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        // Busca usuário por ID
    }
}
```

### 2. Services

Camada de lógica de negócio:

```java
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;
    
    public Usuario salvar(Usuario usuario) {
        // Lógica de validação
        return repository.save(usuario);
    }
}
```

### 3. Repositories

Interface para acesso a dados (com Spring Data JPA):

```java
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNome(String nome);
    Optional<Usuario> findByEmail(String email);
}
```

### 4. Models/Entities

Representação de entidades do banco de dados:

```java
@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    // Getters e Setters
}
```

### 5. Configurações (application.properties)

```properties
# Configuração do servidor
server.port=8080

# Configuração do banco de dados
spring.datasource.url=jdbc:mysql://localhost:3306/meudb
spring.datasource.username=root
spring.datasource.password=senha

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 📚 Exemplos Práticos

### Exemplo 1: API REST Simples

**Controller:**
```java
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService service;
    
    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }
    
    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
        Produto novoProduto = service.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }
}
```

### Exemplo 2: Validação de Dados

```java
@Entity
public class Usuario {
    
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    
    @Email(message = "Email inválido")
    private String email;
    
    @Min(value = 18, message = "Idade mínima é 18")
    private Integer idade;
}
```

### Exemplo 3: Tratamento de Exceções

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                           .body(ex.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                           .body("Erro interno do servidor");
    }
}
```

## 🔍 Fluxo de uma Requisição

Quando um cliente faz uma requisição HTTP em uma aplicação Spring Boot:

1. **Cliente** envia requisição HTTP (ex: GET /api/usuarios)
2. **DispatcherServlet** recebe a requisição
3. **Handler Mapping** encontra o controller apropriado
4. **Controller** processa a requisição
5. **Service** executa a lógica de negócio
6. **Repository** acessa o banco de dados (se necessário)
7. **Controller** retorna a resposta
8. **DispatcherServlet** envia resposta ao cliente

```
Cliente → DispatcherServlet → Controller → Service → Repository → Database
                                    ↓                      ↓
Cliente ← JSON/XML Response ← ViewResolver ← Model ← Service
```

## 📖 Recursos Adicionais

### Documentação Oficial:
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Guides](https://spring.io/guides)
- [Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current/reference/html/)

### Tutoriais Recomendados:
- [Baeldung Spring Boot](https://www.baeldung.com/spring-boot)
- [Spring Boot Tutorial](https://www.tutorialspoint.com/spring_boot/index.htm)

### Ferramentas Úteis:
- **Spring Initializr**: https://start.spring.io/
- **Postman**: Para testar APIs REST
- **H2 Console**: Banco de dados em memória para desenvolvimento
- **Swagger/OpenAPI**: Documentação de APIs

## 🤝 Contribuindo

Este é um projeto educacional. Sugestões e melhorias são bem-vindas!

## 📝 Licença

Este projeto é para fins educacionais.

---

**Autor**: Deivisnan  
**Disciplina**: Desenvolvimento de Sistemas  
**Framework**: Spring Boot
