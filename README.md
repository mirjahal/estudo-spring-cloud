# Estudo Spring Cloud #

### Stack ###

###### Config Server ######
 - Criar container RabbitMQ: sudo docker run --name rabbitmq -p 5672:5672 -d rabbitmq:3
 - Refresh das configurações dos clientes através do RabbitMQ;
 - Requisição para o Config Server, para o mesmo transmitir uma mensagem para RabbitMQ: curl -v -X POST "http://localhost:9090/monitor" -H "Content-Type: application/json" -H "X-Event-Key: repo:push" -H "X-UUID: webhook-uuid" -d '{"push": {"changes": []} }'

###### Eureka Server ######

###### Zuul Server ######
