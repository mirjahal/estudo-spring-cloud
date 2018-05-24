# Estudo Spring Cloud #

### Stack ###

* Config Server
  * Refresh das configurações dos clientes através do RabbitMQ;
  * Requisição para o Config Server, para o mesmo transmitir uma mensagem para RabbitMQ: curl -v -X POST "http://localhost:9090/monitor" -H "Content-Type: application/json" -H "X-Event-Key: repo:push" -H "X-UUID: webhook-uuid" -d '{"push": {"changes": []} }'

* Eureka Server
