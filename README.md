# datingapp
Datingapp

16.04.2020 [WikiPage](https://github.com/volkanulutas/datingapp/wiki) devreye alındı. 

# Gereksinimler

## RabbitMQ

**MacOs**

**Kurulum:**

`$ brew update`

`$ brew install rabbitmq`

`$ export PATH=$PATH:/usr/local/opt/rabbitmq/sbin`

`$ rabbitmq-server`

**Açma:**

`$ export PATH=$PATH:/usr/local/opt/rabbitmq/sbin`

`$ rabbitmq-server`

Not: Daha sonra "Açma" adının her seferinde yapılmasından kurtulmak için servis haline getirilecektir.

## MongoDB

**MacOS**

[Referans - MacOS MongoDB Community Kurulumu](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-os-x/)

**Windows** 

[Referans - Windows MongoDB Community Kurulumu](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/)

## Lombok 

Lombok Plugin'ini IDEA'ya ekleyiniz. @Getter ve @Setter @Slf4j gibi kullanımları kodu daha temiz hale getirmektedir.

[Referans - Lombok Kurulumu ve Kullanımı](https://medium.com/kodgemisi/project-lombok-6d2490df8adf)

[Referans - Lombok Kurulumu ve Kullanımı 2](http://ilkaygunel.com/blog/2016/lokbok-nedir-ornek-kod/)

# Servisler

## Portlar

| Servis                               | Port            | URL (Api Gateway)              |
| :------------                        |:----------------| :------------------------------|
| datingapp-service-discovery-service  | 8761            | http://localhost:8761          |
| datingapp-apigateway-service         | 8080            | http://localhost:8080          |
| datingapp-congig-service             | 8888            | http://localhost:8888          |
| datingapp-auth-service               | 9000            | http://localhost:8080/auth     |
| datingapp-matching-service           | 9100            | http://localhost:8080/matching |
| datingapp-demo1-service              | 9200            | http://localhost:8080/demo1    |
| datingapp-game-service               | 8083 (9300)     | http://localhost:8080/game     |
| datingapp-chat-service               | 9400            | http://localhost:8080/chat     |

## Servisler Tanımlamaları ve Sorgular

### datingapp-apigateway-service


| Adı          | Tür   | Servis URL                   | Body                                                  | Return         |
|:-------------| :-----|:-----------------------------| :-----------------------------------------------------|:---------------|
| HOME         | GET   | http://localhost:8080/       |                                                       | Working Port   |

### datingapp-config-service

| Adı          | Tür   | Servis URL                   | Body                                                  | Return         |
|:-------------| :-----|:-----------------------------| :-----------------------------------------------------|:---------------|
| HOME         | GET   | http://localhost:8888/       |                                                       | Working Port   |

### datingapp-auth-service

| Adı          | Tür   | Servis URL                   | Body                                                  | Return         |
|:-------------| :-----|:-----------------------------| :-----------------------------------------------------|:---------------|
| HOME         | GET   | http://localhost:8080/auth   |                                                       | Working Port   |
| LOGIN        | POST  | http://localhost:8080/auth   |  ```json {"username":"admin","password":"admin"} ```  | Auth Token     |

### datingapp-matching-service

| Adı          | Tür   | Servis URL                       | Body                                                  | Return         |
|:-------------| :-----|:-----------------------------    | :-----------------------------------------------------|:---------------|
| HOME         | GET   | http://localhost:8080/matching   |                                                       | Working Port   |

### datingapp-demo1-service

| Adı          | Tür   | Servis URL                   | Body                                                  | Return         |
|:-------------| :-----|:-----------------------------| :-----------------------------------------------------|:---------------|
| HOME         | GET   | http://localhost:8080/demo1  |                                                       | Working Port   |

### datingapp-game-service

| Adı          | Tür   | Servis URL                   | Body                                                  | Return         |
|:-------------| :-----|:-----------------------------| :-----------------------------------------------------|:---------------|
| HOME         | GET   | http://localhost:8080/game   |                                                       | Working Port   |
| HOME         | GET   | http://localhost:8080/gamefastQuestion/saveAll    | ```
 [ { "questionContent": "Soru-1" }, { "questionContent": "Soru-2" }, { "questionContent": "Soru-3" }, { "questionContent": "Soru-4" }, { "questionContent": "Soru-5" } ] ```   | Working Port   |
| HOME         | GET   | http://localhost:8080/game   |                                                       | Working Port   |



### datingapp-chat-service

| Adı          | Tür   | Servis URL                   | Body                                                  | Return         |
|:-------------| :-----|:-----------------------------| :-----------------------------------------------------|:---------------|
| HOME         | GET   | http://localhost:8080/chat   |                                                       | Working Port   |
                
