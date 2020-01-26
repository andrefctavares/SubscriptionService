# SubscriptionService
IBAN Subscription Service


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
