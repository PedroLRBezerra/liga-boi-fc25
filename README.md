# 🐮 LIGA BOI FC - Gerenciador de Liga EA FC 25

Este projeto é uma aplicação web voltada para o gerenciamento de uma liga de EA FC 25 (antigo FIFA), permitindo o cadastro de partidas, acompanhamento de resultados, pontuação e muito mais!

## ⚙️ Configuração do Ambiente

Antes de rodar o projeto localmente, é necessário configurar as variáveis de ambiente. Para isso:

### 1. Crie um arquivo `.env`

Na raiz do projeto, crie um arquivo chamado `.env` com os parâmetros necessários. Exemplo:

```
PORT=8080
DB_URL=jdbc:mysql://localhost:3306/ligaboifc
DB_USER=seu_usuario
DB_PASSWORD=sua_senha
JWT_SECRET=sua_chave_secreta
```

> Substitua os valores acima conforme a sua configuração local.

---

## 🚀 Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/ligaboifc.git
   ```

2. Entre na pasta do projeto:
   ```bash
   cd ligaboifc
   ```

3. Configure o `.env` conforme acima.

4. Execute a aplicação:
    - Se for um projeto **Spring Boot**:
      ```bash
      ./mvnw spring-boot:run
      ```

    - Ou abra na sua IDE e execute a classe principal.

---

## 🎮 Sobre o Projeto

O **LIGA BOI FC** tem como objetivo facilitar a organização de uma liga entre amigos no EA FC 25. A aplicação oferece:

### 📌 Funcionalidades

- 🗕️ **Cadastro de Confrontos**  
  Os jogadores podem registrar partidas realizadas, incluindo:
    - Times utilizados
    - Gols marcados
    - Jogadores envolvidos

- 📊 **Sistema de Pontuação e Classificação**  
  A tela inicial exibe a tabela com os pontos acumulados por cada jogador.

- 🔺 **Últimas Partidas**  
  Também na tela inicial, é possível ver um histórico com os últimos confrontos registrados.

---

## 📷 Layout (Opcional)

Você pode adicionar aqui imagens de tela do projeto (use markdown assim quando quiser):

```markdown
![Tela inicial](docs/home-preview.png)
```

---

## 📄 Licença

Este projeto é open source, sinta-se à vontade para colaborar!

---

## 🤝 Contribuição

Quer contribuir com o projeto? Crie um fork, implemente melhorias e envie um pull request! 🚀

