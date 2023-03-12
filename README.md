# API REST INVENTORY

### Logica:
Este servicio permitira la administracion de los empleados vacunados como no vacunados de la empresa **KRUGER**
------------------------------------------------------------------------------------------------------------

## Desplegar Servicio
Antes de desplegar el servicio se debe considerar la instalaccion de las siguientes herramientas:
* [JDK11](https://adoptopenjdk.net/)
* [Maven](https://maven.apache.org/download.cgi)
* [Docker](https://docs.docker.com/desktop/windows/install/)

Una vez instaladas las herramientas se procede a:
1. Crear una carpeta vacia
2. Descargar del repositorio [GitHub](https://github.com/jbroncano/PruebaKruger.git) en la carpeta
3. Una vez descargado abrir una terminal en la direccion de la carpeta
4. Ponerse en la carpeta raiz del proyecto
5. Para generar el .jar de nuestro servicio debe ejecutar el siguiente comando:
    * mvn clean install
6. Para levantar el servicio en un contenedor:
    1. Acceder a la carpeta docker
    2. Debe ejecutar el siguiente comando: **docker-compose -f app-inventory.yml up -d**, esto levantara el contenedor servicio
7. Para comprobar que el servicio se levanto, ejecutar el siguiente comando:
    * docker ps, el cual le mostrara dos contenedores:
        1. Base de datos
        2. Servicio de Spring Boot
8. Para poder visualizar la documentacion de Swagger, se debe dirigir a la siguente [ruta](http://localhost:8090/api/v1/swagger-ui.html)
9. Podra ejecutar los servicios.

