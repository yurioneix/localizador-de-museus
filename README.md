# Localizador de Museus

Neste projeto foi implementado uma API cuja principal funcionalidade é facilitar a busca por museus baseada em sua localização.

<br> 

## Habilidades desenvolvidas

- Criar classes de controle e suas rotas
- Criar classes de serviço
- Utilizar injeção de dependências
- Trabalhar com exceções customizadas
- Tratar exceções da API através de gerenciadores de erros
- Implementar testes unitários para cobertura de código
- Criar uma configuração Docker para sua aplicação

<br>

## Instalação

1. Clone o repositório
  - Use o comando: `git clone git@github.com:yurioneix/localizador-de-museus.git`
  - Entre na pasta do repositório que você acabou de clonar:
    - `cd localizador-de-museus`

2. Instale as dependências
  - `mvn install -DskipTests`

<br>

## Endpoints

- <strong> POST `/museums` </strong>

<details>
  <summary>Cadastra um novo museu</summary>

  - Retorna como resposta o status 201 (CREATED) com o objeto criado no corpo da resposta. Exemplo:
    ```json
      {
        "name": "Museu Casa Memória dos Ex-Combatentes da Segunda Guerra Mundial",
        "description": "Preservação da memória dos ex-combatentes da Segunda Guerra.",
        "address": "SGAN 913, s/n, conjunto F , Asa Norte, 70790-130, Brasília, DF",
        "collectionType": "História",
        "subject": "História",
        "url": "",
        "coordinate": {
          "latitude": -15.75063,
          "longitude": -47.9001824
      }
    ```
</details>

<br>

- <strong> GET `museums/closest` </strong>

<details>
  <summary>Retorna o museu mais próximo</summary>

  - Recebe na rota os seguintes valores por _query string_:
    - `lat`: a latitude
    - `lng`: a longitude
    - `max_dist_km`: a distância máxima em quilômetros
   
  - Um exemplo de chamada:
    - URL: `http://localhost:8080/museums/closest?lat=-20.4435&lng=-54.6478&max_dist_km=10`
      ```json
          {
            "name": "Parque Estadual das Várzeas do Rio Ivinhema",
            "description": "Parque Estadual.",
            "address": "Rua Desembargador Leão Neto, s/n, Setor 3, Quadra 3, Parque dos Poderes, 79031-902, Campo Grande, MS",
            "collectionType": "Não informada",
            "subject": "Não informada",
            "url": "",
            "coordinate": {
                "latitude": -20.4439029100578,
                "longitude": -54.5663452148438
            }
          }
      ```
</details>
