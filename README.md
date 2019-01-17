# zemberek-rest
Sprint Boot Rest Api application for NLP library Zemberek


  Parent Project is : https://github.com/ahmetaa/zemberek-nlp
  
  
## How to build?

```
./mvnw clean package -DskipTests=true  
```

## How to run?

1. Prequisites & Dependencies
  * Java 1.8
 
###### Run 

```
java -jar zemberekrest<VERSION>.jar
```

###### Run with properties file

```
java -jar zemberekrest<VERSION>.jar --spring.config.location=application.yml
```

###### Run in background and direct log to file

```
nohup java -jar zemberekrest<VERSION>.jar &
```

## Service Documentation

Swagger Rest Documentation is bundled in artifacts. Open web address with your browser:

http://`<service-ip>`:`<service-port>`/swagger-ui.html