# microservice-world
Project demo's a basic microservice communication using client side loadbalanced service discovery.

- Uses Eureka for service discovery
- Spring boot for microservice creation
- Uses Netflix Hystrix for Circuit breaker and fallback logic
- Uses openFeign for client side load balancing

## TODO
 - Add test cases. currently no test cases are added as its just for demo
 - use feign fallback support instead
 - converts project to be multimodule, so as to reuse dto's and api's instead of duplicating
