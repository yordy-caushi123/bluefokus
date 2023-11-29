# Proyecto Spring Boot: Tipo de Cambio

Este proyecto Spring Boot proporciona un servicio para gestionar tipos de cambio.

## Requisitos Previos

Asegúrate de tener instalados los siguientes requisitos:

- [Java JDK 8 o superior](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)

## Configuración del Proyecto

1. Clona el repositorio:

    bash
    git clone https://github.com/yordy-caushi123/bluefokus.git
    

2. Navega al directorio del proyecto:

    bash
    cd solucion
    

## Levantar el Proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. Compila el proyecto con Maven:

    bash
    mvn clean install
    

2. Ejecuta la aplicación Spring Boot:

    bash
    mvn spring-boot:run
    

3. La aplicación estará disponible en `http://localhost:8080`.

## Uso del Servicio de Tipo de Cambio

### Crear un Tipo de Cambio

Envía una solicitud POST a la siguiente URL:

```bash
http://localhost:8080/api/tipo-cambio
{
  "monto": 200.0,
  "monedaOrigen": "USD",
  "monedaDestino": "EUR",
  "tasaCambio": 0.85,
  "montoCambiado": 170.0
}
#### Ver el Tipo de Cambio creado
Envía una solicitud GET a la siguiente URL:
```bash
http://localhost:8080/api/tipo-cambio

