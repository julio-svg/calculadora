# Calcuadora AP
Microservicio realizado con Spring Boot, Swagger ControlAdvice, test de integración y test unitarios.
También se utilizan otras librerías útiles como mapstruct lombok.

En cuanto al api, se quería realizar los siguientes endpoints:

---
> GET calculator/v0/add?firstOpetator=&secondOperator=
> example : 'http://localhost:8080/calculator/v0/add?firstOpetator=1&secondOperator=1'

Parámetros:
firstOpetator. primer operador.
secondOperator segundo operador.
---
> GET calculator/v0/subtraction?firstOpetator=&secondOperator=
> example : 'http://localhost:8080/calculator/v0/subtraction?firstOpetator=12&secondOperator=1'

Parámetros:
firstOpetator. primer operador.
secondOperator segundo operador.
---
> GET calculator/v0/division?firstOpetator=&secondOperator=
> example : 'http://localhost:8080/calculator/v0/division?firstOpetator=12&secondOperator=2'

Parámetros:
firstOpetator. primer operador.
secondOperator segundo operador.
---
Ejecucion de la aplicación 

abrir una consola del sistema y situarse en la raiz del proyecto y ejecutar el comando:
java -jar target/calculadora-0.0.1-SNAPSHOT.jar

ejemplo:

C:\Sanitas\calculadora> java -jar target/calculadora-0.0.1-SNAPSHOT.jar

---
swagger:
http://localhost:8080/swagger-ui/index.html#/


