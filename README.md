# datingapp
Datingapp

## Roller

**Co-Founders** 

[Volkan Ulutaş](https://github.com/volkanulutas), [Onurcan Yozgat](https://github.com/onurcanyozgat)

**Server Side Developer**

[Volkan Ulutaş](https://github.com/volkanulutas), [Onurcan Yozgat](https://github.com/onurcanyozgat)

**Client Side Developer**

*Android: [Nizammeddin Tuğral](https://github.com/)*

*IOS:* **[NONE]**

**Grafik İşleri**

***[NONE]**

**Music**

*[Nizammeddin Tuğral](https://github.com/)*

## Notlar

16.04.2020 [WikiPage](https://github.com/volkanulutas/datingapp/wiki) devreye alındı. 

Not *italic* olarak belirtilen kısımlar taslak halindedir, geliştirme aşamasındadır.

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
| datingapp-login-service              | 9000            | http://localhost:8080/login    |
| datingapp-user-service               | 9100            | http://localhost:8080/user     |
| datingapp-matching-service           | 9200            | http://localhost:8080/matching |
| datingapp-demo1-service              | 9300            | http://localhost:8080/demo1    |
| datingapp-game-service               | 8083 (9400)     | http://localhost:8080/game     |
| datingapp-chat-service               | 9500            | http://localhost:8080/chat     |
| *datingapp-gem-service*              | 9600            | http://localhost:8080/gem      |
 

## Servisler Tanımlamaları ve Sorgular

### datingapp-apigateway-service


| Adı          | Tür   | Servis URL                   | Return                                                | Body         |
|:-------------| :-----|:-----------------------------| :-----------------------------------------------------|:---------------|
| HOME         | GET   | http://localhost:8080/       |  Working Port                                         ||

### datingapp-config-service

| Adı          | Tür   | Servis URL                   | Return                                                | Body         |
|:-------------| :-----|:-----------------------------| :-----------------------------------------------------|:---------------|
| HOME         | GET   | http://localhost:8888/       | Working Port                                          ||

### datingapp-login-service

| Adı          | Tür   | Servis URL                           | Return                                                | Body           |
|:-------------| :-----|:-------------------------------------| :-----------------------------------------------------|:---------------|
| HOME         | GET   | http://localhost:8080/login           | Auth Token                                            | ```json {"username":"admin","password":"admin"} ```|

### datingapp-user-service

| Adı          | Tür   | Servis URL                           | Return                                                | Body             |
|:-------------| :------|:-------------------------------------| :----------------------------------------------------|:-----------------|
| HOME         | GET    | http://localhost:8080/user           | Working Port                                         ||
| REGISTER     | POST   | http://localhost:8080/user/register  | UserDto*                                             | UserDto*         |
| FIND USER    | GET    | http://localhost:8080/user/findUserByUsername | UserDto*                                    | username(String) |
| DELETE USER  | DELETE | http://localhost:8080/user/delete    | boolean                                              | username(String) |
| LIST USER    | GET    | http://localhost:8080/user/list      | List<UserDto>*                                       | username(String) |
| *FORGET PASSWORD* | POST | http://localhost:8080/user/forgetPassword| url(String- mail send)                          |username(String)  |

### datingapp-matching-service

| Adı          | Tür   | Servis URL                                | Return                                               | Body           |
|:-------------| :-----|:------------------------------------------| :----------------------------------------------------|:---------------|
| HOME         | GET   | http://localhost:8080/matching            | Working Port                                         ||
| MATCH USERS  | POST  | http://localhost:8080/matching/match      | Boolean                                             |username(String), username(String)|
| MATCH LIST   | GET   | http://localhost:8080/matching/matchList  | MatchUserDto*                                         |username(String) |
| DELETE MATCH | GET   | http://localhost:8080/matching/deleteMatch | boolean                                             |username(String), matchUsername(String) |
| PREMATCH LIST| GET   | http://localhost:8080/matching/pre/matchList  | AvailableUserDto*                                | username(String)|

### datingapp-demo1-service

| Adı          | Tür   | Servis URL                      | Return                                                | Body         |
|:-------------| :-----|:--------------------------------| :-----------------------------------------------------|:---------------|
| HOME         | GET   | http://localhost:8080/demo1     | Working Port                                          ||

### datingapp-chat-service

| Adı          | Tür   | Servis URL                      | Return                                                | Body         |
|:-------------| :-----|:--------------------------------| :-----------------------------------------------------|:---------------|
| *HOME*         | GET   | http://localhost:8080/chat      | Working Port                                          ||
| CHAT HISTORY   | GET   | http://localhost:8080/chat/chatHistory | ChatMessageDto*                                 | username (String), otherUsername(String)|
| FRIEND LIST    | GET   | http://localhost:8080/chat/chatHistory | List<String> otherUsernameList                  | username (String) |

### datingapp-game-service

| Adı          | Tür   | Servis URL                                            | Return                                                | Body         |
|:-------------| :-----|:------------------------------------------------------| :-----------------------------------------------------|:---------------|
| HOME         | GET   | http://localhost:8080/game                            | Working Port                                          ||
| QUESTION ADD | POST  | http://localhost:8080/game/fastQuestion/saveAll       | |```json {"username":"admin","password":"admin"} ```|
| BEGIN GAMESESSION | POST   | http://localhost:8080/game/fastGame/initiateGameSession || ```json { "gameType": "FAST_DATE", "firstParticipant": { "id":"test_user_id_1", "nickname": "ManOfHonor", "featureList": null }, "secondParticipant": { "id":"test_user_id_2", "nickname": "OtherNickname", "featureList": null } }``` |
| ANSWER QUESTION | POST   | http://localhost:8080/game/fastGame/saveAnswer || ```json {"gameSessionId": "5e8b48b3d9e2a2097c111621", "questionId": "5e8b0678d9e2a221c0927174", "participantId": "test_user_id_1", "content": "Soru cevaplandı." }``` |

### datingapp-gem-service 
Oyundaki para/coin yönetiminin yapıldığı servis. 

**UserDto (*) Örneği** 
```json
{
    "username":"ahmet",

    "password":"12345",

    "name":"Ahmet",

    "surname":"Testçioğlu",

    "birthDate":"1",

    "birthPlace":"Adıyaman",
    
    "userRole": "USER",

    "loginAttempt":"0",

    "status": "ONLINE",

    "gender": "MALE",
        "userPreference": {
    	
    "placeRange": 5,

    "minimumAge": 20,

    "maximumAge": 30,

    "gender": "FEMALE"
    	
    }
}
```       
**MatchUserDto (*) **
```json
{
    "id": "5e9995ece98881338040b2db",
    "user": {
        "id": "5e9897bee98881b50543fb74",
        "username": "volkan",
        "name": null,
        "surname": null,
        "birthDate": 0,
        "birthPlace": null,
        "status": null,
        "gender": null
    },
    "matchingList": [
        {
            "id": "5e9897bee98881b50543fb75",
            "username": "onurcan",
            "name": null,
            "surname": null,
            "birthDate": 0,
            "birthPlace": null,
            "status": null,
            "gender": null
        }
    ]
}
```  

**AvailableUserDto (*) **
```json
{
    "id": null,
    "user": {
        "id": null,
        "username": "volkan",
        "name": null,
        "surname": null,
        "birthDate": 0,
        "birthPlace": null,
        "status": null,
        "gender": null
    },
    "matchingList": [
        {
            "id": null,
            "username": "elif",
            "name": "elif",
            "surname": "Testçioğlu",
            "birthDate": 1,
            "birthPlace": "Adıyaman",
            "status": "ONLINE",
            "gender": "FEMALE"
        }
    ]
}
```  

**ChatMessageDto (*) **
```json

```  
