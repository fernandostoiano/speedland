# Speedland

**Speedland** se trata de uma corrida de kart, onde a aplicação se baseia em uma entrada de um arquivo de log txt, através desse arquivo **speedland** consegue entender tudo que aconteceu durante a prova. Trazendo como resultado as posições de cada piloto, quantas voltas completadas, qual a melhor volta de cada piloto e da prova, coisas desse tipo.

# Pré-requisitos
- Java SDK 11
- Maven 3.3.9
- Postman

# Como Instalar?

Baixe o repositório de **speedland** aqui no github na sua máquina e em seguida siga os passos a baixo:

- Executar o seguinte comando do maven na raiz do projeto
> mvn clean install

- Em seguida execute o comando a baixo para subir a aplicação com o tomcat na porta 8080 da sua maquina
> java -jar target/speedland.jar

# Como Iniciar a Corrida?

Se você seguiu os passos anteriores corretamente nesse momento a aplicação já deve estar rodando.

O que vamos fazer agora? Siga os seguintes passos:

> a corrida é iniciada a partir de uma chamada Http POST na URL localhost:8080/api/speedland/start_race

Quando executar esta URL você vai obter um json de resposta representando os resultados da corrida. Isso porque existe um
arquivo de LOG padrão já na raiz do projeto. O nome deste arquivo é o speedland.txt.

Caso queria executar a corrida a partir de um outra arquivo qualquer, basta te-lo em qualquer diretório da sua maquina e executar a URL anterior da seguinte forma
> exemplo : localhost:8080/api/speedland/start_race?filePath=/Users/fernandostoianogonzalez/dev/gympass/speed.txt
