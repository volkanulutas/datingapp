# datingapp
Datingapp

# Gereksinimler
## Lombok 
Lombok Plugin'ini IDEA'ya ekleyiniz. 

# Servisler

## Portlar

| Servis                               | Port            | URL (Api Gateway)              |
| :------------                        |:----------------| :------------------------------|
| datingapp-service-discovery-service  | 8761            | http://localhost:8761          |
| datingapp-apigateway-service         | 8080            | http://localhost:8080          |
| datingapp-auth-service               | 9000            | http://localhost:8080/auth     |
| datingapp-matching-service           | 9100            | http://localhost:8080/matching |
| datingapp-demo1-service              | 9200            | http://localhost:8080/demo1    |
| datingapp-game-service               | 8083 (9300)     | http://localhost:8080/game     |
| datingapp-chat-service               | 9400            | http://localhost:8080/chat     |

## Servisler Tanımlamaları ve Sorgular

### datingapp-apigateway-service


| Adı          | Tür   | Servis URL                   | Body                                                  | Return         |
|:-------------| :-----|:-----------------------------| :-----------------------------------------------------|:---------------|
| LOGIN        | POST  | http://localhost:8080/auth   |  ```json {"username":"admin","password":"admin"} ```  |                |


### datingapp-auth-service

| Adı          | Tür   | Servis URL                   | Body                                                  | Return         |
|:-------------| :-----|:-----------------------------| :-----------------------------------------------------|:---------------|
| LOGIN        | POST  | http://localhost:8080/auth   |  ```json {"username":"admin","password":"admin"} ```  |                |

### datingapp-matching-service

| Adı          | Tür   | Servis URL                   | Body                                                  | Return         |
|:-------------| :-----|:-----------------------------| :-----------------------------------------------------|:---------------|
| LOGIN        | POST  | http://localhost:8080/auth   |  ```json {"username":"admin","password":"admin"} ```  |                |

### datingapp-demo1-service

| Adı          | Tür   | Servis URL                   | Body                                                  | Return         |
|:-------------| :-----|:-----------------------------| :-----------------------------------------------------|:---------------|
| LOGIN        | POST  | http://localhost:8080/auth   |  ```json {"username":"admin","password":"admin"} ```  |                |

### datingapp-game-service

| Adı          | Tür   | Servis URL                   | Body                                                  | Return         |
|:-------------| :-----|:-----------------------------| :-----------------------------------------------------|:---------------|
| LOGIN        | POST  | http://localhost:8080/auth   |  ```json {"username":"admin","password":"admin"} ```  |                |

### datingapp-chat-service

| Adı          | Tür   | Servis URL                   | Body                                                  | Return         |
|:-------------| :-----|:-----------------------------| :-----------------------------------------------------|:---------------|
| LOGIN        | POST  | http://localhost:8080/auth   |  ```json {"username":"admin","password":"admin"} ```  |                |
                
