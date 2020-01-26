# SubscriptionService
IBAN Subscription Service

The following diagrams represents the Target State Architecture and the Minimum Viable Product with a decoupled approach through containerization and MoM (Message Oriented Middleware).

Among other, you cand find the following features:
```bash
•	HTTPS Protocol;
•	SSL/TLS (Self-Signed Certificate);
•	Basic Authentication;
•	Load Balancing;
```
The Target State Architecture represents one possible approach for the challenge. Due to some time limitation, I decided to implement a simpler version (MVP) that also fullfils the major requirements.


![alt text](https://i.ibb.co/Mf0BMgj/Target-State-Architacture.png)

![alt text](https://i.ibb.co/bvntD1y/MVP.png)

## 1.0.	DOCKER REQUIREMENTS

Network

```bash
sudo docker network create subscription-amqp
```

RabbitMQ

```bash
sudo docker run --network subscription-amqp -d --hostname rabbit --name rabbit -p 8080:15672 -p 5672:5672 -p 25676:25676 rabbitmq:3-management
```

## 2.0.	BUILD & RUN

Subscription Service (https://github.com/andrefctavares/SubscriptionService.git)

```bash
sudo mvn package
sudo docker build -t sub-service .
sudo docker run --network subscription-amqp -p8443:8443 sub-service
sudo docker start CONTAINERID
```

Email Service (https://github.com/andrefctavares/EmailService.git)

```bash
sudo mvn package
sudo docker build -t email-service .
sudo docker run --network subscription-amqp -p8085:8085 email-service
sudo docker start CONTAINERID
```
