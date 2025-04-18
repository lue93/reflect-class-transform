# ReflectionClassMapper Library

**ReflectionClassMapper** é uma biblioteca Java que facilita a conversão de objetos entre entidades e DTOs utilizando a API de reflexão do Java. Essa abordagem oferece flexibilidade e automação ao lidar com diferentes classes.

---

## 📦 Importando no projeto

### Maven
Adicione a dependência ao seu arquivo `pom.xml`:
```xml
<dependency>
    <groupId>br.com.ungaratto93.lib</groupId>
    <artifactId>reflection-mapper</artifactId>
    <version>1.0</version>
</dependency>
```

### 🚀 Como usar a biblioteca
Exemplo básico
```java

public class Main {
    public static void main(String[] args) {
        // Instâncias de exemplo
        Contact contact = new Contact();
        contact.setName("John Doe");
        contact.setEmail("john.doe@example.com");

        // Converter de entidade para DTO
        ContactDTO contactDTO = ReflectionMapper.map(contact, ContactDTO.class);

        System.out.println(contactDTO.getName());
        System.out.println(contactDTO.getEmail());
    }
}
```
Detalhes:
- O método ReflectionMapper.map(Object source, Class<T> targetClass) usa reflexão para copiar os valores dos campos da classe origem para a classe destino.
- Certifique-se de que as classes possuem nomes de campo correspondentes e construtores acessíveis.


## ⚠️ Alerta
- Desempenho:
  O uso de reflexão pode impactar negativamente o desempenho em cenários que envolvem grande volume de dados ou alta frequência de chamadas. Para projetos de alta performance, considere usar mapeamento baseado em métodos explícitos (getters e setters).
- Segurança:
  A reflexão pode acessar membros privados de classes, violando encapsulamento e podendo criar riscos em ambientes sensíveis. Use a biblioteca com critérios e em cenários controlados.

## Comparação acesso direto vs reflexão

| **Aspecto**               | **Uso de Getters e Setters**       | **Uso de Reflexão**               |
|---------------------------|-----------------------------------|-----------------------------------|
| **Tempo de Execução**     | Geralmente mais rápido, pois evita verificações adicionais e processamento de metadados. | Mais lento devido ao overhead da API de reflexão. |
| **Overhead**              | Baixo, direto ao ponto.           | Alto, pois acessa metadados e executa verificações extras. |
| **Uso de Recursos**       | Eficiente no uso de CPU e memória.| Pode consumir mais CPU e memória devido ao processamento adicional. |
| **Escalabilidade**        | Melhor para cenários de alto volume de dados. | Pode não ser ideal para grandes volumes de dados devido ao impacto na performance. |

## 🛠 Contribuições 
Sinta-se à vontade para contribuir com melhorias ou novas funcionalidades para a biblioteca. Abra uma issue ou envie um pull request!

