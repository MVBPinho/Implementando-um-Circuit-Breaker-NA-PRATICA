# ⚡ Circuit Breaker e Fallback

Este projeto utiliza o padrão de resiliência **Circuit Breaker** com **Fallback** para aumentar a robustez e estabilidade da aplicação em ambientes distribuídos.

---

## 🎯 Objetivo

O objetivo do **Circuit Breaker** é proteger o sistema de falhas em cascata, evitando chamadas repetidas para serviços instáveis ou fora do ar. Quando uma falha é detectada, o circuito é "aberto" e as chamadas futuras são bloqueadas temporariamente, permitindo que o sistema se recupere.

---

## 🧱 O que é Circuit Breaker?

É um mecanismo que atua como um **disjuntor**, monitorando falhas e controlando o tráfego para serviços externos.

| Estado        | Descrição                                               |
|---------------|----------------------------------------------------------|
| 🔒 **Closed**    | Todas as chamadas fluem normalmente                     |
| 🔓 **Open**      | Chamadas são bloqueadas após muitas falhas              |
| ⚠️ **Half-Open** | Permite algumas chamadas para verificar recuperação     |

---

## 🔁 O que é Fallback?

O **Fallback** é um plano de contingência. Ele define uma ação alternativa que será executada **quando o serviço original falhar** ou estiver indisponível.

### 📌 Exemplo:
Se uma chamada ao serviço de CEP falhar:
```json
{
  "cep": "38400000",
  "mensagem": "Endereço temporariamente indisponível"
}
```


## 📚 Comandos MongoDB para Este Curso
```bash
## 🐳 Acesse o Docker
docker ps
docker exec -it mongodb mongosh -u root -p example
show collections
use circuit-breaker
```

## 🚀 Simulando Aplicação de CEP com Wiremock
Acesse a pasta `mocks` e execute o comando abaixo para iniciar o Wiremock:
```bash
## Executar o Wiremock para simular uma aplicação de comentários
java -jar .\wiremock-standalone-3.12.1.jar --port 8082

## 🔎 Exemplos de Requisições
curl --location 'http://localhost:8082/comments/67f20cc42174de3980e0b1f6'
```

## 🔶 Requisições via Postman
```bash

## insertPublication
curl --location 'http://localhost:8080/api/v1/publications' \
--header 'Content-Type: application/json' \
--data '{
    "title" : "Dev de olho",
    "imageUrl" : "http://localhost:8080/image.png",
    "text" : "Onde você encontra tudo sobre programação."
}'

## findAllPublication
curl --location 'http://localhost:8080/api/v1/publications'

## findByIdPublication
curl --location 'http://localhost:8080/api/v1/publications/67f20cc42174de3980e0b1f6'

```